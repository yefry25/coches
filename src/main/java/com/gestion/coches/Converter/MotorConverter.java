package com.gestion.coches.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gestion.coches.Entities.Motor;
import com.gestion.coches.Service.MotorService;

@Component
public class MotorConverter implements Converter<String, Motor> {

    @Autowired
    private MotorService motorService;

    @Override
    public Motor convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return motorService.obtenerPorId(Long.valueOf(id));
    }
}
