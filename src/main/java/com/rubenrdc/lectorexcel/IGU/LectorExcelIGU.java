package com.rubenrdc.lectorexcel.IGU;

import com.rubenrdc.lectorexcel.estilos.Estilo;
import com.rubenrdc.lectorexcel.models.Producto;
import com.rubenrdc.lectorexcel.models.Users;
import com.rubenrdc.lectorexcel.models.dao.ProductoDao;
import com.rubenrdc.lectorexcel.models.dao.UsersDao;
import com.rubenrdc.lectorexcel.models.interfaces.Exportables;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
    private final int FILE_CHOOSER_EXPORT = 0, FILE_CHOOSER_IMPORT = 1;
    private List<Exportables> listEntitysValidos;
    private List<Exportables> listEntitysInvalidos;
    private List<List> UsuariosVyI;

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
        getListExpEntityBtn = new javax.swing.JButton();
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
                null
            },
            new String [] {

            }
        ){
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tbleObjectValidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tbleObjectValidos.setFocusable(false);
        tbleObjectValidos.setRowHeight(25);
        tbleObjectValidos.setRowSelectionAllowed(false);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(ImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(SaveReportBtnAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
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
        jLabel1.setText("Archivo Seleccionado Para Importar:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Importador/Exportador de Entidades.");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tipo de Entidad:");

        selectEntity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Users", "Productos" }));
        selectEntity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectEntityItemStateChanged(evt);
            }
        });

        getListExpEntityBtn.setText("Obtener Registros Para Exportar");
        getListExpEntityBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getListExpEntityBtnMouseClicked(evt);
            }
        });

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
                            .addComponent(selectEntity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(getListExpEntityBtn)))))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectFileBtn)
                    .addComponent(getListExpEntityBtn))
                .addContainerGap())
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(350, 176));

        tbleObjectInvalidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbleObjectInvalidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                null
            },
            new String [] {

            }
        ){
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tbleObjectInvalidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tbleObjectInvalidos.setFocusable(false);
        tbleObjectInvalidos.setRowHeight(25);
        tbleObjectInvalidos.setRowSelectionAllowed(false);
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
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addGap(0, 0, 0))
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
            importReportExcel(l, new CallbackImpExp() {

                @Override
                public void onComplete(List<List> a) {
                    UsuariosVyI = a;
                    if (UsuariosVyI != null) {
                        if (!(UsuariosVyI.get(0).isEmpty() & UsuariosVyI.get(1).isEmpty())) {
                            JOptionPane.showMessageDialog(l, "Operacion realizada con exito.", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                            listEntitysValidos = UsuariosVyI.get(0);
                            listEntitysInvalidos = UsuariosVyI.get(1);
                            llenarTabla(tbleObjectValidos, listEntitysValidos);
                            llenarTabla(tbleObjectInvalidos, listEntitysInvalidos);
                        } else {//Si los dos Arrays estas vacios...
                            JOptionPane.showMessageDialog(l, "El archivo no tiene informacion importable.", "Error", JOptionPane.ERROR_MESSAGE);
                            clearReg();
                        }
                    } else {
                        JOptionPane.showMessageDialog(l, "El archivo no es accesible o no contiene ninguna hoja.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    l.dispose();
                    setEnabled(true);
                    setAlwaysOnTop(false);
                }
            }, selectEntity.getSelectedItem().toString(), f);
        }
    }//GEN-LAST:event_SelectFileBtnMouseClicked

    private void SaveReportBtnAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveReportBtnAdmMouseClicked
        if (listEntitysValidos != null) {
            if (!listEntitysValidos.isEmpty()) {
                File f = StartfileChooser(this.FILE_CHOOSER_EXPORT);

                if (f != null) {
                    LoadingJDialog l = new LoadingJDialog(this, false);
                    l.setVisible(true);
                    setAlwaysOnTop(true);
                    this.setEnabled(false);

                    ExportReportExcel(l, new CallbackImpExp() {
                        public void onComplete(List<List> a) {
                            JOptionPane.showMessageDialog(l, "Operacion realizada con exito.", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                            setEnabled(true);
                            setAlwaysOnTop(false);
                        }
                    }, f, listEntitysValidos);
                }
            }
        }
    }//GEN-LAST:event_SaveReportBtnAdmMouseClicked

    private void SaveReportBtnNoAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveReportBtnNoAdmMouseClicked
        if (listEntitysInvalidos != null) {
            if (!listEntitysInvalidos.isEmpty()) {
                File f = StartfileChooser(this.FILE_CHOOSER_EXPORT);

                if (f != null) {
                    LoadingJDialog l = new LoadingJDialog(this, false);
                    l.setVisible(true);
                    setAlwaysOnTop(true);
                    this.setEnabled(false);

                    ExportReportExcel(l, new CallbackImpExp() {
                        public void onComplete(List<List> a) {
                            JOptionPane.showMessageDialog(l, "Operacion realizada con exito.", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                            setEnabled(true);
                            setAlwaysOnTop(false);
                        }
                    }, f, listEntitysInvalidos);
                }
            }
        }
    }//GEN-LAST:event_SaveReportBtnNoAdmMouseClicked

    private void ImportBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportBtnMouseClicked
        if (listEntitysValidos != null) {
            if (!listEntitysValidos.isEmpty()) {
                LoadingJDialog loadingJDialog = new LoadingJDialog(this, false);
                loadingJDialog.setVisible(true);
                setAlwaysOnTop(true);
                this.setEnabled(false);

                if (listEntitysValidos.get(0) instanceof Users) {
                    addUsersList(loadingJDialog, listEntitysValidos, new CallbackInserts() {
                        @Override
                        public void onComplete(int rowsAffected, String log) {
                            JOptionPane.showMessageDialog(loadingJDialog, "Los campos agregados exitosamente fueron " + rowsAffected + ".", "Operacion Realizada", JOptionPane.INFORMATION_MESSAGE);
                            loadingJDialog.dispose();
                            setEnabled(true);
                            setAlwaysOnTop(false);
                            if (listEntitysValidos.size() > rowsAffected) {
                                generarLog(log);
                            }
                        }
                    });
                } else if (listEntitysValidos.get(0) instanceof Producto) {
                    addProductList(loadingJDialog, listEntitysValidos, new CallbackInserts() {
                        @Override
                        public void onComplete(int rowsAffected, String log) {
                            JOptionPane.showMessageDialog(loadingJDialog, "Los campos agregados exitosamente fueron " + rowsAffected + ".", "Operacion Realizada", JOptionPane.INFORMATION_MESSAGE);
                            loadingJDialog.dispose();
                            setEnabled(true);
                            setAlwaysOnTop(false);
                            if (listEntitysValidos.size() > rowsAffected) {
                                generarLog(log);
                            }
                        }
                    });
                }
            }
        }
    }//GEN-LAST:event_ImportBtnMouseClicked

    private void getListExpEntityBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getListExpEntityBtnMouseClicked
        clearReg();
        if (selectEntity.getSelectedItem().toString().equalsIgnoreCase("Users")) {
            listEntitysValidos = UsersDao.getAllUsersListInExport();
            llenarTabla(tbleObjectValidos, listEntitysValidos);
        } else if (selectEntity.getSelectedItem().toString().equalsIgnoreCase("Productos")) {
            listEntitysValidos = ProductoDao.getAllProductListInExport();
            llenarTabla(tbleObjectValidos, listEntitysValidos);
        }

    }//GEN-LAST:event_getListExpEntityBtnMouseClicked

    private void selectEntityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectEntityItemStateChanged
        //Cada vez q se selecciona una opcion diferente se detecta en el if
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            clearReg();
        }
    }//GEN-LAST:event_selectEntityItemStateChanged

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
    private <T extends Exportables> void ExportReportExcel(LoadingJDialog l, CallbackImpExp callback, File f, List<T> list) {//T Generico que obliga a que el parametro generico herede de la clase Exportables
        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!list.isEmpty()) {
                    l.setMaxValue(list.size());
                    OutputStream outFile;
                    try (XSSFWorkbook libro = new XSSFWorkbook()) {
                        outFile = new FileOutputStream(f);

                        XSSFCellStyle estiloTitulos = new Estilo.BuilderCell()
                                .setBoldText(true)
                                .setColorText("FFFFFF")
                                .setColorFondoHEX("")
                                .setTipoDeRellenoFondo(FillPatternType.SOLID_FOREGROUND)
                                .contruirEstilo(libro);
                        XSSFCellStyle estiloFecha = new Estilo.BuilderCell().setFontFormat("dd/MM/yyyy").contruirEstilo(libro);
                        XSSFSheet createSheet = libro.createSheet();

                        int indexRenglon = 0;

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
                                    if (a instanceof String aa) {//Consulta si a checkTypeCell una instancia de String, si checkTypeCell asi lo cartea como aa
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
                        }
                        libro.write(outFile);
                        //libro.close();
                        outFile.close();
                        if (l.getMaxValue() == (indexRenglon - 1)) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    l.dispose(); // Cerrar el diálogo de carga
                                }
                            });
                            callback.onComplete(null);
                        }

                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No Hay informacion exportable.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tr.start();

    }

    private void importReportExcel(LoadingJDialog l, CallbackImpExp callback, String ObjectName, File f) {
        Thread a = new Thread(new Runnable() {
            List<Object> parametrosGenericos;
            boolean finalizado = false;
            int datosIncompatibles = 0;

            @Override
            public void run() {

                List<Exportables> ObjetosValidos = new ArrayList<>();
                List<Exportables> ObjetosInvalidos = new ArrayList<>();
                List<List> UsuariosVyI = new ArrayList<>(2);
                parametrosGenericos = new ArrayList<>();

                try (Workbook wb = WorkbookFactory.create(f)) {
                    Sheet hoja = wb.getSheetAt(0);
                    int indexRenglon = 0, indexCelda = 0;
                    int cantRows = hoja.getLastRowNum();
                    l.setMaxValue(cantRows);
                    for (Row row : hoja) {

                        if (indexRenglon < cantRows && row.getRowNum() != 0) {
                            for (int cn = 0; cn < row.getLastCellNum(); cn++) {
                                Cell c = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                                switch (indexCelda) {
                                    case 0 -> {
                                        checkTypeCell(c, CellType.STRING);
                                    }
                                    case 1 -> {
                                        checkTypeCell(c, CellType.STRING);
                                    }
                                    case 2 -> {
                                        if (ObjectName.equalsIgnoreCase("Users")) {
                                            checkTypeCell(c, CellType.NUMERIC);//LocalDate
                                        } else {
                                            checkTypeCell(c, CellType.STRING);
                                        }
                                    }
                                    case 3 -> {
                                        checkTypeCell(c, CellType.NUMERIC);
                                    }
                                    default -> {
                                        checkTypeCell(c, CellType.STRING);
                                    }
                                }
                                indexCelda++;
                            }
                            if (ObjectName.equalsIgnoreCase("Users")) {
                                if (datosIncompatibles > 0) {
                                    ObjetosInvalidos.add(new Users(
                                            (String) parametrosGenericos.get(0),
                                            (String) parametrosGenericos.get(1),
                                            (LocalDate) parametrosGenericos.get(2)));
                                } else {
                                    ObjetosValidos.add(new Users((String) parametrosGenericos.get(0),
                                            (String) parametrosGenericos.get(1),
                                            (LocalDate) parametrosGenericos.get(2)));
                                }
                            } else if (ObjectName.equalsIgnoreCase("Productos")) {
                                if (datosIncompatibles > 0) {
                                    ObjetosInvalidos.add(new Producto((String) parametrosGenericos.get(0),
                                            (String) parametrosGenericos.get(1),
                                            (String) parametrosGenericos.get(2),
                                            (Double) parametrosGenericos.get(3)));
                                } else {
                                    ObjetosValidos.add(new Producto((String) parametrosGenericos.get(0),
                                            (String) parametrosGenericos.get(1),
                                            (String) parametrosGenericos.get(2),
                                            (Double) parametrosGenericos.get(3)));
                                }
                            }
                            parametrosGenericos.clear();
                            indexRenglon++;

                        }
                        //System.out.println(indexRenglon);
                        // Actualizar la GUI dentro de SwingUtilities.invokeLater()
                        final int currentValue = indexRenglon;
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                l.setProgress(currentValue);
                                l.setStatus(" " + currentValue + " / " + l.getMaxValue());
                            }
                        });
                        datosIncompatibles = 0;
                        indexCelda = 0;

                    }
                    UsuariosVyI.add(ObjetosValidos);
                    UsuariosVyI.add(ObjetosInvalidos);
                    // Tarea completada
                    if (l.getMaxValue() == (indexRenglon)) {
                        finalizado = true;
                        callback.onComplete(UsuariosVyI);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    if (!finalizado) {
                        callback.onComplete(null);
                    }

                }

            }

            public void checkTypeCell(Cell c, CellType Type) {
                if (Type == CellType.STRING) {
                    if (c.getCellType() == Type) {
                        parametrosGenericos.add(c.getStringCellValue());
                    } else {
                        parametrosGenericos.add("*");
                        datosIncompatibles++;
                    }
                } else if (Type == CellType.NUMERIC) {
                    if (ObjectName.equalsIgnoreCase("Users")) {
                        if (c.getCellType() == Type) {
                            parametrosGenericos.add(c.getLocalDateTimeCellValue().toLocalDate());
                        } else {
                            parametrosGenericos.add(LocalDate.of(0, 1, 1));
                            datosIncompatibles++;
                        }
                    } else {
                        if (c.getCellType() == Type) {
                            parametrosGenericos.add(c.getNumericCellValue());
                        } else {
                            parametrosGenericos.add(0.0);
                            datosIncompatibles++;
                        }
                    }

                }
            }
        }
        );
        a.start();
    }

    public void addProductList(LoadingJDialog loadingJDialog, List<Exportables> listProducts, CallbackInserts callback) {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                loadingJDialog.setMaxValue(listProducts.size());
                int rowsAffected = 0, indexRenglon = 0;
                String log = "", localDate;
                Producto product;
                for (Exportables Product : listProducts) {
                    product = (Producto) Product;
                    if (ProductoDao.addProduct(product)) {
                        rowsAffected++;
                    } else {
                        localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
                        log += localDate + " : " + product.getCodigo() + " : not inserted into the database in duplicate. \n";
                    }
                    indexRenglon++;
                    final int currentValue = indexRenglon;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            loadingJDialog.setProgress(currentValue);
                            loadingJDialog.setStatus(" " + currentValue + " / " + loadingJDialog.getMaxValue());
                        }
                    });
                }
                if (loadingJDialog.getMaxValue() == (indexRenglon)) {
                    callback.onComplete(rowsAffected, log);
                }
            }
        });
        a.start();
    }

    public void addUsersList(LoadingJDialog loadingJDialog, List<Exportables> listUsers, CallbackInserts callback) {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                loadingJDialog.setMaxValue(listUsers.size());
                int rowsAffected = 0, indexRenglon = 0;
                String log = "", localDate;
                Users User;
                for (Exportables listUser : listUsers) {
                    User = (Users) listUser;
                    if (UsersDao.addUser(User)) {
                        rowsAffected++;
                    } else {
                        localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss"));
                        log += localDate + " : " + User.getNombre() + " " + User.getApellido() + " " + User.getFechaDeIngreso() + " : not inserted into the database in duplicate.\n";
                    }
                    indexRenglon++;
                    final int currentValue = indexRenglon;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            loadingJDialog.setProgress(currentValue);
                            loadingJDialog.setStatus(" " + currentValue + " / " + loadingJDialog.getMaxValue());
                        }
                    });
                }
                if (loadingJDialog.getMaxValue() == (indexRenglon)) {
                    callback.onComplete(rowsAffected, log);
                }
            }
        });
        a.start();
    }

    private void generarLog(String log) {
        final String l = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));

        final String userDirectoryPath = System.getProperty("user.dir");
        final String PathLog = userDirectoryPath + "/log";
        final String Path = PathLog + "/" + l + "log.txt";
        File file = new File(PathLog);
        File logFile = new File(Path);
        try {
            if (!file.exists()) {
                file.mkdir();
                if (!logFile.exists()) {
                    logFile.createNewFile();
                }
            }
            System.out.println(log);
            FileWriter flw = new FileWriter(logFile);
            flw.write(log);
            flw.close();
        } catch (IOException ex) {
            //System.out.println(ex);
        }
    }

    private <T extends Exportables> void llenarTabla(javax.swing.JTable tb, List<T> list) {
        ClearTable(tb);
        //int registros = 0;
        if (list != null) {
            if (!list.isEmpty()) {
                javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (tb.getModel());
                for (String titulosAtributo : list.get(0).getTitulosAtributos()) {
                    dm.addColumn(titulosAtributo);
                }
                for (int j = 0; j < list.size(); j++) {
                    dm.addRow(list.get(j).getRow());
                    //registros++;
                }
                tb.setModel(dm);
            }
            //JOptionPane.showMessageDialog(this, registros + " registros cargador en la tabla.", "Atencion!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ClearTable(javax.swing.JTable jTable) {
        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (jTable.getModel());
        dm.setNumRows(0);
        dm.setColumnCount(0);
        jTable.setModel(dm);
    }

    private void clearReg() {
        listEntitysValidos = null;
        listEntitysInvalidos = null;
        ClearTable(tbleObjectValidos);
        ClearTable(tbleObjectInvalidos);
    }

    // Interfaz de callback para manejar el resultado de AccionPesada
    private interface CallbackImpExp {

        void onComplete(List<List> a);
    }

    private interface CallbackInserts {

        void onComplete(int rowsAffected, String log);
    }

    private void setUIM(String ClassNameUI) {
        try {
            UIManager.setLookAndFeel(ClassNameUI);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ImportBtn;
    private javax.swing.JButton SaveReportBtnAdm;
    private javax.swing.JButton SaveReportBtnNoAdm;
    private javax.swing.JButton SelectFileBtn;
    private javax.swing.JButton getListExpEntityBtn;
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
