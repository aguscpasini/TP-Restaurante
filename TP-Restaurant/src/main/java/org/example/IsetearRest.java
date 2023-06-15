package org.example;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IsetearRest {
    HashMap<Integer,Plato> setearPlatos() throws MalformedURLException;
    ArrayList<Mesa> setearMesas();
    void setearMozos();

}
