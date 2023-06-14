package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private static int numMesa;
    private int numeroDeMesa;
    private int capacidad;
    private Boolean ocupada;
    private Mozo mozo;
    private Pedido pedido;
    private Double propina;
    private Double recaudacionTotal;
    private Double recaudacionParcial;


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

    public Double getRecaudacionTotal() {
        return recaudacionTotal;
    }

    public void setRecaudacionTotal(Double recaudacionParcial) {
        this.recaudacionTotal = recaudacionTotal+ recaudacionParcial;
    }

    public Double getRecaudacionParcial() {
        return recaudacionParcial;
    }

    public void setRecaudacionParcial(Double recaudacionParcial) {
        this.recaudacionParcial = recaudacionParcial;
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
    public double sumarGastadoMesa (){
        return pedido.sumarGastado();
    }


}
