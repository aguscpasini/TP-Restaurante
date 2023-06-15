package org.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

       Restaurant res = new Restaurant();
       res.setearMozos();
       HashMap<Integer,Plato>menuPlatos=res.setearPlatos();
       ArrayList<Mesa> Mesas = res.setearMesas();

        for (Plato p :menuPlatos.values()) {
            System.out.println(p.toString());
        }



       Mesas.forEach(i -> {
           if (i.ocupada) {
               System.out.printf("Mesa número: %d de %d personas, se encuentra OCUPADA. Su mozo se llama %s %s.\n Los platos que están comiendo son: \n", i.numMesa, i.getCapacidad(), i.mozo.getNombre(), i.mozo.getApellido());
               i.pedido.listPlatos.forEach(p -> {
                   System.out.printf("- %s \n" , p.nombre );
               });
           }else{
               System.out.printf("Mesa número: %d de %d personas, se encuentra DESOCUPADA. Su mozo se llama %s %s.\n", i.numMesa, i.getCapacidad(), i.mozo.getNombre(), i.mozo.getApellido());
           }
       });

       Integer aux = null;

        try {
            aux = res.ingresarYBuscarMesa();
        } catch (Restaurant.MesaNoEncontrada e) {
            System.out.println("Mesa no encontrada");
        }

        res.agregarPlatoAMesa(aux);
        res.mostrarPlatosEnMesa(aux);

}

    }
