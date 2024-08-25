package com.rubenrdc.lectorexcel;

import com.rubenrdc.lectorexcel.IGU.LectorExcelIGU;
import com.rubenrdc.lectorexcel.models.dao.Propieties;

/**
 *
 * @author Ruben
 */
public class LectorExcel {

    public static void main(String[] args) {
        Propieties.loadConfig();
        LectorExcelIGU v = new LectorExcelIGU();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }
}
