package com.sgambiental.sg_ambiental_usuarios; // 1. Siempre primero el package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 2. Las anotaciones de la clase van justo aquí:
@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/usuarios")
public class HolaController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public String crearUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Usuario " + usuario.getNombre() + " guardado con éxito.";
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario con ID " + id + " eliminado correctamente.";
    }
}