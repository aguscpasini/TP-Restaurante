package org.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

       try {

           URL url = new URL("https://aguscpasini.github.io/jsonapitprestaurante/db.json");

           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           conn.setRequestMethod("GET");
           conn.connect();

           int responseCode = conn.getResponseCode();
           if (responseCode != 200){
                throw new RuntimeException("Ocurrio un error " + responseCode);
           }else{
                StringBuilder informacion = new StringBuilder();
                Scanner sc3 = new Scanner(url.openStream());

                while (sc3.hasNext()){
                    informacion.append(sc3.nextLine());
                }

                sc3.close();

               System.out.println(informacion);
           }

       }catch (Exception eee) {
           eee.printStackTrace();
       }

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
