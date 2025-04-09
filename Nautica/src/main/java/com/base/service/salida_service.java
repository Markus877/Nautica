package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.model.salida;
import com.base.repository.salida_repository;

@Service
public class salida_service {

    @Autowired
    private salida_repository salida_repository;

    public List<salida> findAll() {
        return salida_repository.findAll();
    }

    public Optional<salida> findById(Long id) {
        return salida_repository.findById(id);
    }

    public salida create(salida salida) {
        return salida_repository.save(salida);
    }
    
    public salida update(salida salida) {
        return salida_repository.save(salida);
    }

    public void deleteById(Long id) {
    	salida_repository.deleteById(id);
    }
    
    public void deleteByBarcoIds(Long id) {
    	salida_repository.deleteByBarcoIds(id);
    }


}
