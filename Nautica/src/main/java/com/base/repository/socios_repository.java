package com.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.model.socios;

@Repository
public interface socios_repository extends JpaRepository<socios, String> {
}
