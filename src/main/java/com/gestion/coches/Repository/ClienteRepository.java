package com.gestion.coches.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.coches.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
