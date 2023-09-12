package com.example.spring_project.generics;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GenericService<T extends BaseEntity> {
    @Autowired
    private GenericRepository<T> genericRepository;

    public T save(T entity) throws Exception {
        try {
            return genericRepository.save(entity);
        } catch (Exception e) {
            throw e;
        }
    }

    public T update(T entity) throws Exception {
        try {
            Optional<T> getEntity = genericRepository.findById(entity.getId());
            return genericRepository.save(entity);
        } catch (Exception e) {
            throw e;
        }
    }

    public Optional<T> findById(Long id) throws Exception{
        try{
            return genericRepository.findById(id);
        }catch (Exception e){
            throw e;
        }
    }

    public List<T> findAll() throws Exception {
        try {
            return genericRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteById(Long id) throws Exception {
        try {
            genericRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }


}
