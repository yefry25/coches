package com.gestion.coches.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.coches.Entities.Coche;

public interface CocheRepository extends JpaRepository<Coche, Long> {}
