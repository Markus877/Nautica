package com.base.repository;

import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.model.barco;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public interface barco_repository extends JpaRepository<barco, Long> {
    
    @Query("select b from barco b where b.nombre= :nombre")
    barco getNombres(String nombre);

    @Transactional 
    @Modifying
    @Query("DELETE FROM barco b WHERE b.amarre = ?1")
    void deleteByAmarre(String amarre);

    @Query("SELECT b.id_barco FROM barco b WHERE b.amarre = ?1")
    List<Long> getIdByAmarre(String amarre);
}
