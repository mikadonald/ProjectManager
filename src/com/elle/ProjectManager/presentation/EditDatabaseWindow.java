
package com.elle.ProjectManager.presentation;

import com.elle.ProjectManager.logic.LoggingAspect;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


/**
 *
 * @author Louis W.
 * @author Carlos Igreja
 * @since June 10, 2015
 * @version 0.6.3
 */
public class EditDatabaseWindow extends javax.swing.JFrame {
    
    LoginWindow L ;
    boolean flag = false;   // true if call this class from log in window
    
    /**
     * Creates new form EditDatabaseList
     */
    public EditDatabaseWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadList();
    }
    
    // Call this class from log in window
    public EditDatabaseWindow(LoginWindow l) {
        initComponents();
        L = l;
        flag = true;
        this.setLocationRelativeTo(L);
        loadList();
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
        jServer = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDBList = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jConfirm = new javax.swing.JButton();
        jCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jServer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AWS", "Local" }));
        jServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jServerActionPerformed(evt);
            }
        });

        jDBList.setColumns(20);
        jDBList.setRows(5);
        jScrollPane1.setViewportView(jDBList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jServer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jServer)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        jConfirm.setText("Confirm");
        jConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmActionPerformed(evt);
            }
        });

        jCancel.setText("Cancel");
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jCancelActionPerformed

    private void jConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmActionPerformed
        saveRecords();
    }//GEN-LAST:event_jConfirmActionPerformed

    private void jServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jServerActionPerformed
        loadList();
    }//GEN-LAST:event_jServerActionPerformed
    
    /**
     *  This looks like the same method in LoginWindow class
     */
    private void loadList() {
        File dbFile = new File("database.txt");
//        String server = jServer.getSelectedItem().toString();
        String ln = System.getProperty("line.separator");
        String list = "";
        
        if (!dbFile.exists()) {
//            if (server.equals("AWS"))
                jDBList.setText("dummy\nElle2015");
//            else if (server.equals("Local"))
//                jDBList.setText("text");
        
        } else {    // this file exists
            BufferedReader buf = null;
            try{
                buf = new BufferedReader(new FileReader(dbFile));
                // buf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String temp = null ;
                while ((temp = buf.readLine()) != null ){
//                    if (temp.equals(server)) {
//                        while (!(temp = buf.readLine()).equals("-1") && temp != null) {
//                                && !temp.equals(ln))
                            if (!temp.equals(""))       // remove extra lines
                                list += temp + "\n";    
//                        }
//                        break;
//                    }
                }
                if (list.equals("")) {
                    // To do
                } else {
                    jDBList.setText(list);
                }
                
            } catch(Exception e) {
                LoggingAspect.afterThrown(e);
            }
        }
        
        
    }
    
    public void saveRecords() {
//        String server = jServer.getSelectedItem().toString();
        String line, input = "";
        String ln = System.getProperty("line.separator");
        String dbList = jDBList.getText().replaceAll("\n", ln);
        boolean recordExist = false;
        
        File dbFile = new File ("database.txt");
        

        // Rewrite the existing file
        if (dbFile.exists()) {
//            JOptionPane.showMessageDialog(null, dbFile.getName());
            
            // Check whether old records exist
            try {
                BufferedReader file = new BufferedReader(new FileReader("database.txt"));
                try {
                    while ((line = file.readLine()) != null) {
//                        if (line.equals("AWS")) {
//                            input += line + '\n';
//                            while ((line = file.readLine()) != null && !line.equals("-1"))
                                input += line + '\n';   // content that needed to be update
                            recordExist = true;
//                        } else {
//                            other += line + '\n';   // unchanged content
//                        }
                    }
                    
                    if (recordExist) {  // records exist
//                        input = server + "\n" + dbList + "\n-1\n";
                        input = dbList;
                        input = input.replaceAll("\n", ln);
//                        other = other.replaceAll("\n", ln);
                        FileOutputStream File = new FileOutputStream("database.txt");
//                        File.write((input + other).getBytes());
                        File.write(input.getBytes());
                        
                    } else {            // no relevent records
                        try {
                            JOptionPane.showMessageDialog(null, dbList);
                            BufferedWriter output = new BufferedWriter(new FileWriter(dbFile, true));
//                            output.append(server + "\n");
                            output.append(dbList);
//                            output.append("-1");
                            output.close();
                            
                        } catch (FileNotFoundException ex) {
                            LoggingAspect.afterThrown(ex);
                        }
                    }
                } catch (IOException e) {
                    LoggingAspect.afterThrown(e);
                }
            } catch (FileNotFoundException ex) {
                LoggingAspect.afterThrown(ex);
            }
        
        // Create a new file
        } else {

            try {
//                JOptionPane.showMessageDialog(null, "2");
                dbFile.createNewFile();
            } catch (IOException ex) {
                LoggingAspect.afterThrown(ex);
            }
            
            // Output to the new file
            try
            {
                JOptionPane.showMessageDialog(null, dbList);
                PrintWriter printWriter = new PrintWriter(dbFile);
//                printWriter.println (server);   // First line
                printWriter.println (dbList);
//                printWriter.println ("-1");     // Last line
                printWriter.close();
            } catch (FileNotFoundException ex) {
                LoggingAspect.afterThrown(ex);
            }
        }
//        dbFile.getParentFile().mkdirs();
        
        // this is if the actual database list is edited in EditDatabaseWindow 
        // then it updates the combobox with the new values in LoginWindow.
        if (flag == true)   // go back to log in window
            L.loadDBList();   
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCancel;
    private javax.swing.JButton jConfirm;
    private javax.swing.JTextArea jDBList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jServer;
    // End of variables declaration//GEN-END:variables
}
