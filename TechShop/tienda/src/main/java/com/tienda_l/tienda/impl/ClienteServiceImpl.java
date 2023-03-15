package com.tienda_l.tienda.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda_l.tienda.dao.ClienteDao;
import com.tienda_l.tienda.dao.CreditoDao;
import com.tienda_l.tienda.domain.Cliente;
import com.tienda_l.tienda.domain.Credito;

import services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private CreditoDao creditoDao;

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
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);

    }

}
