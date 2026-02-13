package com.sgambiental.sg_ambiental_usuarios;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

/**
 * Evidencia: GA7-220501096-AA5-EV01
 * Diseño y desarrollo de servicio web para Registro e Inicio de Sesión.
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") 
public class UsuarioController {

    // Base de datos simulada en memoria para cumplir con el registro y login
    private static Map<String, String> baseDeDatosUsuarios = new HashMap<>() {{
        put("admin", "1234"); // Usuario predeterminado para pruebas
    }};

    /**
     * Servicio de Registro: recibe usuario y contraseña y los guarda en el mapa.
     */
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Map<String, String> datos) {
        String usuario = datos.get("usuario");
        String password = datos.get("password");
        
        baseDeDatosUsuarios.put(usuario, password);
        
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Usuario registrado exitosamente");
        return ResponseEntity.ok(respuesta);
    }

    /**
     * Servicio de Login: Valida si las credenciales son correctas.
     * Devuelve "Autenticación satisfactoria" o "Error en la autenticación".
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {
        String usuario = datos.get("usuario");
        String password = datos.get("password");

        Map<String, String> respuesta = new HashMap<>();

        // Lógica de validación requerida por la guía
        if (baseDeDatosUsuarios.containsKey(usuario) && baseDeDatosUsuarios.get(usuario).equals(password)) {
            respuesta.put("mensaje", "Autenticación satisfactoria");
            return ResponseEntity.ok(respuesta);
        } else {
            respuesta.put("mensaje", "Error en la autenticación");
            // Código 401: No autorizado
            return ResponseEntity.status(401).body(respuesta);
        }
    }
}