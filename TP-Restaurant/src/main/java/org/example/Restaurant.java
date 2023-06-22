package org.example;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.example.Excepciones.MesaNoEncontrada;
import org.example.Excepciones.PlatoInexistente;
import org.example.Excepciones.SinPlatos;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class Restaurant implements IsetearRest{
    private ArrayList<Mesa> listMesas;
    private List<Cliente> listClientes;
    private static Double recaudacion;
    private ArrayList<Mozo> listMozos;
    private HashMap<Integer,Plato> menuDePlatos;

    public Restaurant() {
        listClientes = new ArrayList<>();
        listMesas = new ArrayList<>();
        listMozos = new ArrayList<>();
        menuDePlatos = new HashMap<>();
        recaudacion = 0.0;
    }

    public Double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(Double recaudacion) {
        this.recaudacion += recaudacion;
    }



    public static String stream(URL url) {
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public HashMap<Integer,Plato> setearPlatos()  {
        try{
            String jsonString = stream(new URL("https://aguscpasini.github.io/jsonapitprestaurante/platos.json"));
            Gson gson = new Gson();
            Type PlatosHashMapType = new TypeToken<Map<Integer,Plato>>(){}.getType();
            menuDePlatos = gson.fromJson(jsonString, PlatosHashMapType);
            return (HashMap<Integer, Plato>) menuDePlatos;
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Mesa> setearMesas() {

        try {
            String jsonString = stream(new URL("https://aguscpasini.github.io/jsonapitprestaurante/mesas.json"));
            Gson gson = new Gson();
            Type MesasListType = new TypeToken<ArrayList<Mesa>>(){}.getType();
            listMesas = gson.fromJson(jsonString, MesasListType);

        return listMesas;
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<Mozo> setearMozos() {

        try {
            String jsonString1 = stream(new URL("https://aguscpasini.github.io/jsonapitprestaurante/mozos.json"));
            Gson gson1 = new Gson();
            Type MozoListType = new TypeToken<ArrayList<Mozo>>(){}.getType();
            listMozos = gson1.fromJson(jsonString1, MozoListType);

            return listMozos;
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
   }


    public void agregarMesa(Mesa mesa) {
        listMesas.add(mesa);
    }

    public void eliminarMesa(int numMesa) {
        int i = 0;
        boolean flag = false;
        while (i < listMesas.size() && flag != true) {
            if (listMesas.get(i).getNumMesa() == numMesa) {
                listMesas.remove(i);
                flag = true;
            }
        }
    }

    public Mesa buscarMesa(int numMesa) {
        int i = 0;
        boolean flag = false;
        while (i < listMesas.size() && flag != true) {
            if (listMesas.get(i).getNumMesa() == numMesa) {
                return listMesas.get(i);
            }
            i++;
        }
        return null;
    }

    public void agregarMozo(Mozo mozo) {
        listMozos.add(mozo);
    }

    public void eliminarMozo(Mozo e) {
        if (listMozos.contains(e)) {
            listMozos.remove(e);
        } else {
            System.out.println("El mozo no se encontro");
        }
    }

    public void mostrarMozo() {
        for (Mozo e : listMozos) {
            System.out.println(e.toString());
        }
    }

    public void agregarCliente(Cliente cliente)  {
        listClientes.add(cliente);

    }


    public void eliminarCliente(int id) {
        int i = 0;
        boolean flag = false;
        while (i < listClientes.size() && flag != true) {
            if (listClientes.get(i).getId() == id) {
                listClientes.remove(i);
                flag = true;
            }
            i++;
        }
    }

    public void mostrarClientes() {
        for (Cliente e : listClientes) {
            System.out.println(e.toString());
        }
    }

    public void ocuparMesa(int numMesa)throws MesaNoEncontrada {

        Mesa mesa = buscarMesa(numMesa);
        if(mesa == null){
            throw  new MesaNoEncontrada("Esta mesa no existe.");
        }else {
            mesa.setOcupada(true);
        }
    }

    public void desocuparMesa(int numMesa) {
        int i = 0;
        boolean flag = false;
        while (i < listMesas.size() && flag != true) {
            if (listMesas.get(i).getNumMesa() == numMesa) {
                listMesas.get(i).setOcupada(false);
                flag = true;
            }
            i++;
        }
    }

    public void pedirCuenta(int numMesa)throws SinPlatos,MesaNoEncontrada{
        Mesa mesa = buscarMesa(numMesa);
        if(mesa == null){
            throw new MesaNoEncontrada("Esta mesa no existe.");
        }else if (!mesa.getOcupada()){
            throw new SinPlatos("En esta mesa no hay platos cargados!");
        }
        desocuparMesa(numMesa);
        double gastadoMesa = mesa.sumarGastadoMesa();
        setRecaudacion(gastadoMesa);
        ArrayList<Plato>platosMesa= mesa.getPedido().getListPlatos();

        for (Plato p:platosMesa) {
            System.out.println(p.getNombre()+ " $"+p.getPrecio());
        }
        System.out.println("TOTAL: "+gastadoMesa);

    }

    public Plato buscarPlato(Integer codigo) {
        for (Plato p : menuDePlatos.values()) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public void agregarPlatoAMesa(int numMesa) {

            Scanner sc = new Scanner(System.in);
            Mesa mesa = buscarMesa(numMesa);
            String continuar = "s";
            Integer cod = 0;

            while (continuar.equals("s") && mesa != null) {

                System.out.println("Ingresa codigo de plato");
                cod = sc.nextInt();
                Plato plato = buscarPlato(cod);


                try {
                    if(plato == null) {
                        throw new PlatoInexistente("El codigo del plato no existe");
                    }
                    mesa.getPedido().agregarPlato(plato);
                } catch (NullPointerException ex) {
                    System.out.println("El numero de mesa al que se quiere agregar el plato no existe");
                }catch (PlatoInexistente e){
                    System.out.println(e.getMessage());
                }

                sc.nextLine();
                System.out.println("Vas a agregar otro? s para continuar");
                continuar = sc.nextLine();

            }

    }

    public void mostrarPlatosEnMesa (int numMesa){

        Mesa mesa = buscarMesa(numMesa);
        mesa.getPedido().mostrarPlatos();
    }

    public Integer ingresarYBuscarMesa() throws MesaNoEncontrada {

        boolean flag = false;
        do {
            try {
                Mesa mesaAux = null;
                do {
                    Scanner scMesa = new Scanner(System.in);
                    System.out.println("Ingrese mesa destino:");
                    Integer numMesa = scMesa.nextInt();
                    mesaAux = buscarMesa(numMesa);
                    try {
                    if (mesaAux == null) {

                        throw new MesaNoEncontrada();

                    }}catch (MesaNoEncontrada e2){
                            System.out.println("Mesa no encontrada");}

                } while (mesaAux == null);

                return mesaAux.getNumMesa();

            } catch (InputMismatchException e1) {
                System.out.println("Ingrese un caracter valido");

            }
        } while (flag == false);
        return 0;
    }




    public Double sumarRecaudacion(){

        try {

        Double recaudacion = (double) 0;
        for (Mesa p : listMesas){
            recaudacion += p.getRecaudacionTotal();
        }}catch (NullPointerException e){
            e.getMessage();
        }
        return recaudacion;
    }

    public void mostrarRecaudacion (Double recaudacion){
        System.out.println("La recaudacion total del Restaurante es de: " + recaudacion);
    }

}
