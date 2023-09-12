package com.example.spring_project.generics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


public class GenericController<T extends BaseEntity> {
    @Autowired
    private GenericService<T> genericService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody T entity) {
        try {
            return new ResponseEntity<>(genericService.save(entity), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error to save!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody T entity) {
        try {
            Optional<T> getObject = genericService.findById(entity.getId());
            if(getObject.isPresent()){
                return new ResponseEntity<>(genericService.update(entity), HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No object found", HttpStatus.OK) ;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error to save!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(genericService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error to get all objects!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(genericService.findById(id),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error to find this object!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            genericService.deleteById(id);
            return new ResponseEntity<>("Delete Successfully!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error to delete!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
