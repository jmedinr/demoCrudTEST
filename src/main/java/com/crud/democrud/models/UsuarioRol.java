package com.crud.democrud.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idRol;
    private String rol;

    public UsuarioRol() {
    }

    public UsuarioRol(Long idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
}