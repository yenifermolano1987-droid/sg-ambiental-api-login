package com.sgambiental.sg_ambiental_usuarios;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/residuos")
@CrossOrigin(origins = "*")
public class ResiduoController {

    // Lista simulada de registros ambientales
    private List<Map<String, String>> listaResiduos = new ArrayList<>();

    // 1. Obtener todos los registros
    @GetMapping("/listar")
    public List<Map<String, String>> listar() {
        return listaResiduos;
    }

    // 2. Crear un nuevo registro de residuo
    @PostMapping("/guardar")
    public Map<String, String> guardar(@RequestBody Map<String, String> nuevoResiduo) {
        nuevoResiduo.put("id", UUID.randomUUID().toString()); // Genera un ID único
        nuevoResiduo.put("fecha", new Date().toString());
        listaResiduos.add(nuevoResiduo);
        
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Residuo registrado en SG-Ambiental exitosamente");
        return respuesta;
    }
}