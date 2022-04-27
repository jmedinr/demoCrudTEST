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

    @JoinColumn(name = "usuarios_id")
    @OneToOne(fetch = FetchType.LAZY)
    private UsuarioModel usuarios;

    public UsuarioRol() {
    }

    public UsuarioRol(Long idRol, String rol, UsuarioModel usuarios) {
        this.idRol = idRol;
        this.rol = rol;
        this.usuarios = usuarios;
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

    public UsuarioModel getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuarioModel usuarios) {
        this.usuarios = usuarios;
    }
}