package com.rubenrdc.lectorexcel.IGU.logic;

import com.rubenrdc.lectorexcel.IGU.LectorExcelIGU;
import com.rubenrdc.lectorexcel.IGU.LoadingJDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Ruben
 */
public class ImportLogic extends SwingWorker<Object, Object> {

    private final LoadingJDialog loading;
    private final List<String> columnTableEntitys;
    private final List<Integer> columnTableTypes;
    private final List<List<Object[]>> entitysVyI;
    private final File intFile;
    private boolean exito;

    public ImportLogic(LoadingJDialog loading, File intFile, List<String> columnTableEntitys, List<Integer> columnTableTypes, List<List<Object[]>> entitysVyI) {
        this.loading = loading;
        this.columnTableEntitys = columnTableEntitys;
        this.columnTableTypes = columnTableTypes;
        this.entitysVyI = entitysVyI;
        this.intFile = intFile;
    }

    @Override
    protected Object doInBackground() throws Exception {
        exito = false;
        loading.getParent().setEnabled(false);
        loading.getOwner().setAlwaysOnTop(true);
        ZipSecureFile.setMinInflateRatio(0);//Permite cargar archivos Excel sin compresión.
        try (Workbook wb = WorkbookFactory.create(intFile)) {
            Object[] aux;
            //new Object[columnTableEntitys.size()];
            entitysVyI.clear();
            List<Object[]> entitysV = new ArrayList<>();
            List<Object[]> entitysI = new ArrayList<>();

            Sheet hoja = wb.getSheetAt(0);
            int indexRenglon = 0, cantRows = hoja.getLastRowNum(), incon = 0;
            loading.setMaxValue(cantRows);
            for (Row row : hoja) {//Filas

                if (row.getLastCellNum() != columnTableEntitys.size()) {
                    //System.out.println(columnTableEntitys.size() + " " + row.getLastCellNum());
                    exito = false;
                    break;
                }
                if (indexRenglon < cantRows && row.getRowNum() != 0) {
                    aux = new Object[columnTableEntitys.size()];

                    for (int cn = 0; cn < row.getLastCellNum(); cn++) {
                        Cell c = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                        aux[cn] = setCellByType(c, columnTableTypes.get(cn));

                        if (aux[cn].equals("*Incompatible.*")) {
                            incon++;
                        }

                    }
                    if (incon > 0) {
                        entitysI.add(aux);
                    } else if (incon == 0) {
                        entitysV.add(aux);
                    }
                    incon = 0;
                    indexRenglon++;
                }
                final int currentValue = indexRenglon;
                loading.setProgress(currentValue);
                loading.setStatus(" " + currentValue + " / " + loading.getMaxValue());
                exito = true;
            }
            entitysVyI.add(entitysV);
            entitysVyI.add(entitysI);
            wb.close();
        } catch (Exception ex) {
            System.out.println(ex);
            exito = false;
        }
        return null;
    }

    @Override
    protected void done() {
        if (exito) {
            JOptionPane.showMessageDialog(loading, "Operacion realizada con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
            ((LectorExcelIGU) loading.getOwner()).setEntitysValidos(entitysVyI.get(0));
            ((LectorExcelIGU) loading.getOwner()).setEntitysInvalidos(entitysVyI.get(1));
        } else {
            JOptionPane.showMessageDialog(loading, "El excel que se intenta importar no cuenta con la informacion correcta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        loading.dispose();
        loading.getParent().setEnabled(true);
        loading.getOwner().setAlwaysOnTop(false);
    }

    private Object setCellByType(Cell Cell, int sqlType) {
        switch (sqlType) {
            case java.sql.Types.VARCHAR -> {
                if (Cell.getCellType() == CellType.STRING) {
                    return Cell.getStringCellValue();
                } else {
                    return "*Incompatible.*";
                }
            }
            case java.sql.Types.INTEGER -> {
                if (Cell.getCellType() == CellType.NUMERIC) {
                    return ((int) Cell.getNumericCellValue());
                } else {
                    return "*Incompatible.*";
                }
            }
            case java.sql.Types.DOUBLE -> {
                if (Cell.getCellType() == CellType.NUMERIC) {
                    return Cell.getNumericCellValue();

                } else {
                    return "*Incompatible.*";
                }
            }
            case java.sql.Types.BOOLEAN -> {
                if (Cell.getCellType() == CellType.BOOLEAN) {
                    return Cell.getBooleanCellValue();
                } else {
                    return "*Incompatible.*";
                }
            }
            case java.sql.Types.DATE -> {
                if (Cell.getCellType() == CellType.NUMERIC) {
                    return Cell.getDateCellValue();

                } else {
                    return "*Incompatible.*";
                }
            }
            default -> {
                return "*Incompatible.*";
            }
        }
    }
}
