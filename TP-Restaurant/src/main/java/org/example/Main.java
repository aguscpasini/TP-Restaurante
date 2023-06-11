package org.example;

public class Main {
    public static void main(String[] args)  {


       Restaurant res = new Restaurant();
       res.setearMozos();
       res.setearPlatos();
       res.setearMesas();

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
