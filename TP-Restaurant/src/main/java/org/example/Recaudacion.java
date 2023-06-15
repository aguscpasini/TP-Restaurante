package org.example;

public class Recaudacion {
    private static int idRecaudacion;
    private int id;
    private Integer recaudado;
    private String mes;

    public Recaudacion(Integer recaudado, String mes) {
        idRecaudacion++;
        id=idRecaudacion;
        this.recaudado = recaudado;
        this.mes = mes;
    }

    public Integer getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(Integer recaudado) {
        this.recaudado = recaudado;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Recaudacion:\n" +
                "Recaudado=" + recaudado +
                "\nMes=" + mes;
    }
}
