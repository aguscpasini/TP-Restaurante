package org.example;

public class Cliente extends Persona{

    public Integer contadorDeVisitas;

    public Cliente(String nombre, String apellido) {
        super(nombre, apellido);
        this.contadorDeVisitas = 1;

    }


    public Integer getContadorDeVisitas() {
        return contadorDeVisitas;
    }

    public void setContadorDeVisitas(Integer contadorDeVisitas) {
        this.contadorDeVisitas = contadorDeVisitas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nID:" + getId() +
                "\nContador de visitas:" + contadorDeVisitas;
    }
}
