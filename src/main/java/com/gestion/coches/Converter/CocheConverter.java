package com.gestion.coches.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gestion.coches.Entities.Coche;
import com.gestion.coches.Service.CocheService;

@Component
public class CocheConverter implements Converter<String, Coche> {

    @Autowired
    private CocheService cocheService;

    @Override
    public Coche convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return cocheService.obtenerPorId(Long.valueOf(id));
    }
}
