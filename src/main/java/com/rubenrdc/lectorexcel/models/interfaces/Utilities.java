package com.rubenrdc.lectorexcel.models.interfaces;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ruben
 */
public interface Utilities {

    default public void setColumTable(javax.swing.JTable table, List<String> listTitle) {
        javax.swing.table.DefaultTableModel df = (javax.swing.table.DefaultTableModel) table.getModel();
        df.setColumnCount(0);
        if (listTitle != null) {
            for (String string : listTitle) {
                df.addColumn(string);
            }
        }
        table.setModel(df);
    }

    default public void llenarTabla(javax.swing.JTable table, List<Object[]> list) {
        javax.swing.table.DefaultTableModel df = (javax.swing.table.DefaultTableModel) table.getModel();
        df.setNumRows(0);
        if (list != null) {
            for (Object[] objects : list) {
                df.addRow(objects);
            }
        }
        table.setModel(df);
    }

    default public void clearTable(javax.swing.JTable table) {
        javax.swing.table.DefaultTableModel df = (javax.swing.table.DefaultTableModel) table.getModel();
        df.setNumRows(0);
        table.setModel(df);
    }
}
