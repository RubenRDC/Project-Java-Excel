package com.rubenrdc.lectorexcel.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class genericEntityDao {

    private static DaoConnection dao = new DaoConnection();

    public static List<String> getTableNameEntitys() {
        if (dao.ExtablecerC() != null) {
            try {
                List<String> listaTables = new ArrayList<>();
                ResultSet tables = dao.getTablesDDBB();
                while (tables.next()) {
                    listaTables.add(tables.getString("TABLE_NAME"));
                }
                return listaTables;
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }
    public static List<String>getColumTable(String Table){
        if (dao.ExtablecerC() != null) {
            try {
                List<String> listaC = new ArrayList<>();
                ResultSet c = dao.getColumTable(Table);
                while (c.next()) {
                    listaC.add(c.getString("COLUMN_NAME"));
                }
                return listaC;
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }
}
