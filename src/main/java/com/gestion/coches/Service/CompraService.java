package com.gestion.coches.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.coches.Entities.Compra;
import com.gestion.coches.Repository.CompraRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

        public List<Compra> listarTodos() {
        return compraRepository.findAll();
    }

    public Compra guardar(Compra compra) {
        return compraRepository.save(compra);
    }

    public Compra obtenerPorId(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) { compraRepository.deleteById(id); }
}
