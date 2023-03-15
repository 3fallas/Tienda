package com.tienda_l.tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda_l.tienda.domain.Articulo;

public interface ArticuloDao extends JpaRepository<Articulo, Long> {

}
