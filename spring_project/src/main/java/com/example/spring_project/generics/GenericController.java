package com.example.spring_project.generics;

import com.example.spring_project.exception.ResourceNotFoundExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


public class GenericController<T extends BaseEntity> {
    @Autowired
    private GenericService<T> genericService;

    private final String OBJECT_NOT_FOUND = "No Object Found";

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody T entity) throws Exception {
        return new ResponseEntity<>(genericService.save(entity), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody T entity) throws Exception {
        Optional<T> getObject = genericService.findById(entity.getId());
        if (getObject.isPresent()) {
            return new ResponseEntity<>(genericService.update(entity), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundExceptionHandler(OBJECT_NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() throws Exception {
        return new ResponseEntity<>(genericService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(genericService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception {
        genericService.deleteById(id);
        return new ResponseEntity<>("Delete Successfully!", HttpStatus.OK);
    }
}
