package org.example;

public class Empleado extends Persona{

    public Double salario;

    public Empleado(String nombre, String apellido) {
        super(nombre, apellido);

        this.salario=120000.0;
    }

    public Empleado(String nombre, String apellido, Double salario) {
        super(nombre, apellido);
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }





    @Override
    public String toString() {
        return
                super.toString()+
                "\nSalario:" + salario;
    }
}
