package com.tienda_l.tienda.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda_l.tienda.dao.ArticuloDao;
import com.tienda_l.tienda.domain.Articulo;

import services.ArticuloService;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloDao ArticuloDao;

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>)ArticuloDao.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Articulo getArticulos(Articulo Articulo) {
       return ArticuloDao.findById(Articulo.getIdArticulo()).orElse(null);
    }

    
    @Override
    @org.springframework.transaction.annotation.Transactional
    public void save(Articulo Articulo) {
       ArticuloDao.save(Articulo);        
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void delete(Articulo Articulo) {
        ArticuloDao.delete(Articulo);
        
    }
    

}
