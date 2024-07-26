package com.rubenrdc.lectorexcel.IGU.logic;

import com.rubenrdc.lectorexcel.IGU.LoadingJDialog;
import com.rubenrdc.lectorexcel.estilos.Estilos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Ruben
 */
public class ExportLogic extends SwingWorker<Object, Object> {

    private final LoadingJDialog loading;
    private final List<String> columnTableEntitys;
    private final List<Integer> columnTableTypes;
    private final List<Object[]> listSave;
    private final File outputFile;
    private boolean exito;

    public ExportLogic(LoadingJDialog loading, File outputFile, List<String> columnTableEntitys, List<Integer> columnTableTypes, List<Object[]> listSave) {

        this.loading = loading;
        this.columnTableEntitys = columnTableEntitys;
        this.columnTableTypes = columnTableTypes;
        this.listSave = listSave;
        this.outputFile = outputFile;
    }

    @Override
    protected Object doInBackground() throws Exception {
        exito = false;
        loading.getParent().setEnabled(false);
        loading.getOwner().setAlwaysOnTop(true);
        if (listSave != null) {
            loading.setMaxValue(listSave.size());
            OutputStream outFile;
            try (XSSFWorkbook libro = new XSSFWorkbook()) {
                outFile = new FileOutputStream(outputFile);

                XSSFCellStyle estiloTitulos = new Estilos.BuilderCell()
                        .setBoldText(true)
                        .setColorText("FFFFFF")
                        .setColorFondoHEX("")
                        .setTipoDeRellenoFondo(FillPatternType.SOLID_FOREGROUND)
                        .contruirEstilo(libro);

                XSSFSheet createSheet = libro.createSheet();

                int indexRenglon = 0;

                for (int fila = 0; fila <= listSave.size(); fila++) {
                    XSSFRow createRow = createSheet.createRow(fila);

                    for (int column = 0; column < columnTableEntitys.size(); column++) {
                        XSSFCell createCell = createRow.createCell(column);
                        if (fila == 0) {
                            createCell.setCellStyle(estiloTitulos);
                            createCell.setCellValue((String) columnTableEntitys.get(column));
                        } else {
                            Object a = listSave.get((fila - 1))[column];
                            setCellByType(libro, createCell, columnTableTypes.get(column), a);
                        }
                        createSheet.autoSizeColumn(column);
                    }

                    final int currentValue = indexRenglon;

                    loading.setProgress(currentValue);
                    loading.setStatus(" " + currentValue + " / " + loading.getMaxValue());

                    indexRenglon++;
                }
                libro.write(outFile);
                libro.close();
                outFile.close();
                exito = true;
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
        } else {
            JOptionPane.showMessageDialog(loading, "No Hay informacion exportable.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    protected void done() {
        if (exito) {
            JOptionPane.showMessageDialog(loading, "Operacion realizada con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        loading.dispose();
        loading.getParent().setEnabled(true);
        loading.getOwner().setAlwaysOnTop(false);
    }

    private void setCellByType(XSSFWorkbook libro, XSSFCell Cell, int sqlType, Object e) {
        XSSFCellStyle estiloFecha = new Estilos.BuilderCell().setFontFormat("dd/MM/yyyy").contruirEstilo(libro);
        switch (sqlType) {
            case java.sql.Types.VARCHAR -> {
                if (e instanceof String x) {
                    Cell.setCellValue(x);
                } else {
                    Cell.setCellValue("Incompatible.");
                }
            }
            case java.sql.Types.INTEGER -> {
                if (e instanceof Integer x) {
                    Cell.setCellValue(x);
                } else {
                    Cell.setCellValue("Incompatible.");
                }
            }
            case java.sql.Types.DOUBLE -> {
                if (e instanceof Double x) {
                    Cell.setCellValue(x);
                } else {
                    Cell.setCellValue("Incompatible.");
                }
            }
            case java.sql.Types.BOOLEAN -> {
                if (e instanceof Boolean x) {
                    Cell.setCellValue(x);
                } else {
                    Cell.setCellValue("Incompatible.");
                }
            }
            case java.sql.Types.DATE -> {
                if (e instanceof Date x) {
                    Cell.setCellValue(x);
                    Cell.setCellStyle(estiloFecha);
                } else {
                    Cell.setCellValue("Incompatible.");
                }
            }
            default -> {
                Cell.setCellValue("Tipo No Soportado.");
            }
        }
    }
}
