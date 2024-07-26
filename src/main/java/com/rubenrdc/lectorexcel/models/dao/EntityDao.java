package com.rubenrdc.lectorexcel.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class EntityDao {

    private DaoConnection dao = new DaoConnection();
    private final List<String> columnTableEntitys = new ArrayList<>();
    private final List<Integer> columnTableTypes = new ArrayList<>();
    private int cantColumn = 0;

    public List<String> getTableNameEntitys() {
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
            dao.getCloseC();
        }
        return null;
    }

    public void getColumTable(String Table) {
        if (dao.ExtablecerC() != null) {
            try {
                cantColumn=0;
                columnTableEntitys.clear();
                columnTableTypes.clear();
                
                ResultSet c = dao.getColumTable(Table);
                while (c.next()) {
                    columnTableEntitys.add(c.getString("COLUMN_NAME"));
                    columnTableTypes.add(c.getInt("DATA_TYPE"));
                    cantColumn++;
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            dao.getCloseC();
        }
    }
    public List<Object[]> getInfoTable(String Table){
        if (dao.ExtablecerC() != null) {
            try {
                List<Object[]> listO = new ArrayList<>();
                Object[] aux;
                ResultSet GenericQuery = dao.GenericQuery("SELECT * FROM "+Table);
                while(GenericQuery.next()){
                    aux = new Object[cantColumn];
                    for (int x = 1; x <= cantColumn; x++) {
                        aux[(x-1)]=GenericQuery.getObject(x);
                    }
                    listO.add(aux);
                }
                return listO;
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            dao.getCloseC();
        }
        return null;
    }

    public List<String> getColumnTableEntitys() {
        return columnTableEntitys;
    }

    public List<Integer> getColumnTableTypes() {
        return columnTableTypes;
    }
    
}
