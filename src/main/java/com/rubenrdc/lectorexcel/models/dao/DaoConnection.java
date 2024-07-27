package com.rubenrdc.lectorexcel.models.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void getCloseC() {
        if (conectar != null) {
            try {
                conectar.close();
                conectar = null;
            } catch (SQLException ex) {

            }
        }

    }

    public PreparedStatement getNewPreparedStatement(String Query) throws SQLException {
        PreparedStatement ps = conectar.prepareStatement(Query);
        return ps;
    }

    public ResultSet GenericQuery(String Query) {
        try {
            PreparedStatement ps = conectar.prepareStatement(Query);
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

    public String getPk(String Table) {
        try {
            String pk = "";
            String BaseDeDatos = conectar.getCatalog();
            ResultSet rs = conectar.getMetaData().getPrimaryKeys(BaseDeDatos, null, Table);
            while (rs.next()) {
                pk = rs.getString("COLUMN_NAME");
            }
            return pk;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
