package com.rubenrdc.lectorexcel.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class EntityDao {

    private final DaoConnection dao = new DaoConnection();
    private final List<String> columnTableEntitys = new ArrayList<>();
    private final List<Integer> columnTableTypes = new ArrayList<>();
    private final List<Object[]> listO = new ArrayList<>();
    private String pkTable;
    private int cantColumn;
    private boolean idIsAutoIncrement;

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
                idIsAutoIncrement = false;
                cantColumn = 0;
                columnTableEntitys.clear();
                columnTableTypes.clear();

                pkTable = dao.getPk(Table);

                ResultSet columns = dao.getColumTable(Table);
                while (columns.next()) {
                    columnTableEntitys.add(columns.getString("COLUMN_NAME"));
                    columnTableTypes.add(columns.getInt("DATA_TYPE"));
                    cantColumn += 1;
                    if (columns.getString("COLUMN_NAME").equalsIgnoreCase(pkTable) & columns.getString("IS_AUTOINCREMENT").equalsIgnoreCase("YES")) {//Normalmente el Id
                        idIsAutoIncrement = true;
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            dao.getCloseC();
        }
    }

    public List<Object[]> getInfoTable(String Table) {
        if (dao.ExtablecerC() != null) {
            try {
                listO.clear();
                Object[] aux;
                ResultSet GenericQuery = dao.GenericQuery("SELECT * FROM " + Table);
                while (GenericQuery.next()) {
                    aux = new Object[cantColumn];
                    for (int x = 1; x <= cantColumn; x++) {
                        aux[(x - 1)] = GenericQuery.getObject(x);
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

    public int insertInfoEntity(String Table, Object[] columnsInfo, List<String> columnLabelList) {
        int executeUpdate = 0;
        if (dao.ExtablecerC() != null) {
            try {
                PreparedStatement PreparedStatement = dao.getNewPreparedStatement(generateQuery(Table, columnLabelList));
                int indexParametrosSQL=1;
                
                for (int indexColumn = 0; indexColumn < columnsInfo.length; indexColumn++) {
                    if (columnLabelList.get(indexColumn).equalsIgnoreCase(pkTable) & idIsAutoIncrement) {
                        continue;
                    }
                    PreparedStatement.setObject(indexParametrosSQL, columnsInfo[indexColumn]);
                    indexParametrosSQL++;
                }
                executeUpdate = PreparedStatement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            dao.getCloseC();
        }
        return executeUpdate;
    }

    private String generateQuery(String Table, List<String> columnLabelList) {
        String Query = "INSERT IGNORE INTO " + Table + " ";
        String frag = "VALUES";

        for (int i = 0; i < columnLabelList.size(); i++) {
            if (i == 0) {
                if (!(columnLabelList.get(i).equalsIgnoreCase(pkTable) & idIsAutoIncrement)) {//Si Ambos son LO CONTRARIO A TRUE SE AGREGA EL CAMPO.
                    Query += "(" + columnLabelList.get(i) + ",";//Si no es autoIncrementable
                    frag += "(?,";
                } else {
                    frag += "(";
                    Query += "(";//Si es autoIncrementable
                }
            } else {
                frag += "?";
                Query += columnLabelList.get(i);
                if (i < (columnLabelList.size() - 1) & i > 0) {
                    Query += ",";
                    frag += ",";
                } else {
                    Query += ") ";
                    frag += ")";
                }
            }
        }
        return (Query + frag);
    }

    public List<String> getColumnTableEntitys() {
        return columnTableEntitys;
    }

    public List<Integer> getColumnTableTypes() {
        return columnTableTypes;
    }
}
