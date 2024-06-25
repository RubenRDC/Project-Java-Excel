package com.rubenrdc.lectorexcel.models;

import com.rubenrdc.lectorexcel.models.interfaces.Exportables;
import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class Producto implements Exportables {

    private static int ids = 0;
    private final int ID;
    private String Nombre;
    private String Marca;
    private Double Precio;
    private ArrayList<String> ListTitulosAtributos;
    private Object[] row;
    private String[] RowAtributos;

    public Producto(String Nombre, String Marca, Double Precio) {
        ids++;
        this.ID = ids;
        this.Nombre = Nombre;
        this.Marca = Marca;
        this.Precio = Precio;
    }

    public Producto(int id, String Nombre, String Marca, Double Precio) {
        this.ID = id;
        this.Nombre = Nombre;
        this.Marca = Marca;
        this.Precio = Precio;
    }


    @Override
    public Object[] getRow() {
        row = new Object[4];
        row[0] = ID;
        row[1] = Nombre;
        row[2] = Marca;
        row[3] = Precio;
        return row;
    }

    @Override
    public String[] getTitulosAtributos() {
        RowAtributos = new String[4];
        RowAtributos[0] = "ID";
        RowAtributos[1] = "Nombre";
        RowAtributos[2] = "Marca";
        RowAtributos[3] = "Precio";
        return RowAtributos;
    }

}
