package com.rubenrdc.lectorexcel.IGU;

import com.rubenrdc.lectorexcel.estilos.estilo;
import com.rubenrdc.lectorexcel.models.Producto;
import com.rubenrdc.lectorexcel.models.Users;
import com.rubenrdc.lectorexcel.models.interfaces.Exportables;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Ruben
 */
public class LectorExcelIGU extends javax.swing.JFrame {

    private JFileChooser fileChooser;
    //private Workbook libro;
    private final int FILE_CHOOSER_EXPORT = 0, FILE_CHOOSER_IMPORT = 1;
    private ArrayList<Exportables> listEntitysValidos;
    private ArrayList<Exportables> listEntitysInvalidos;
    private ArrayList<ArrayList> UsuariosVyI;

    private Thread hiloExport, hiloImport;

    public LectorExcelIGU() {
        this.setResizable(false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbleObjectValidos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        SaveReportBtnAdm = new javax.swing.JButton();
        ImportBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        SelectFileBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        selectEntity = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbleObjectInvalidos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        SaveReportBtnNoAdm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(350, 12));

        tbleObjectValidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbleObjectValidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbleObjectValidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tbleObjectValidos.setFocusable(false);
        tbleObjectValidos.setRowHeight(25);
        tbleObjectValidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbleObjectValidos);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Entidades Admitidas:");

