package com.rubenrdc.lectorexcel.IGU.logic;

import com.rubenrdc.lectorexcel.IGU.LoadingJDialog;
import com.rubenrdc.lectorexcel.models.dao.EntityDao;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Ruben
 */
public class ImportMassDBLogic extends SwingWorker<Object, Object> {

    private final List<Object[]> listEntitysValidos;
    private final LoadingJDialog loading;
    private final List<String> columnTableEntitys;
    private final EntityDao entityDao;
    private final String table;
    private String log = "";
    private boolean exito;

    public ImportMassDBLogic(EntityDao entityDao,LoadingJDialog loading, List<String> columnTableEntitys, List<Object[]> listEntitysValidos, String table) {
        this.loading = loading;
        this.columnTableEntitys = columnTableEntitys;
        this.listEntitysValidos = listEntitysValidos;
        this.table = table;
        this.entityDao=entityDao;
    }

    @Override
    protected Object doInBackground() throws Exception {
        int insercionesExitosas = 0;
        loading.getParent().setEnabled(false);
        loading.getOwner().setAlwaysOnTop(true);
        String localDate;
        loading.setMaxValue(listEntitysValidos.size());

        for (int i = 0; i < listEntitysValidos.size(); i++) {
            int insertInfoEntity = entityDao.insertInfoEntity(table, listEntitysValidos.get(i), columnTableEntitys);
            if (insertInfoEntity == 0) {
                localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm.ss"));
                log += localDate + " - " + columnTableEntitys.get(0) + " " + listEntitysValidos.get(i)[0] +" - "+listEntitysValidos.get(i)[1]+" : not inserted into the database in duplicate.\n";
            } else {
                insercionesExitosas++;
            }

            final int currentValue = (i + 1);
            loading.setProgress(currentValue);
            loading.setStatus(" " + currentValue + " / " + loading.getMaxValue());
        }
        exito = insercionesExitosas == listEntitysValidos.size();

        return null;
    }

    @Override
    protected void done() {
        if (exito) {
            JOptionPane.showMessageDialog(loading, "Operacion realizada con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(loading, "Operacion realizada finalizada con errores.", "Advertencia.", JOptionPane.WARNING_MESSAGE);
            generarLog(log);
        }
        loading.dispose();
        loading.getParent().setEnabled(true);
        loading.getOwner().setAlwaysOnTop(false);
    }

    private void generarLog(String log) {
        if (log.length() > 1) {
            final String l = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
            final String userDirectoryPath = System.getProperty("user.dir");
            final String PathLog = userDirectoryPath + "/log";
            final String Path = PathLog + "/" + l + "log.txt";
            File file = new File(PathLog);
            File logFile = new File(Path);
            FileWriter flw;
            try {

                if (!file.exists()) {
                    file.mkdir();
                    if (!logFile.exists()) {
                        logFile.createNewFile();
                    }
                }
                //System.out.println(log);
                flw = new FileWriter(logFile);
                flw.write(log);
                flw.close();
                Desktop.getDesktop().open(logFile);
            } catch (IOException ex) {
                //System.out.println(ex);
            }
        }
    }
}
