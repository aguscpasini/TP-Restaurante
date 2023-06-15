package org.example;

public class Mozo extends Empleado {
    private Integer propina;

    public Mozo(String nombre, String apellido) {
        super(nombre, apellido);
        propina=0;
    }

    public Integer getPropina() {
        return propina;
    }

    public void setPropina(Integer propina) {
        this.propina = propina;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nPropina:" + propina;
    }
}
