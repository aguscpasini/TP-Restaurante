package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Pedido {

   public ArrayList<Plato> listPlatos;

    public Pedido() {
        this.listPlatos = new ArrayList<Plato>();
    }

    public ArrayList<Plato> getListPlatos() {
        return listPlatos;
    }

    public double sumarGastado(){
        double gastado=0;
        for (Plato p:listPlatos) {
            gastado= gastado+p.getPrecio();
        }
        return gastado;
    }
    public void agregarPlato(Plato platito){
        listPlatos.add(platito);
    }

    public void mostrarPlatos (){

        try {

            for (Plato p : listPlatos) {
                System.out.println(p.getNombre());
            }
        }catch (NullPointerException e){
            System.out.println("Un plato ingresado no existe en la carta");
        }

    }
}
