package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    public static int numMesa;
    private int numeroDeMesa;
    private int capacidad;
    public Boolean ocupada;
    public Mozo mozo;
    public Pedido pedido;
    private Double propina;
    private Double recaudacionTotal;
    private Double recaudacionParcial;


    public double sumarGastadoMesa (){
        return pedido.sumarGastado();
    }

    public Mesa(int capacidad, Mozo mozo) {
        numMesa++;
        this.numeroDeMesa = numMesa;
        this.capacidad = capacidad;
        this.ocupada = false;
        this.mozo = mozo;

        this.pedido=new Pedido();


    }


    public Pedido getPedido() {

            return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }

    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }


    public Double getPropina() {
        return propina;
    }

    public void setPropina(Double propina) {
        this.propina = propina;
    }
}
