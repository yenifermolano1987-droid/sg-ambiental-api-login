package com.sgambiental.sg_ambiental_usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aquí no escribimos código. 
    // JpaRepository ya sabe cómo hacer: save(), findAll(), delete(), etc.
}
