package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class Restaurant implements IsetearRest{
        private ArrayList<Mesa> listMesas;
    private List<Cliente> listClientes;
    private static Double recaudacion;
    private List<Empleado> setEmpleados;

    private HashMap<Integer,Plato> menuDePlatos;

    public Restaurant() {
        listClientes = new ArrayList<>();
        listMesas = new ArrayList<>();
        setEmpleados = new ArrayList<>();
        menuDePlatos = new HashMap<>() {};
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

    public void setearMozos() {
        setEmpleados.add(new Mozo("Agustin", "Correa"));
        setEmpleados.add(new Mozo("Agustin", "Ledesma"));
        setEmpleados.add(new Mozo("Pablo", "Perez"));

    }

    public void agregarMesa(Mesa mesa) {
        listMesas.add(mesa);
    }

    public void eliminarMesa(int numMesa) {
        int i = 0;
        boolean flag = false;
        while (i < listMesas.size() && flag != true) {
            if (listMesas.get(i).getNumeroDeMesa() == numMesa) {
                listMesas.remove(i);
                flag = true;
            }
        }
    }

    public Mesa buscarMesa(int numMesa) {
        int i = 0;
        boolean flag = false;
        while (i < listMesas.size() && flag != true) {
            if (listMesas.get(i).getNumeroDeMesa() == numMesa) {
                return listMesas.get(i);
            }
            i++;
        }
        return null;
    }

    public void agregarEmpleado(Empleado empleado) {
        setEmpleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado e) {
        if (setEmpleados.contains(e)) {
            setEmpleados.remove(e);
        } else {
            System.out.println("El empleado no se encontro");
        }
    }

    public void mostrarEmpleados() {
        for (Empleado e : setEmpleados) {
            System.out.println(e.toString());
        }
    }

    public void agregarCliente(Cliente cliente) {
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

    public void ocuparMesa(int numMesa) {
        int i = 0;
        boolean flag = false;
        while (i < listMesas.size() && flag != true) {
            if (listMesas.get(i).getNumeroDeMesa() == numMesa) {
                listMesas.get(i).setOcupada(true);
                flag = true;
            }
            i++;
        }
    }

    public void desocuparMesa(int numMesa) {
        int i = 0;
        boolean flag = false;
        while (i < listMesas.size() && flag != true) {
            if (listMesas.get(i).getNumeroDeMesa() == numMesa) {
                listMesas.get(i).setOcupada(false);
                flag = true;
            }
            i++;
        }
    }

    public double pedirCuenta(int numMesa) {
        Mesa mesa = buscarMesa(numMesa);
        desocuparMesa(numMesa);
        double gastadoMesa = mesa.sumarGastadoMesa();
        setRecaudacion(gastadoMesa);
        return gastadoMesa;
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
                    mesa.getPedido().agregarPlato(plato);
                }catch (NullPointerException ex) {
                    System.out.println("El numero de mesa al que se quiere agregar el plato no existe");
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

                return mesaAux.getNumeroDeMesa();

            } catch (InputMismatchException e1) {
                System.out.println("Ingrese un caracter valido");

            }
        } while (flag == false);
        return 0;
    }


    class MesaNoEncontrada extends Exception{

        public MesaNoEncontrada(){};

        public MesaNoEncontrada (String msj_error){
            super (msj_error);
        }
    }



}
