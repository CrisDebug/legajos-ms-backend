package com.software.microservicio_legajo_backend.repository;

import com.software.microservicio_legajo_backend.entity.Legajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegajoRepository extends JpaRepository<Legajo, Long> {
}