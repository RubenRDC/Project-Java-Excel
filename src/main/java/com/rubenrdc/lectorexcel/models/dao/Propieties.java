package com.rubenrdc.lectorexcel.models.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Ruben
 */

public class Propieties {

    private static String ip = "";
    private static String user = "";
    private static String pass = "";
    private static String bd = "";

    public Propieties() {
        iniciar();
    }

    private void iniciar() {

        Properties propiedades = new Properties();
        InputStream file = null;
        String userDirectoryPath = System.getProperty("user.dir");
        //javax.swing.JOptionPane.showMessageDialog(null, userDirectoryPath);
        try {
            //System.out.println(userDirectoryPath);
            file = new FileInputStream(userDirectoryPath+"/datos.properties");
            //System.out.println("ES NULO");
            propiedades.load(file);
            
            ip = propiedades.getProperty("ip");
            user = propiedades.getProperty("user");
            pass = propiedades.getProperty("pass");
            bd = propiedades.getProperty("bd");
        } catch (IOException rx) {
            javax.swing.JOptionPane.showMessageDialog(null, rx);
            
        }
    }


    public static String getIp() {
        return ip;
    }

    public static String getUser() {
        return user;
    }

    public static String getPass() {
        return pass;
    }

    public static String getBd() {
        return bd;
    }

}