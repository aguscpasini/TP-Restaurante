package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    public  int numMesa;
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

        this.capacidad = capacidad;
        this.ocupada = false;
        this.mozo = mozo;
        this.recaudacionParcial = (double) 0;
        this.recaudacionTotal = this.recaudacionTotal + recaudacionParcial;
        this.pedido=new Pedido();


    }

    public Pedido getPedido() {

            return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
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



    public Double getRecaudacionTotal() {
        return recaudacionTotal;
    }

    public void setRecaudacionTotal(Double recaudacionTotal) {
        this.recaudacionTotal = recaudacionTotal;
    }

    public Double getRecaudacionParcial() {
        return recaudacionParcial;
    }

    public void setRecaudacionParcial(Double recaudacionParcial) {
        this.recaudacionParcial = recaudacionParcial;
    }

}
