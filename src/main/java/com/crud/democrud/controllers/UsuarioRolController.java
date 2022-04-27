package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class UsuarioRolController {
    @Autowired
    UsuarioRolService usuarioRolService;

    @GetMapping()
    public ArrayList<UsuarioRol> obtenerUsuarios() {
        return usuarioRolService.obtenerRoles();
    }

    @PostMapping()
    public UsuarioRol guardarRol(@RequestBody UsuarioRol rol) {
        return this.usuarioRolService.guardarRol(rol);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioRol> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioRolService.obtenerPorId(id);
    }

    @GetMapping("/query-rol")
    public ArrayList<UsuarioRol> obtenerUsuarioPorPrioridad(@RequestParam("rol") String rol) {
        return this.usuarioRolService.obtenerPorRol(rol);
    }

    @PutMapping("/cambiarlo/{id}")
    UsuarioRol replaceRol(@RequestBody UsuarioRol newRol, @PathVariable Long id) {

        return usuarioRolService.obtenerPorId(id)
                .map(usuario -> {
                    usuario.setRol(newRol.getRol());
                    return guardarRol(usuario);
                })
                .orElseGet(() -> {
                    newRol.setIdRol(id);
                    return guardarRol(newRol);
                });
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioRolService.eliminarRol(id);
        if (ok) {
            return "Se eliminó el rol con id " + id;
        } else {
            return "No pudo eliminar el rol con id" + id;
        }
    }

}