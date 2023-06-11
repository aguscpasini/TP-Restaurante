package org.example;

import java.util.*;

public class Restaurant implements IsetearRest{
        private List<Mesa> listMesas;
    private List<Cliente> listClientes;
    private static Double recaudacion;
    private List<Empleado> setEmpleados;

    private Map<Integer, Plato> menuDePlatos;

    public Restaurant() {
        listClientes = new ArrayList<>();
        listMesas = new ArrayList<>();
        setEmpleados = new ArrayList<>();
        menuDePlatos = new HashMap<>();
        recaudacion = 0.0;
    }

    public Double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(Double recaudacion) {
        this.recaudacion += recaudacion;
    }

    public void setearPlatos() {
        Plato plato1 = new Plato(11, "Picada", "Entrada para tres personas.\nVariedad de quesos y salames, \nacompañado de rodajas de pan casero", 1500, TipoComida.ENTRADA);
        menuDePlatos.put(plato1.getCodigo(), plato1);
        Plato plato2 = new Plato(12, "Empanadas", "Surtido de empanadas de copetin. Variedad de carne, JyQ y pollo", 1150, TipoComida.ENTRADA);
        menuDePlatos.put(plato2.getCodigo(), plato2);
        Plato plato3 = new Plato(21, "Parrillada", "Parrillada para dos personas,incluye morcilla, chorizo, chinchulines,\nvacio,costillitas y ojo de bife.", 5000, TipoComida.PRINCIPAL);
        menuDePlatos.put(plato3.getCodigo(), plato3);
        Plato plato4 = new Plato(22, "Fideos con tuco", "Fideos cocidos al dente y servidos \ncon una salsa de tomate casera.", 2000, TipoComida.PRINCIPAL);
        menuDePlatos.put(plato4.getCodigo(), plato4);
        Plato plato5 = new Plato(31, "Flan casero", "Flan de la casa, con dulce de leche y/o crema", 1000, TipoComida.POSTRE);
        menuDePlatos.put(plato5.getCodigo(), plato5);
        Plato plato6 = new Plato(32, "Helado", "Tres bochas de helado a eleccion, preguntar disponibilidad de sabores", 1500, TipoComida.POSTRE);
        menuDePlatos.put(plato6.getCodigo(), plato6);
        Plato plato7 = new Plato(41, "Vino Malbec Estancia Mendoza", "Calido,suave y dulce. Con taninos que no son agresivos", 1500, TipoComida.BEBIDA);
        menuDePlatos.put(plato7.getCodigo(), plato7);
        Plato plato8 = new Plato(42, "Coca-Cola", "Bien fria", 750, TipoComida.BEBIDA);
        menuDePlatos.put(plato8.getCodigo(), plato8);
    }

    public void setearMesas() {
        listMesas.add(new Mesa(2, (Mozo) setEmpleados.get(0)));
        listMesas.add(new Mesa(2, (Mozo) setEmpleados.get(1)));
        listMesas.add(new Mesa(4, (Mozo) setEmpleados.get(2)));
        listMesas.add(new Mesa(4, (Mozo) setEmpleados.get(2)));
        listMesas.add(new Mesa(6, (Mozo) setEmpleados.get(1)));
        listMesas.add(new Mesa(6, (Mozo) setEmpleados.get(0)));

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
}
