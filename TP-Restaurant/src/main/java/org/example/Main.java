package org.example;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


       Restaurant res = new Restaurant();
       res.setearMozos();
       res.setearPlatos();
       res.setearMesas();

///pasar esto a funcion

      boolean flag = false;
      do {
            try {
                Mesa mesaAux = null;
                do {
                    Scanner scMesa = new Scanner(System.in);
                    System.out.println("Ingrese mesa destino:");
                    Integer numMesa = scMesa.nextInt();
                    mesaAux = res.buscarMesa(numMesa);

                    if (mesaAux == null) {
                    System.out.println("Mesa no encontrada");
                    }
                 } while (mesaAux == null);

                flag = true;

                res.agregarPlatoAMesa(mesaAux.getNumeroDeMesa());
                res.mostrarPlatosEnMesa(mesaAux.getNumeroDeMesa());

            }catch (InputMismatchException e1) {
                System.out.println("Ingrese un caracter valido");
                flag = false;
            }
      }while (flag == false);




    }
    }
