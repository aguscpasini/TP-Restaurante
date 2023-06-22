package org.example;

import org.example.Excepciones.MesaNoEncontrada;
import org.example.Excepciones.SinPlatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PanelDeControl {
    private JPanel rootPanel;
    private JPanel root2panel;
    private JButton mostrarMesasButton;
    private JButton mostrarPlatosButton;
    private JButton mostrarMozosButton;
    private JButton ocuparYCargarPlatosButton;
    private JButton pedirCuentaButton;
    private JButton verRecaudaciónButton;
    private JLabel clienteslabel;
    private JLabel mesaslabel;
    private JButton agregarClienteButton;
    private JButton sumarVisitaButton;
    private JButton buscarClienteButton;
    private JButton mostrarClienteButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PanelDeControl");
        frame.setContentPane(new PanelDeControl().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public PanelDeControl() {

        Restaurant res = new Restaurant();
        ArrayList<Mozo> Mozos = res.setearMozos();
        HashMap<Integer,Plato> platos = res.setearPlatos();
        ArrayList<Mesa> Mesas = res.setearMesas();
        ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
        Scanner sc = new Scanner(System.in);


          mostrarMesasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

                Mesas.forEach(i -> {
                    if (i.ocupada) {
                        System.out.printf("Mesa número: %d de %d personas, se encuentra OCUPADA. Su mozo se llama %s %s.\n Los platos que están comiendo son: \n", i.getNumMesa(), i.getCapacidad(), i.mozo.getNombre(), i.mozo.getApellido());
                        i.pedido.listPlatos.forEach(p -> {
                            System.out.printf("- %s \n", p.nombre);
                        });
                    } else {
                        System.out.printf("Mesa número: %d de %d personas, se encuentra DESOCUPADA. Su mozo se llama %s %s.\n", i.getNumMesa(), i.getCapacidad(), i.mozo.getNombre(), i.mozo.getApellido());
                    }
                });
            }
        });


        mostrarMozosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {

                Mozos.forEach(j -> {
                    System.out.printf("Mozo numero: %d . Nombre: %s . Apellido: %s . Salario: %f .\n", j.getId(), j.getNombre(), j.getApellido(), j.salario);
                });
            }
        });


        mostrarPlatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Plato p :platos.values()) {
                    System.out.println(p.toString());
                }
            }
        });

        verRecaudaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                Double recaudacion = res.sumarRecaudacion();
//                res.mostrarRecaudacion(recaudacion);
                res.mostrarRecaudacionJson();
            }
        });
        pedirCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int numMesa;

                    System.out.println("Ingrese el numero de mesa que desea cobrar...\n");
                    numMesa=sc.nextInt();

                    try{
                        res.pedirCuenta(numMesa);
                    }catch (SinPlatos ex)
                    {
                        System.out.println(ex.getMessage());
                    }catch (MesaNoEncontrada ex){
                        System.out.println(ex.getMessage());
                    }

            }
        });
        ocuparYCargarPlatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ingrese numero de mesa a ocupar...");
                int numMesa = sc.nextInt();
                try{
                    res.ocuparMesa(numMesa);
                    res.agregarPlatoAMesa(numMesa);
                }catch (MesaNoEncontrada ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });

        mostrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    res.mostrarClientes();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        sumarVisitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Ingrese ID del cliente al que se le va a sumar la visita: ");
                Scanner sc = new Scanner(System.in);
                int id = sc.nextInt();
                res.sumarVisita(id);
            }
        });

        buscarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Ingrese ID del cliente al que se va a buscar: ");
                Scanner sc1 = new Scanner(System.in);
                int idCliente = sc1.nextInt();
                Cliente aux = res.buscarCliente(idCliente);
                aux.toString();

            }
        });
        agregarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Cliente> clientes = new ArrayList<Cliente>();
                try {
                    clientes = res.escribirJsonCliente();
                    res.mostrarClientesAgregados(clientes);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}