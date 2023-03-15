package com.tienda_l.tienda.domain;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private Long idArticulo;

    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo;
    
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private Categoria  categoria;
    

    public Articulo() {
    }


    public Articulo(String descripcion, String detalle, double precio, int existencias, boolean activo,
            Categoria categoria) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
        this.categoria = categoria;
    }

    

    

}
