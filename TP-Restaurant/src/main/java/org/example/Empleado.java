package org.example;

public class Empleado extends Persona{
    private static int idEmple;
    private int id;
    private Double salario;

    public Empleado(String nombre, String apellido) {
        super(nombre, apellido);
        idEmple++;
        id=idEmple;
        this.salario=120000.0;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return
                super.toString()+
                "\nSalario:" + salario;
    }
}
