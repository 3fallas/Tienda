package com.tienda_l.tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda_l.tienda.domain.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long>{
    
}
