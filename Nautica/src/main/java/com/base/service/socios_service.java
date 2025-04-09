package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.model.socios;
import com.base.repository.socios_repository;

@Service
public class socios_service {

    @Autowired
    private socios_repository socios_repository;

    public List<socios> findAll() {
        return socios_repository.findAll();
    }

    public Optional<socios> findById(Long id) {
        return socios_repository.findById(id);
    }

    public socios save(socios socio) {
        return socios_repository.save(socio);
    }

    public socios update(socios socio) {
        return socios_repository.save(socio);
    }
    
    
    public void deleteById(Long id) {
    	socios_repository.deleteById(id);
    }
}