        SaveReportBtnAdm.setText("Guardar Reporte");
        SaveReportBtnAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveReportBtnAdmMouseClicked(evt);
            }
        });

        ImportBtn.setText("Importar");
        ImportBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImportBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(ImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SaveReportBtnAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveReportBtnAdm)
                    .addComponent(ImportBtn))
                .addContainerGap())
        );

        SelectFileBtn.setText("Seleccionar Archivo");
        SelectFileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectFileBtnMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Archivo Seleccionado:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Importador/Exportador de Entidades.");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tipo de Entidad:");

        selectEntity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Users", "Producto" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(SelectFileBtn, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectEntity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectEntity, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SelectFileBtn)
                .addContainerGap())
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(350, 176));

        tbleObjectInvalidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbleObjectInvalidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tbleObjectInvalidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tbleObjectInvalidos.setFocusable(false);
        tbleObjectInvalidos.setRowHeight(25);
        tbleObjectInvalidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tbleObjectInvalidos);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Entidades No Admitidas:");

        SaveReportBtnNoAdm.setText("Guardar Reporte");
        SaveReportBtnNoAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveReportBtnNoAdmMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SaveReportBtnNoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveReportBtnNoAdm)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectFileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectFileBtnMouseClicked
        File f = StartfileChooser(this.FILE_CHOOSER_IMPORT);
        if (f != null) {
            jTextField1.setText(f.getPath());
            LoadingJDialog l = new LoadingJDialog(this, false);
            l.setVisible(true);
            setAlwaysOnTop(true);
            this.setEnabled(false);
            importReportExcel(l, new Callback() {

                @Override
                public void onComplete(ArrayList<ArrayList> a) {
                    UsuariosVyI = a;
                    JOptionPane.showMessageDialog(l, "Operacion realizada con exito.", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    setEnabled(true);
                    setAlwaysOnTop(false);
                    if (UsuariosVyI != null) {
                        if (!(UsuariosVyI.get(0).isEmpty() & UsuariosVyI.get(1).isEmpty())) {
                            listEntitysValidos = UsuariosVyI.get(0);
                            listEntitysInvalidos = UsuariosVyI.get(1);
                            llenarTabla(tbleObjectValidos, listEntitysValidos);
                            llenarTabla(tbleObjectInvalidos, listEntitysInvalidos);
                        } else {//Si los dos Arrays estas vacios...
                            listEntitysValidos.clear();
                            listEntitysInvalidos.clear();
                            ClearTable(tbleObjectValidos);
                            ClearTable(tbleObjectInvalidos);
                            JOptionPane.showMessageDialog(null, "El archivo no tiene informacion importable.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no es accesible o no contiene ninguna hoja.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }, selectEntity.getSelectedItem().toString(), f);
        }else{
            
        }
    }//GEN-LAST:event_SelectFileBtnMouseClicked

    private void SaveReportBtnAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveReportBtnAdmMouseClicked
        //StartfileChooser(this.FILE_CHOOSER_EXPORT);
        File f = StartfileChooser(this.FILE_CHOOSER_EXPORT);

        if (f != null) {
            ExportReportExcel(f, listEntitysValidos);
        }
    }//GEN-LAST:event_SaveReportBtnAdmMouseClicked

    private void SaveReportBtnNoAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveReportBtnNoAdmMouseClicked
        File f = StartfileChooser(this.FILE_CHOOSER_EXPORT);

        if (f != null) {
            ExportReportExcel(f, listEntitysInvalidos);
        }
    }//GEN-LAST:event_SaveReportBtnNoAdmMouseClicked

    private void ImportBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportBtnMouseClicked

    private File StartfileChooser(int mode) {
        setUIM(UIManager.getSystemLookAndFeelClassName());
        fileChooser = null;
        fileChooser = new JFileChooser();
        setUIM(UIManager.getCrossPlatformLookAndFeelClassName());
        fileChooser.setMultiSelectionEnabled(false);
        if (mode == this.FILE_CHOOSER_IMPORT) {
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//Solo se puede seleccionar Archivos
            fileChooser.setDialogTitle("Selecciona Excel a Importar");
            fileChooser.setFileFilter(new FileNameExtensionFilter(
                    "Excels XLSX & XLS", "XLSX", "XLS")
            );
            if (fileChooser.showOpenDialog(this) != JFileChooser.CANCEL_OPTION) {
                return new File(fileChooser.getSelectedFile().getAbsolutePath());
            } else {
                return null;
            }
        } else if (mode == this.FILE_CHOOSER_EXPORT) {
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//Se puede seleccionar carpeta y archivos
            fileChooser.setDialogTitle("Seleccionar Sitio donde guardar reporte");

            if (fileChooser.showSaveDialog(this) != JFileChooser.CANCEL_OPTION) {
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

    private String ObtenerFechaHora() {
        LocalDateTime date = LocalDateTime.now();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
    }

    //private void ExportReportExcel(File f, ArrayList<? extends Exportables> list)//ArrayList de tipo generico q esta obligado a que herede de la clase Exportables
    private <T extends Exportables> void ExportReportExcel(File f, ArrayList<T> list) {//T Generico que obliga a que el parametro generico herede de la clase Exportables
        if (!list.isEmpty()) {
            OutputStream outFile;
            try (XSSFWorkbook libro = new XSSFWorkbook()) {
                outFile = new FileOutputStream(f);

                XSSFCellStyle estiloTitulos = new estilo.BuilderCell()
                        .setBoldText(true)
                        .setColorText("FFFFFF")
                        .setColorFondoHEX("")
                        .setTipoDeRellenoFondo(FillPatternType.SOLID_FOREGROUND)
                        .contruirEstilo(libro);
                XSSFCellStyle estiloFecha = new estilo.BuilderCell().setFontFormat("dd/MM/yyyy").contruirEstilo(libro);

                XSSFSheet createSheet = libro.createSheet();
                for (int i = 0; i <= list.size(); i++) {
                    XSSFRow createRow = createSheet.createRow(i);

                    for (int j = 0; j < list.get(0).getTitulosAtributos().length; j++) {
                        XSSFCell createCell = createRow.createCell(j);
                        if (i == 0) {
                            createCell.setCellStyle(estiloTitulos);
                            createCell.setCellValue((String) list.get(i).getTitulosAtributos()[j]);
                        } else {
                            //Obtengo un elemento del array de atributos de la clase de usuarios en la clase generica.
                            Object a = list.get((i - 1)).getRow()[j];
                            if (a instanceof String aa) {//Consulta si a es una instancia de String, si es asi lo cartea como aa
                                createCell.setCellValue(aa);
                            } else if (a instanceof Double double1) {
                                createCell.setCellValue(double1);
                            } else if (a instanceof Integer integer) {
                                createCell.setCellValue(integer);
                            } else if (a instanceof LocalDate date) {
                                createCell.setCellValue(date);
                                createCell.setCellStyle(estiloFecha);
                            } else {
                                if (a == null) {
                                    a = "";
                                }
                                createCell.setCellValue("" + a);
                            }
                        }
                        createSheet.autoSizeColumn(j);

                    }

                    //System.out.println(i + " / " + list.size());
                }
                libro.write(outFile);
                libro.close();
                outFile.close();

            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Hay informacion exportable.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void importReportExcel(LoadingJDialog l, Callback callback, String ObjectName, File f) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {

                ArrayList<Exportables> ObjetosValidos = new ArrayList<>();
                ArrayList<Exportables> ObjetosInvalidos = new ArrayList<>();
                ArrayList<ArrayList> UsuariosVyI = new ArrayList<>(2);
                ArrayList<Object> parametrosGenericos = new ArrayList<>();

                try (Workbook wb = WorkbookFactory.create(f)) {
                    if (wb.getNumberOfSheets() > 0) {
                        Sheet hoja = wb.getSheetAt(0);
                        boolean datoIncopatible = false;
                        int indexRenglon = 0, indexCelda = 0;

                        l.setMaxValue(hoja.getLastRowNum());
                        for (Row row : hoja) {

                            if (indexRenglon > 0) {
                                for (int cn = 0; cn < row.getLastCellNum(); cn++) {
                                    //System.out.println("Rows");
                                    Cell c = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                                    switch (indexCelda) {
                                        case 0:
                                            //Celda Id
                                            if (c.getCellType() == CellType.NUMERIC) {
                                                //idUser = (int) c.getNumericCellValue();
                                                parametrosGenericos.add(0, (int) c.getNumericCellValue());
                                                //System.out.println(idUser);
                                            } else {
                                                parametrosGenericos.add(0, -1);
                                                //idUser = -1;
                                                datoIncopatible = true;
                                            }
                                            break;
                                        case 1:
                                            //Celda Nombre
                                            if (c.getCellType() == CellType.STRING) {
                                                //nombreUser = c.getStringCellValue();
                                                parametrosGenericos.add(1, c.getStringCellValue());
                                                //System.out.println(nombreUser);
                                            } else {
                                                //nombreUser = "*";
                                                parametrosGenericos.add(1, "*");
                                                datoIncopatible = true;
                                            }
                                            break;
                                        case 2:
                                            //Celda Apellido
                                            if (c.getCellType() == CellType.STRING) {
                                                //apellidoUser = c.getStringCellValue();
                                                parametrosGenericos.add(2, c.getStringCellValue());
                                                //System.out.println(apellidoUser);
                                            } else {
                                                parametrosGenericos.add(2, "*");
                                                //apellidoUser = "*";
                                                datoIncopatible = true;
                                            }
                                            break;
                                        case 3:
                                            //Celda Fecha
                                            if (c.getCellType() == CellType.NUMERIC) {
                                                if (ObjectName.equalsIgnoreCase("Users")) {
                                                    parametrosGenericos.add(3, c.getLocalDateTimeCellValue().toLocalDate());
                                                } else if (ObjectName.equalsIgnoreCase("Producto")) {
                                                    parametrosGenericos.add(3, c.getNumericCellValue());
                                                }
                                            } else if (c.getCellType() == CellType.STRING) {
                                                parametrosGenericos.add(3, c.getStringCellValue());
                                            } else {
                                                parametrosGenericos.add(3, null);
                                                //localDateUser = null;
                                                datoIncopatible = true;
                                            }
                                            break;
                                        default:
                                            parametrosGenericos.add(indexCelda, c.getStringCellValue());
                                            break;
                                    }
                                    indexCelda++;
                                }
                                if (ObjectName.equalsIgnoreCase("Users")) {
                                    if (datoIncopatible) {
                                        ObjetosInvalidos.add(new Users((int) parametrosGenericos.get(0),
                                                (String) parametrosGenericos.get(1),
                                                (String) parametrosGenericos.get(2),
                                                (LocalDate) parametrosGenericos.get(3)));
                                    } else {
                                        ObjetosValidos.add(new Users((int) parametrosGenericos.get(0),
                                                (String) parametrosGenericos.get(1),
                                                (String) parametrosGenericos.get(2),
                                                (LocalDate) parametrosGenericos.get(3)));
                                    }
                                } else if (ObjectName.equalsIgnoreCase("Producto")) {
                                    if (datoIncopatible) {
                                        ObjetosInvalidos.add(new Producto((int) parametrosGenericos.get(0),
                                                (String) parametrosGenericos.get(1),
                                                (String) parametrosGenericos.get(2),
                                                (Double) parametrosGenericos.get(3)));
                                    } else {
                                        ObjetosValidos.add(new Producto((int) parametrosGenericos.get(0),
                                                (String) parametrosGenericos.get(1),
                                                (String) parametrosGenericos.get(2),
                                                (Double) parametrosGenericos.get(3)));
                                    }
                                }

                                datoIncopatible = false;
                            }
                            // Actualizar la GUI dentro de SwingUtilities.invokeLater()
                            final int currentValue = indexRenglon;
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    l.setProgress(currentValue);
                                    l.setStatus(" " + currentValue + " / " + l.getMaxValue());
                                }
                            });
                            indexRenglon++;
                            indexCelda = 0;

                        }
                        UsuariosVyI.add(ObjetosValidos);
                        UsuariosVyI.add(ObjetosInvalidos);
                        //wb.close();
                        //return UsuariosVyI;
                        // Tarea completada
                        if (l.getMaxValue() == (indexRenglon - 1)) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    l.dispose(); // Cerrar el diálogo de carga
                                }
                            });
                            callback.onComplete(UsuariosVyI);
                        }
                    } else {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                l.dispose(); // Cerrar el diálogo de carga
                            }
                        });
                        callback.onComplete(null);
                    }
                } catch (Exception ex) {
                }
            }
        }
        );
        a.start();
    }

    // Interfaz de callback para manejar el resultado de AccionPesada
    private interface Callback {

        void onComplete(ArrayList<ArrayList> a);
    }

    private void setUIM(String ClassNameUI) {
        try {
            UIManager.setLookAndFeel(ClassNameUI);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LectorExcelIGU.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private <T extends Exportables> void llenarTabla(javax.swing.JTable tb, ArrayList<T> list) {
        ClearTable(tb);
        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (tb.getModel());
        if (!list.isEmpty()) {
            for (String titulosAtributo : list.get(0).getTitulosAtributos()) {
                dm.addColumn(titulosAtributo);
            }
            for (int j = 0; j < list.size(); j++) {
                dm.addRow(list.get(j).getRow());
            }
        }
        tb.setModel(dm);
    }

    public void ClearTable(javax.swing.JTable jTable) {
        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (jTable.getModel());
        dm.setNumRows(0);
        dm.setColumnCount(0);
        jTable.setModel(dm);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ImportBtn;
    private javax.swing.JButton SaveReportBtnAdm;
    private javax.swing.JButton SaveReportBtnNoAdm;
    private javax.swing.JButton SelectFileBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> selectEntity;
    private javax.swing.JTable tbleObjectInvalidos;
    private javax.swing.JTable tbleObjectValidos;
    // End of variables declaration//GEN-END:variables
}
