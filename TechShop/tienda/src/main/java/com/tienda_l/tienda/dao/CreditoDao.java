package com.tienda_l.tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda_l.tienda.domain.Credito;

public interface CreditoDao extends JpaRepository<Credito, Long>{
    
}
