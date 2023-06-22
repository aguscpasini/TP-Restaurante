package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Cliente extends Persona{

    public Integer contadorDeVisitas;

    public Cliente(String nombre, String apellido) {
        super(nombre, apellido);
        this.contadorDeVisitas = 1;
    }

    public Cliente() {
        super();
    }


    public Cliente(String nombre, String apellido, Integer contadorDeVisitas) {
        super(nombre, apellido);
        this.contadorDeVisitas = contadorDeVisitas;
    }

    public Integer getContadorDeVisitas() {
        return contadorDeVisitas;
    }

    public void setContadorDeVisitas(Integer contadorDeVisitas) {
        this.contadorDeVisitas = contadorDeVisitas;
    }



    @Override
    public String toString() {
        return super.toString() +
                "\nID:" + getId() +
                "\nContador de visitas:" + contadorDeVisitas;
    }

}
