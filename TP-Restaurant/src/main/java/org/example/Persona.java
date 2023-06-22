package org.example;

public abstract class Persona {
    private static int idPersona;
    public int id;
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        idPersona++;
        this.id=idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return
                "\nNombre: " + nombre +
                "\nApellido: " + apellido;
    }
}
