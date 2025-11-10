package com.gestion.coches.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.coches.Entities.Cliente;
import com.gestion.coches.Repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll()                       
                                    .stream()
                                    .filter(cliente -> cliente.getEliminado() == false)
                                    .collect(Collectors.toList());
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) { clienteRepository.deleteById(id); }
}
