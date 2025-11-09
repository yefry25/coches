package com.gestion.coches.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.coches.Entities.Coche;
import com.gestion.coches.Repository.CocheRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CocheService
{
    @Autowired
    private CocheRepository cocheRepository;

    public List<Coche> listarTodos() {
        return cocheRepository.findAll();
    }

    public Coche guardar(Coche coche) {
        return cocheRepository.save(coche);
    }

    public Coche obtenerPorId(Long id) {
        return cocheRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) { cocheRepository.deleteById(id); }
}
