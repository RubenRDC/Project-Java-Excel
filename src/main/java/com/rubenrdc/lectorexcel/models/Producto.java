package com.rubenrdc.lectorexcel.models;

import com.rubenrdc.lectorexcel.models.interfaces.Exportables;

/**
 *
 * @author Ruben
 */
public class Producto implements Exportables {

    private static int ids = 0;
    private final int ID;
    private String Codigo;
    private String Descrip;
    private String Marca;
    private Double Precio;
    private Object[] row;
    private String[] RowAtributos;

    public Producto(String Codigo,String Nombre, String Marca, Double Precio) {
        ids++;
        this.ID = ids;
        this.Codigo=Codigo;
        this.Descrip = Nombre;
        this.Marca = Marca;
        this.Precio = Precio;
    }

    public Producto(int id,String Codigo ,String Nombre, String Marca, Double Precio) {
        this.ID = id;
        this.Codigo=Codigo;
        this.Descrip = Nombre;
        this.Marca = Marca;
        this.Precio = Precio;
    }

    @Override
    public Object[] getRow() {
        row = new Object[4];
        row[0] = Codigo;
        row[1] = Descrip;
        row[2] = Marca;
        row[3] = Precio;
        return row;
    }

    @Override
    public String[] getTitulosAtributos() {
        RowAtributos = new String[4];
        RowAtributos[0] = "Codigo";
        RowAtributos[1] = "Descripcion";
        RowAtributos[2] = "Marca";
        RowAtributos[3] = "Precio";
        return RowAtributos;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

}
