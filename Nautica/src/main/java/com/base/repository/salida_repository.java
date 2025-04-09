package com.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.base.model.salida;

import jakarta.transaction.Transactional;

@Repository
public interface salida_repository extends JpaRepository<salida, Long> {

	@Modifying
	@Transactional 
	@Query("DELETE FROM salida s WHERE s.barco.id IN ?1")
	void deleteByBarcoIds(Long id);

}
