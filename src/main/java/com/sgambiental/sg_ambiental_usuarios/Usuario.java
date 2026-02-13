package com.sgambiental.sg_ambiental_usuarios;

import jakarta.persistence.*; // Importante: Esto trae las etiquetas de base de datos

@Entity // Le dice a Spring que esta clase debe ser una tabla llamada "Usuario"
public class Usuario {

    @Id // Define que este campo es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hace que el ID se genere solo (1, 2, 3...)
    private Long id;

    private String nombre;
    private String correo;

    // Constructor vacío (Ya lo tenías, ¡perfecto!)
    public Usuario() {}

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters y Setters
    // Añadimos los del ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}