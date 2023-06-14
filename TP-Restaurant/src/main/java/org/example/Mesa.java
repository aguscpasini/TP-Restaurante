package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    public int numMesa;
    public int numeroDeMesa;
    public int capacidad;
    public Boolean ocupada;
    public Mozo mozo;

    public Pedido pedido;


    public Double propina;



    public double sumarGastadoMesa (){
        return pedido.sumarGastado();
    }

    public Mesa(int numMesa, int numeroDeMesa, int capacidad, Boolean ocupada, Mozo mozo, Pedido pedido, Double propina) {
        this.numMesa = numMesa;
        this.numeroDeMesa = numeroDeMesa;
        this.capacidad = capacidad;
        this.ocupada = ocupada;
        this.mozo = mozo;
        this.pedido = pedido;
        this.propina = propina;
    }

    public Mesa(){

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
