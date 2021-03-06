/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elle.ProjectManager.presentation;

import com.elle.ProjectManager.controller.PMDataManager;
import com.elle.ProjectManager.database.DBConnection;
import com.elle.ProjectManager.entities.AccessLevel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * this window is for admin to change accesslevels tables
 * @author Yi 
 * @date 7/3/2016
 */
public class EditAccessLevelsWindow extends javax.swing.JFrame {
    
    private PMDataManager dataManager;
    
    private ArrayList<AccessLevel> users;
    private Set<Integer> updatedRows;
    private Set<String> dropdownItems;

    /**
     * Creates new form EditAccessLevelsWindow
     */
    public EditAccessLevelsWindow() {
        dataManager = PMDataManager.getInstance();
        
        users = dataManager.getUsers();  //get all accounts from db
        updatedRows = new HashSet(); //initialize the updaterows
        dropdownItems = getAccessLevels(); //get all access levels from db for cmobobox
        
        
        //set up UI
        setUpUI();
        
    }
    
    private Set<String> getAccessLevels() {
        Set<String> levels = new HashSet();
        for(AccessLevel acct: users) {
            levels.add(acct.getAccessLevel());
        }
        return levels;
        
    }
    
    
    private void setUpUI(){
        initComponents();
        //set up db server and db name
        serverLabel.setText(DBConnection.getServer());
        databaseLabel.setText(DBConnection.getDatabase());
        
        
        //set up combobox for accesslevel column
        TableColumn accessLevelsColumn = accessLevelsTable.getColumnModel().getColumn(2);
        setUpAccessLevelsColumn(accessLevelsTable, accessLevelsColumn);
        
        DefaultTableModel model = (DefaultTableModel) accessLevelsTable.getModel();
        
        loadTableData();
        
        //align id column to the center
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        accessLevelsTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        
        //set infolabel empty
        informationLabel.setText("");
        
        //set up selection mode to single selection
        accessLevelsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //add listener for table update rows
        accessLevelsTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE)
                    updatedRows.add(e.getFirstRow());
                
            }

        });
    }
    
    
    private void loadTableData(){
        DefaultTableModel model = (DefaultTableModel) accessLevelsTable.getModel();
        for(AccessLevel acct : users) {
            Vector rowData = new Vector(3);
            rowData.add(acct.getId());
            rowData.add(acct.getUser());
            rowData.add(acct.getAccessLevel());
            model.addRow(rowData);
        }
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        serverLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        databaseLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accessLevelsTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        informationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Access Levels");

        jLabel1.setText("Server:");

        serverLabel.setText("ServerName");

        jLabel2.setText("Database:");

        databaseLabel.setText("DatabaseName");

        accessLevelsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "User", "AccessLevels"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accessLevelsTable.setRowHeight(22);
        jScrollPane1.setViewportView(accessLevelsTable);
        if (accessLevelsTable.getColumnModel().getColumnCount() > 0) {
            accessLevelsTable.getColumnModel().getColumn(0).setResizable(false);
            accessLevelsTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            accessLevelsTable.getColumnModel().getColumn(1).setResizable(false);
            accessLevelsTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(databaseLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(5, 5, 5))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(serverLabel)
                    .addComponent(jLabel2)
                    .addComponent(databaseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        informationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationLabel.setText("infoLabel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addGap(5, 5, 5)
                .addComponent(informationLabel)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        AddNewAccountWindow addWindow = new AddNewAccountWindow(this);
        addWindow.setLocationRelativeTo(this);
        addWindow.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedRow = accessLevelsTable.getSelectedRow();
        int id = users.get(selectedRow).getId();
        String name = users.get(selectedRow).getUser();
        dataManager.deleteUser(id);
        users.remove(selectedRow);
        
        //delete acct from table
        DefaultTableModel model = (DefaultTableModel) accessLevelsTable.getModel();
        model.removeRow(selectedRow);

        setInformationLabel("Selected user is deleted successfully", 10);
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // check updated rows to find out the real updated acct, and update to db
        int cnt = 0;
        
        DefaultTableModel model = (DefaultTableModel) accessLevelsTable.getModel();
        for(Integer row: updatedRows) {
            String updatedValue = (String)model.getValueAt(row, 2);
            String originalValue = users.get(row).getAccessLevel();
            if(!originalValue.equals(updatedValue)) {
                users.get(row).setAccessLevel(updatedValue);
                dataManager.updateUser(users.get(row));
                cnt++;
            }
        }
        
        
        if (cnt > 0) {
            //reset updated rows
            updatedRows = new HashSet();
            setInformationLabel("Accounts updated successfully", 10);
        }
            
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

   
    
    public void setUpAccessLevelsColumn(JTable table,
                TableColumn accessLevelsColumn) {
    //Set up the editor for the sport cells.
    JComboBox comboBox = new JComboBox();
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    for(String item : dropdownItems) {
        model.addElement(item);
    }
    
    comboBox.setModel(model);
    accessLevelsColumn.setCellEditor(new DefaultCellEditor(comboBox));
    
}

  
    public void setInformationLabel(String inf, int second) {
        this.informationLabel.setText(inf);
        informationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        startCountDownFromNow(second);
    }

    public void startCountDownFromNow(int waitSeconds) {
        Timer timer = new Timer(waitSeconds * 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                informationLabel.setText("");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    

    public void insert(AccessLevel newaccount) {
        //add new data to db, and accounts
        dataManager.insertUser(newaccount);
        users = dataManager.getUsers();

        //add data to table
        DefaultTableModel model = (DefaultTableModel) accessLevelsTable.getModel();

        Vector rowData = new Vector(3);
        rowData.add(newaccount.getId());
        rowData.add(newaccount.getUser());
        rowData.add(newaccount.getAccessLevel());
        model.addRow(rowData);
   
        setInformationLabel("New account is created successfully", 10);

    }
    
    //getter and setter

    public Set<String> getDropdownItems() {
        return dropdownItems;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accessLevelsTable;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel databaseLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel serverLabel;
    // End of variables declaration//GEN-END:variables
}


