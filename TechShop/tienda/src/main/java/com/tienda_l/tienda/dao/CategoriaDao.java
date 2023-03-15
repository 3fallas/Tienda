package com.tienda_l.tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda_l.tienda.domain.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {

}
