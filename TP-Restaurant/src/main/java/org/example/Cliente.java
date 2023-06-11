package org.example;

public class Cliente extends Persona{
    private static int idCliente;
    private int id;
    private Integer contadorDeVisitas;

    public Cliente(String nombre, String apellido) {
        super(nombre, apellido);
        this.contadorDeVisitas = 1;
        idCliente++;
        id=idCliente;
    }

    public int getId() {
        return id;
    }



    public Integer getContadorDeVisitas() {
        return contadorDeVisitas;
    }

    public void setContadorDeVisitas(Integer contadorDeVisitas) {
        this.contadorDeVisitas = contadorDeVisitas;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nID:" + id +
                "\nContador de visitas:" + contadorDeVisitas;
    }
}
