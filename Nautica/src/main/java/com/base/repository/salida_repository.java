package com.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.model.salida;

@Repository
public interface salida_repository extends JpaRepository<salida, Long> {
}
