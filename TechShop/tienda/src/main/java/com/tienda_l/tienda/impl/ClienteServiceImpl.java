package com.tienda_l.tienda.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda_l.tienda.dao.ClienteDao;
import com.tienda_l.tienda.domain.Cliente;

import services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

    
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Cliente getClient(Cliente cliente) {
       return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    
    @Override
    @org.springframework.transaction.annotation.Transactional
    public void save(Cliente cliente) {
       clienteDao.save(cliente);        
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
        
    }
    

}
