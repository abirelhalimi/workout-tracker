package com.aeh.workout_tracker.services.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aeh.workout_tracker.services.GenericService;

import jakarta.persistence.EntityNotFoundException;

@Service
public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {
    
    protected abstract CrudRepository<T, ID> repository();

    @Override
    public void deleteById(ID id) {
        repository().deleteById(id);     
    }

    @Override
    public Iterable<T> findAll() {
        return repository().findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository().findById(id);
    }

    @Override
    public T save(T entity) {
        return repository().save(entity);
    }

    @Override
    public T update(ID id, T updatedEntity) {
        T existingEntity = repository().findById(id).orElseThrow(() -> new EntityNotFoundException());
        String[] propertiesToIgnore = getNullPropertyNames(updatedEntity);
        BeanUtils.copyProperties(updatedEntity, existingEntity, propertiesToIgnore);
        return repository().save(existingEntity);
    }

    
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        return Arrays.stream(pds)
            .map(pd -> pd.getName())
            .filter(propertyName ->
                propertyName.equals("id") ||
                src.getPropertyValue(propertyName) == null
            )
        .toArray(String[]::new);
    }

}
