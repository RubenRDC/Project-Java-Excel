package com.rubenrdc.lectorexcel.IGU;

import com.rubenrdc.lectorexcel.IGU.logic.LogicImpExpEntity;
import com.rubenrdc.lectorexcel.models.dao.EntityDao;
import com.rubenrdc.lectorexcel.models.interfaces.Utilities;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class LectorExcelIGU extends javax.swing.JFrame implements Utilities {

    private List<String> columnTableEntitys;
    private List<Integer> columnTableTypes;
    private List<Object[]> entitysValidos;
    private List<Object[]> entitysInvalidos;

    private final EntityDao genericEntityDao = new EntityDao();
    private final LogicImpExpEntity logicImpExpEntity = new LogicImpExpEntity(this);

    public LectorExcelIGU() {
        this.setResizable(false);
        initComponents();
        cargarEntidades();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbleObjectValidos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        saveInfoBtnAdm = new javax.swing.JButton();
        ImportBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtImportPath = new javax.swing.JTextField();
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

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 245));

        tbleObjectValidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbleObjectValidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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

        saveInfoBtnAdm.setText("Exportar Informacion");
        saveInfoBtnAdm.setMargin(new java.awt.Insets(1, 1, 1, 1));
        saveInfoBtnAdm.setMaximumSize(new java.awt.Dimension(155, 25));
        saveInfoBtnAdm.setMinimumSize(new java.awt.Dimension(155, 25));
        saveInfoBtnAdm.setPreferredSize(new java.awt.Dimension(155, 30));
        saveInfoBtnAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveInfoBtnAdmMouseClicked(evt);
            }
        });

        ImportBtn.setText("Importar");
        ImportBtn.setMargin(new java.awt.Insets(1, 1, 1, 1));
        ImportBtn.setMaximumSize(new java.awt.Dimension(126, 25));
        ImportBtn.setMinimumSize(new java.awt.Dimension(126, 25));
        ImportBtn.setPreferredSize(new java.awt.Dimension(126, 30));
        ImportBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImportBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(ImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveInfoBtnAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveInfoBtnAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        SelectFileBtn.setText("Seleccionar Archivo");
        SelectFileBtn.setMargin(new java.awt.Insets(1, 1, 1, 1));
        SelectFileBtn.setMaximumSize(new java.awt.Dimension(150, 30));
        SelectFileBtn.setMinimumSize(new java.awt.Dimension(150, 30));
        SelectFileBtn.setPreferredSize(new java.awt.Dimension(150, 30));
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

        selectEntity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selectEntity.setMaximumSize(new java.awt.Dimension(72, 32));
        selectEntity.setMinimumSize(new java.awt.Dimension(72, 32));
        selectEntity.setPreferredSize(new java.awt.Dimension(240, 32));
        selectEntity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectEntityItemStateChanged(evt);
            }
        });

        getListExpEntityBtn.setText("Obtener Registros");
        getListExpEntityBtn.setMargin(new java.awt.Insets(1, 1, 1, 1));
        getListExpEntityBtn.setMaximumSize(new java.awt.Dimension(150, 30));
        getListExpEntityBtn.setMinimumSize(new java.awt.Dimension(150, 30));
        getListExpEntityBtn.setPreferredSize(new java.awt.Dimension(150, 30));
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(SelectFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtImportPath, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectEntity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getListExpEntityBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(selectEntity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtImportPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getListExpEntityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(400, 245));

        tbleObjectInvalidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbleObjectInvalidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        SaveReportBtnNoAdm.setMargin(new java.awt.Insets(1, 1, 1, 1));
        SaveReportBtnNoAdm.setMaximumSize(new java.awt.Dimension(126, 25));
        SaveReportBtnNoAdm.setMinimumSize(new java.awt.Dimension(126, 25));
        SaveReportBtnNoAdm.setPreferredSize(new java.awt.Dimension(126, 30));
        SaveReportBtnNoAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveReportBtnNoAdmMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SaveReportBtnNoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveReportBtnNoAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        File StartfileChooser = logicImpExpEntity.StartfileChooser(LogicImpExpEntity.FILE_CHOOSER_IMPORT);
        if (StartfileChooser != null) {
            txtImportPath.setText(StartfileChooser.toString());
            LoadingJDialog loadingJDialog = new LoadingJDialog(this, false);
            loadingJDialog.setVisible(true);
            logicImpExpEntity.loadReportExcelInfo(loadingJDialog, StartfileChooser, columnTableEntitys, columnTableTypes);
        }
    }//GEN-LAST:event_SelectFileBtnMouseClicked

    private void saveInfoBtnAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveInfoBtnAdmMouseClicked
        if (entitysValidos != null) {
            if (!entitysValidos.isEmpty()) {
                File StartfileChooser = logicImpExpEntity.StartfileChooser(LogicImpExpEntity.FILE_CHOOSER_EXPORT);
                if (StartfileChooser != null) {
                    LoadingJDialog loadingJDialog = new LoadingJDialog(this, false);
                    loadingJDialog.setVisible(true);
                    logicImpExpEntity.exportReportExcel(loadingJDialog, StartfileChooser, columnTableEntitys, columnTableTypes, entitysValidos);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No Hay informacion exportable.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Hay informacion exportable.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveInfoBtnAdmMouseClicked

    private void SaveReportBtnNoAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveReportBtnNoAdmMouseClicked
        if (entitysInvalidos != null) {
            if (!entitysInvalidos.isEmpty()) {
                File StartfileChooser = logicImpExpEntity.StartfileChooser(LogicImpExpEntity.FILE_CHOOSER_EXPORT);
                if (StartfileChooser != null) {
                    LoadingJDialog loadingJDialog = new LoadingJDialog(this, false);
                    loadingJDialog.setVisible(true);
                    logicImpExpEntity.exportReportExcel(loadingJDialog, StartfileChooser, columnTableEntitys, columnTableTypes, entitysInvalidos);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No Hay informacion exportable.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Hay informacion exportable.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveReportBtnNoAdmMouseClicked

    private void ImportBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportBtnMouseClicked
        if (entitysValidos != null) {
            if (!entitysValidos.isEmpty()) {
                LoadingJDialog loadingJDialog = new LoadingJDialog(this, false);
                loadingJDialog.setVisible(true);
                logicImpExpEntity.importDB(genericEntityDao,loadingJDialog, columnTableEntitys, entitysValidos, selectEntity.getSelectedItem().toString());
            } else {
                JOptionPane.showMessageDialog(this, "No Hay informacion importable.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Hay informacion importable.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ImportBtnMouseClicked

    private void getListExpEntityBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getListExpEntityBtnMouseClicked
        entitysValidos = genericEntityDao.getInfoTable(selectEntity.getSelectedItem().toString());
        llenarTabla(tbleObjectValidos, entitysValidos);
    }//GEN-LAST:event_getListExpEntityBtnMouseClicked

    private void selectEntityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectEntityItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String toString = selectEntity.getSelectedItem().toString();
            cargarColumnas(toString);
        }
    }//GEN-LAST:event_selectEntityItemStateChanged

    private void cargarEntidades() {
        selectEntity.removeAllItems();
        List<String> tableNameEntitys = genericEntityDao.getTableNameEntitys();
        if (tableNameEntitys != null) {
            for (String tableNameEntity : tableNameEntitys) {
                selectEntity.addItem(tableNameEntity);
            }
        }
    }

    private void cargarColumnas(String Table) {
        genericEntityDao.getColumTable(Table);

        columnTableEntitys = genericEntityDao.getColumnTableEntitys();
        columnTableTypes = genericEntityDao.getColumnTableTypes();

        setColumTable(tbleObjectValidos, columnTableEntitys);
        setColumTable(tbleObjectInvalidos, columnTableEntitys);
        clearContent();
    }
    private void clearContent() {
        if (entitysValidos != null) {
            entitysValidos.clear();
            entitysValidos = null;
        }
        if (entitysInvalidos != null) {
            entitysInvalidos.clear();
            entitysInvalidos = null;
        }
        clearTable(tbleObjectValidos);
        clearTable(tbleObjectInvalidos);
    }
    public void setEntitysValidos(List<Object[]> entitysValidos) {
        llenarTabla(tbleObjectValidos, entitysValidos);
        this.entitysValidos = entitysValidos;
    }

    public void setEntitysInvalidos(List<Object[]> entitysInvalidos) {
        llenarTabla(tbleObjectInvalidos, entitysInvalidos);
        this.entitysInvalidos = entitysInvalidos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ImportBtn;
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
    private javax.swing.JButton saveInfoBtnAdm;
    private javax.swing.JComboBox<String> selectEntity;
    private javax.swing.JTable tbleObjectInvalidos;
    private javax.swing.JTable tbleObjectValidos;
    private javax.swing.JTextField txtImportPath;
    // End of variables declaration//GEN-END:variables
}
