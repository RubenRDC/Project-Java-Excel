package com.rubenrdc.lectorexcel.models.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class DaoConnection {

    public DaoConnection() {

    }
    private Connection conectar;
    private Propieties Propiet = new Propieties();
    private String puerto = "3306";

    private String cadena = "jdbc:mysql://" + Propiet.getIp() + ":" + puerto + "/" + Propiet.getBd();

    public Connection ExtablecerC() {
        conectar = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, Propiet.getUser(), Propiet.getPass());
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            final JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "No se logro conectar a la base de datos\n" + e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
        return conectar;

    }

    public int RetornarId(String Consulta) {
        int id = 0;
        try {
            PreparedStatement cs = conectar.prepareStatement(Consulta);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
        }
        return id;
    }

    public void getCloseC() {
        if (conectar != null) {
            try {
                conectar.close();
                conectar = null;
            } catch (SQLException ex) {

            }
        }

    }

    public ResultSet QueryById(String Query, int IdParam) {

        try {
            PreparedStatement ps = conectar.prepareStatement(Query);
            ps.setInt(1, IdParam);
            ResultSet rs = ps.executeQuery();

            return rs;
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean GenericUpdate(String Query, java.util.List<String> params) {
        try {
            PreparedStatement ps = conectar.prepareStatement(Query);
            int index = 1;
            for (String param : params) {
                ps.setString(index, param);
                index++;
            }
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public ResultSet GenericQuery(String Query, java.util.List<String> params) {
        try {
            PreparedStatement ps = conectar.prepareStatement(Query);
            int index = 1;
            if (params != null) {
                for (String param : params) {
                    ps.setString(index, param);
                    index++;
                }
            }
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public ResultSet getTablesDDBB() {
        try {
            String BaseDeDatos = conectar.getCatalog();
            ResultSet tables = conectar.getMetaData().getTables(BaseDeDatos, null, null, new String[]{"TABLE"});
            return tables;
        } catch (SQLException ex) {
        }
        return null;
    }
    public ResultSet getColumTable(String Table) {
        try {
            String BaseDeDatos = conectar.getCatalog();
            ResultSet columns = conectar.getMetaData().getColumns(BaseDeDatos, null, Table, null);
            
            return columns;
        } catch (SQLException ex) {
        }
        return null;
    }

    public void getInfoConnection() {
        try {
            String catalog = conectar.getCatalog();
            System.out.println("Conectado a: " + catalog);
            DatabaseMetaData metaData = conectar.getMetaData();
            System.out.println("Nombre de Base de datos: " + conectar.getSchema());
            System.out.println("Nombre del Driver: " + metaData.getDriverName());
            System.out.println("Version del Driver: " + metaData.getDriverVersion());
        } catch (SQLException ex) {
        }
    }
}
