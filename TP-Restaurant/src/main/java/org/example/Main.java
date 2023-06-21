package org.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.example.Excepciones.MesaNoEncontrada;

public class Main {
    public static void main(String[] args)  {

       Restaurant res = new Restaurant();

       HashMap<Integer,Plato>menuPlatos=res.setearPlatos();
       ArrayList<Mesa> Mesas = res.setearMesas();
        ArrayList<Mozo> Mozos = res.setearMozos();



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



        Mozos.forEach(j -> {
            System.out.printf("Mozo numero: %d . Nombre: %s . Apellido: %s . Salario: %f .\n", j.getId(), j.getNombre(), j.getApellido(), j.salario);
        });




       Integer aux = null;

        try {
            aux = res.ingresarYBuscarMesa();
        } catch (MesaNoEncontrada e) {
            System.out.println("Mesa no encontrada");
        }

        res.agregarPlatoAMesa(aux);
        res.mostrarPlatosEnMesa(aux);

}
    }

