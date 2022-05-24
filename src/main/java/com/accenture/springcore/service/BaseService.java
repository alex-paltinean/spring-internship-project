package com.accenture.springcore.service;

import com.accenture.springcore.exception.FieldNotValidException;
import com.accenture.springcore.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public abstract class BaseService<T extends BaseEntity, ID> {

    private BaseRepository<T, ID> repository;

    @Autowired
    public void setRepository(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    public abstract boolean validateEntity(T entity);

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(ID id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public T update(T entity) {
        if (validateEntity(entity)) {
            return repository.save(entity);
        } else {
            throw new FieldNotValidException("asda", "sadada");
        }
    }

}
