package com.rubenrdc.lectorexcel.IGU.logic;

import com.rubenrdc.lectorexcel.IGU.LectorExcelIGU;
import com.rubenrdc.lectorexcel.IGU.LoadingJDialog;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ruben
 */
public class LogicImpExpEntity {

    public static final int FILE_CHOOSER_EXPORT = 0, FILE_CHOOSER_IMPORT = 1;
    private JFileChooser fileChooser;
    private final LectorExcelIGU fatherIGU;
    private ExportLogic swingLogicExport;
    private List<Object[]> listEntitysValidos;
    private List<Object[]> listEntitysInvalidos;
    private List<List> UsuariosVyI;

    public LogicImpExpEntity(LectorExcelIGU father) {
        this.fatherIGU = father;
    }

    public void exportReportExcel(LoadingJDialog loadingJDialog, File f,List<String> columnTableEntitys,List<Integer> columnTableTypes,List<Object[]> listSave) {
        swingLogicExport = new ExportLogic(loadingJDialog,f,columnTableEntitys,columnTableTypes,listSave);
        swingLogicExport.execute();
    }

    public File StartfileChooser(int mode) {
        setUIM(UIManager.getSystemLookAndFeelClassName());
        fileChooser = null;
        fileChooser = new JFileChooser();
        setUIM(UIManager.getCrossPlatformLookAndFeelClassName());
        fileChooser.setMultiSelectionEnabled(false);
        if (mode == FILE_CHOOSER_IMPORT) {
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//Solo se puede seleccionar Archivos
            fileChooser.setDialogTitle("Selecciona Excel a Importar");
            fileChooser.setFileFilter(new FileNameExtensionFilter(
                    "Excels XLSX & XLS", "XLSX", "XLS")
            );
            if (fileChooser.showOpenDialog(fatherIGU) != JFileChooser.CANCEL_OPTION) {
                return new File(fileChooser.getSelectedFile().getAbsolutePath());
            } else {
                return null;
            }
        } else if (mode == FILE_CHOOSER_EXPORT) {
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//Se puede seleccionar carpeta y archivos
            fileChooser.setDialogTitle("Seleccionar Sitio donde guardar reporte");

            if (fileChooser.showSaveDialog(fatherIGU) != JFileChooser.CANCEL_OPTION) {
                String date = "Reporte-" + ObtenerFechaHora() + ".xlsx";
                String file = fileChooser.getSelectedFile().getAbsolutePath();
                file = file.replaceAll(fileChooser.getSelectedFile().getName(), date);
                return new File(file);
            } else {
                return null;
            }
        }
        return null;
    }

    private void setUIM(String ClassNameUI) {
        try {
            UIManager.setLookAndFeel(ClassNameUI);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
    }

    private String ObtenerFechaHora() {
        LocalDateTime date = LocalDateTime.now();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
    }
}
