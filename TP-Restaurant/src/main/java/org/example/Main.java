package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
       Restaurant res = new Restaurant();
        res.setearMozos();
        res.setearPlatos();
        res.setearMesas();

        res.agregarPlatoAMesa(1);
        res.mostrarPlatosEnMesa(1);
    }
}