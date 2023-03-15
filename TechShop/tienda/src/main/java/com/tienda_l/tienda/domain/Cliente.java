package com.tienda_l.tienda.domain;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data 
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    private String nombre, apellidos, correo, telefono;
    @JoinColumn(name = "id_credito", referencedColumnName = "id_credito")
    @ManyToOne
    private Credito credito;

    public Cliente() {
    }
    
    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }

    
    
}
