package com.crud.democrud.models;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String email;
    private Integer prioridad;

    @OneToOne(mappedBy = "usuarios", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private UsuarioRol usuarioRol;

    public UsuarioModel() {

    }

    public UsuarioModel(String nombre, String email, Integer prioridad, UsuarioRol usuarioRol) {
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
        this.usuarioRol = usuarioRol;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioRol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }
}