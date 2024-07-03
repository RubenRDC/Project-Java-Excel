package com.rubenrdc.lectorexcel.models.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            //System.out.println("cadena= "+cadena);
            conectar = DriverManager.getConnection(cadena, Propiet.getUser(), Propiet.getPass());
            //JOptionPane.showMessageDialog(null, "Se establecio la conexion exitosamente");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            //System.out.println("ex " + e);
            JOptionPane.showMessageDialog(null, "No se logro conectar a la base de datos\n"+e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
        //System.out.println("conectar " + conectar);
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
            //System.out.println("ex= " + ex);
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
}
