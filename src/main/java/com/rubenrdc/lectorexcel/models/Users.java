package com.rubenrdc.lectorexcel.models;

import com.rubenrdc.lectorexcel.models.interfaces.Exportables;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class Users implements Exportables {

    private static int ids = 0;
    private final int ID;
    private String Nombre;
    private String Apellido;
    private LocalDate fechaDeIngreso;
    private Object[] row;
    private String[] RowAtributos;

    public Users(String Nombre, String Apell, LocalDate FechaDeIngreso) {
        ids++;
        ID = ids;
        this.Nombre = Nombre;
        Apellido = Apell;
        this.fechaDeIngreso = FechaDeIngreso;
    }

    public Users(int id, String Nombre, String Apell, LocalDate FechaDeIngreso) {
        ID = id;
        this.Nombre = Nombre;
        Apellido = Apell;
        this.fechaDeIngreso = FechaDeIngreso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getId() {
        return ID;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    @Override
    public Object[] getRow() {
        row = new Object[4];
        row[0]=ID;
        row[1]=Nombre;
        row[2]=Apellido;
        row[3]=fechaDeIngreso;
        return row;
    }
    @Override
    public String[] getTitulosAtributos() {
        RowAtributos = new String[4];
        RowAtributos[0]="ID";
        RowAtributos[1]="Nombre";
        RowAtributos[2]="Apellidos";
        RowAtributos[3]="Fecha De Ingreso";
        return RowAtributos;
    }
    

}
