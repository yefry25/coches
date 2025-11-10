package com.gestion.coches.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.coches.Entities.Motor;
import com.gestion.coches.Repository.MotorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MotorService {

    @Autowired
    private MotorRepository motorRepository;

    public List<Motor> listarTodos() {
        return motorRepository.findAll();
    }

    public Motor guardar(Motor coche) {
        return motorRepository.save(coche);
    }

    public Motor obtenerPorId(Long id) {
        return motorRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        motorRepository.deleteById(id);
    }
}
