package com.tienda_l.tienda.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda_l.tienda.dao.CategoriaDao;
import com.tienda_l.tienda.domain.Categoria;

import services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao CategoriaDao;

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>)CategoriaDao.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Categoria getCategoria(Categoria Categoria) {
       return CategoriaDao.findById(Categoria.getIdCategoria()).orElse(null);
    }

    
    @Override
    @org.springframework.transaction.annotation.Transactional
    public void save(Categoria Categoria) {
       CategoriaDao.save(Categoria);        
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void delete(Categoria Categoria) {
        CategoriaDao.delete(Categoria);
        
    }
    

}
