package com.tienda_l.tienda.domain;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data 
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private boolean activo;
   
    private Categoria categoria;

    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo){
        this.activo = activo;
        this.descripcion = descripcion;
    }
    
}
