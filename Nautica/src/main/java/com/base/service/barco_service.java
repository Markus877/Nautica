package com.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.model.barco;
import com.base.repository.barco_repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class barco_service {
	
    @Autowired
    private barco_repository barco_repository;
    
    @Autowired
    private salida_service salida_service;
    
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    
    /*public static boolean getBarcosPorNombre(String nombre) {
        return com.base.repository.barco_repository.findByNombre(nombre);
    }*/
    public barco getBarcoPorNombre(String nombre) {
        return barco_repository.getNombres(nombre);
    }

    
    public List<barco> findAll() {
        return barco_repository.findAll();
    }

    public Optional<barco> findById(Long id) {
        return barco_repository.findById(id);
    }

    public barco create(barco barco) {
        return barco_repository.save(barco);
    }
    
    public barco update(barco barco) {
        return barco_repository.save(barco);
    }

    public void deleteByAmarre(String amarre) {
    	List<Long> ids=barco_repository.getIdByAmarre(amarre);
    	ids.forEach(id -> salida_service.deleteByBarcoIds(id));
        barco_repository.deleteByAmarre(amarre);
    }
    

    public List<barco> findBarcosByCriteria(String nombre, String matricula, String amarre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<barco> cq = cb.createQuery(barco.class);
        Root<barco> barco = cq.from(barco.class);

        Predicate nombrePredicate = cb.equal(barco.get("nombre"), nombre);
        Predicate matriculaPredicate = cb.equal(barco.get("matricula"), matricula);
        Predicate amarrePredicate = cb.equal(barco.get("amarre"), amarre);

        cq.where(cb.and(nombrePredicate, matriculaPredicate, amarrePredicate));

        return entityManager.createQuery(cq).getResultList();
    }


}
