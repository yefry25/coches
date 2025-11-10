package com.gestion.coches.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gestion.coches.Entities.Cliente;
import com.gestion.coches.Service.ClienteService;

@Component
public class ClienteConverter implements Converter<String, Cliente> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public Cliente convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return clienteService.obtenerPorId(Long.valueOf(id));
    }
}
