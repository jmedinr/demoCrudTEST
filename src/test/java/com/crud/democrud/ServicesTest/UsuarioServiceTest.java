package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.UsuarioRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioServiceTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void testGuardarUsuario(){
        List<UsuarioRol> listRol = new ArrayList<>();
        listRol.add(new UsuarioRol());
        UsuarioModel usuarioModel=new UsuarioModel("aquaman","aqua@gmail.com",99, listRol);
        UsuarioModel usuarioModelRegistrado = usuarioRepository.save(usuarioModel);
        assertNotNull(usuarioModelRegistrado);
    }

    @Test
    public void testBuscarUsuarioPorId(){
        Long idBuscado=1L;
        Optional<UsuarioModel> usuarioModelBuscado=usuarioRepository.findById(idBuscado);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testListarUsuarios(){
        List<UsuarioModel> usuarioModelList=(List<UsuarioModel>) usuarioRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(0);
    }

    //Nuevo Test Junit
    @Test
    public void testModificarUsuarios(){
        List<UsuarioRol> listRol = new ArrayList<>();
        listRol.add(new UsuarioRol());
        UsuarioModel usuarioModel = new UsuarioModel("guaruma","guarumo@gmail.com",32, listRol);
        usuarioModel.setEmail("guaruma@gmail.com");
        usuarioModel.setNombre("guaromo");
        usuarioModel.setPrioridad(20);
    }

    //Mock
    @Mock
    private UsuarioRol usuarioRol;

    @Before
    public void setupMock(){
        usuarioRol = mock(UsuarioRol.class);
    }

    @Test
    public void testUsuarioRol(){
        when(usuarioRol.getRol()).thenReturn("Hi");
        assertEquals("Hi", usuarioRol.getRol());
    }
}