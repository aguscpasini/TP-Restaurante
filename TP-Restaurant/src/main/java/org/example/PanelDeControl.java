package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelDeControl {
    private JPanel rootPanel;
    private JPanel root2panel;
    private JButton mostrarMesasButton;
    private JButton mostrarPlatosButton;
    private JButton mostrarMozosButton;
    private JButton sentarGenteButton;
    private JButton desocuparMesaButton;
    private JButton cobrarMesaButton;
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
        mostrarMesasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Restaurant res = new Restaurant();
                ArrayList<Mozo> Mozos = res.setearMozos();
                res.setearPlatos();
                ArrayList<Mesa> Mesas = res.setearMesas();

                Mesas.forEach(i -> {
                    if (i.ocupada) {
                        System.out.printf("Mesa número: %d de %d personas, se encuentra OCUPADA. Su mozo se llama %s %s.\n Los platos que están comiendo son: \n", i.numMesa, i.getCapacidad(), i.mozo.getNombre(), i.mozo.getApellido());
                        i.pedido.listPlatos.forEach(p -> {
                            System.out.printf("- %s \n", p.nombre);
                        });
                    } else {
                        System.out.printf("Mesa número: %d de %d personas, se encuentra DESOCUPADA. Su mozo se llama %s %s.\n", i.numMesa, i.getCapacidad(), i.mozo.getNombre(), i.mozo.getApellido());
                    }
                });
            }
        });


        mostrarMozosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {

                Restaurant res = new Restaurant();
                ArrayList<Mozo> Mozos = res.setearMozos();
                res.setearPlatos();
                ArrayList<Mesa> Mesas = res.setearMesas();

                Mozos.forEach(j -> {
                    System.out.printf("Mozo numero: %d . Nombre: %s . Apellido: %s . Salario: %f .\n", j.getId(), j.getNombre(), j.getApellido(), j.salario);
                });
            }
        });





    }
}