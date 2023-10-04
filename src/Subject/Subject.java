 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Subject;

import AdminLogin.AdminPanel;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author shoto
 */
public class Subject extends javax.swing.JFrame {
      private Connection con;
    /**
     * Creates new form Subject
     */
    public Subject() {
        initComponents();
         Image ic=new ImageIcon(this.getClass().getResource("/jpro.jpg")).getImage();
        this.setIconImage(ic);
        
    }

       public void getCourseName(){
        try {
      
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub", "root", "root");
            String query = "SELECT Course_name FROM course";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String item = resultSet.getString("Course_name");
                txtCourseName.addItem(item);
            }

            // Step 10: Close the database connection
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnView = new javax.swing.JButton();
        txtCourseName = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjtable = new javax.swing.JTable();
        txtsubname = new javax.swing.JTextField();
        txtSubSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtsubno = new javax.swing.JTextField();
        txtupno = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtsubdesc = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtsubrefbook = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JPRO InfoHub Course Management System");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 70));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Subject Information");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, -10, -1, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hupdate.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 50, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 3));
        jPanel2.setMinimumSize(new java.awt.Dimension(1090, 580));
        jPanel2.setPreferredSize(new java.awt.Dimension(1090, 580));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnView.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnView.setForeground(new java.awt.Color(102, 0, 0));
        btnView.setText("Clear");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel2.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 100, 40));

        txtCourseName.setModel(new javax.swing.DefaultComboBoxModel<>());
        txtCourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 230, 30));
        getCourseName();

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(102, 0, 0));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 100, 40));

        subjtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Subject Id", "Subject No", "Course Name", "Subjct Name", "Referenced Book", "Description"
            }
        ));
        subjtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(subjtable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 690, 520));

        txtsubname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsubname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubnameActionPerformed(evt);
            }
        });
        jPanel2.add(txtsubname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 230, 30));

        txtSubSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSubSearchKeyReleased(evt);
            }
        });
        jPanel2.add(txtSubSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 250, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, -1));

        txtsubno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsubno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubnoActionPerformed(evt);
            }
        });
        jPanel2.add(txtsubno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 230, 30));

        txtupno.setEditable(false);
        txtupno.setBackground(new java.awt.Color(204, 204, 204));
        txtupno.setText("jTextField1");
        jPanel2.add(txtupno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 230, -1));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Enter Subject Data");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 18, 160, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Course Name");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Subject Name");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Reference book");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Description");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setText(":");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 20, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 0, 0));
        jLabel14.setText(":");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 20, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 0));
        jLabel13.setText(":");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 152, 20, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 0));
        jLabel12.setText(":");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 102, 20, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText(":");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 20, -1));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 0, 51));
        jLabel67.setText("*");
        jPanel4.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 20, 20));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 0, 51));
        jLabel68.setText("*");
        jPanel4.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 20, 20));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 0, 51));
        jLabel69.setText("*");
        jPanel4.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 20, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Subject No");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtsubdesc.setColumns(20);
        txtsubdesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsubdesc.setRows(5);
        jScrollPane2.setViewportView(txtsubdesc);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 230, 140));

        txtsubrefbook.setColumns(20);
        txtsubrefbook.setRows(5);
        jScrollPane3.setViewportView(txtsubrefbook);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 230, 90));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, 450));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(102, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 100, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Sync30px-removebg-preview.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 35, 35));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1100, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsubnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubnameActionPerformed

    private void txtsubnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubnoActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        txtsubno.setVisible(true);
        boolean ch=inputCheck();
       if(ch==true){  
        String cname=txtCourseName.getSelectedItem().toString();
        String subname=txtsubname.getText();
        String refb=txtsubrefbook.getText();
        String descbo=txtsubdesc.getText();
        String sn=txtsubno.getText();
        Subject_Class scc=new Subject_Class(0,cname,subname,refb,descbo,sn);
        SubjectDAO sdao=new SubjectDAO();
        int choice=JOptionPane.showConfirmDialog(null, "Do you really want to save your data","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
            if(choice==JOptionPane.YES_OPTION)
        sdao.insert_subject(scc);
            loadSubjecttable();
                txtCourseName.setSelectedItem(null);
                txtsubname.setText("");
                txtsubrefbook.setText("");
                txtsubdesc.setText("");
                txtsubno.setText("");
       }       
            
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
                txtCourseName.setSelectedItem(null);
                txtsubno.setVisible(true);
                txtsubname.setText("");
                txtsubrefbook.setText("");
                txtsubdesc.setText("");
                txtsubno.setText("");
        
    }//GEN-LAST:event_btnViewActionPerformed
  int id=0;
    private void subjtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjtableMouseClicked
       int index = subjtable.getSelectedRow();
           txtsubno.setVisible(false);
            txtupno.setVisible(true);
            if(index<0){
               JOptionPane.showMessageDialog(null, "Please select any record from table for update");
            }else
            { 
                int id=(int) subjtable.getValueAt(index, 0);
                SubjectDAO sdao=new SubjectDAO();
                Subject_Class scc=sdao.returnAllDataTosubjectTextfield(id); 
                txtCourseName.setSelectedItem(scc.getCoursename());
                txtsubname.setText(scc.getSubname());
                txtupno.setText(scc.getSub_no());
                txtsubrefbook.setText(scc.getRefbook());
                txtsubdesc.setText(scc.getDesc_book());
//                txtsubno.setText(scc.getSub_no());
               

                
            }
    }//GEN-LAST:event_subjtableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       
        txtupno.setVisible(true);
        int index = subjtable.getSelectedRow();
        if(index<0){
               JOptionPane.showMessageDialog(null, "Please select any record from table for update");
            }else
            {   
                boolean ch=inputupdateCheck();
       if(ch==true){  
                DefaultTableModel model = (DefaultTableModel)subjtable.getModel();
                
                id = Integer.parseInt(subjtable.getValueAt(index, 0).toString());
                 
                  String cname=txtCourseName.getSelectedItem().toString();
                  String subname=txtsubname.getText();
                  String ref=txtsubrefbook.getText();
                  String descbo=txtsubdesc.getText();
                  String sn=txtupno.getText();
                Subject_Class scc=new Subject_Class(id,cname,subname,ref,descbo,sn);
                SubjectDAO sdao=new SubjectDAO();
                int choice=JOptionPane.showConfirmDialog(null, "Do you really want to save your data","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
                  if(choice==JOptionPane.YES_OPTION)
                  sdao.updateSubject_Data(scc);
                 loadSubjecttable();
                   txtCourseName.setSelectedItem(null);
                txtsubname.setText("");
                txtsubrefbook.setText("");
                txtsubdesc.setText("");
                txtupno.setText("");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtCourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseNameActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
        AdminPanel ad = new AdminPanel();
             ad.setVisible(true);
             ad.loginPane.setVisible(false);
             ad.logoutpane.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txtSubSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel)subjtable.getModel();
                  TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
                  subjtable.setRowSorter(tr);
                  tr.setRowFilter(RowFilter.regexFilter(txtSubSearch.getText())); 
    }//GEN-LAST:event_txtSubSearchKeyReleased

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
      
        txtSubSearch.setText(null);
         DefaultTableModel model = (DefaultTableModel)subjtable.getModel();
        TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
        subjtable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtSubSearch.getText()));
       loadSubjecttable();
        
    }//GEN-LAST:event_jLabel15MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Subject().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable subjtable;
    private javax.swing.JComboBox<String> txtCourseName;
    private javax.swing.JTextField txtSubSearch;
    private javax.swing.JTextArea txtsubdesc;
    private javax.swing.JTextField txtsubname;
    private javax.swing.JTextField txtsubno;
    private javax.swing.JTextArea txtsubrefbook;
    private javax.swing.JTextField txtupno;
    // End of variables declaration//GEN-END:variables

    public boolean inputCheck(){
		boolean result=false;
		if(txtsubno.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Subject No is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
		  txtsubno.requestFocus();
		  }
		else{ String subnoPattern = "(JP-Sub|IP-Sub|FE-Sub)\\d+$";
                       String subNo = txtsubno.getText().trim();

               if (!subNo.matches(subnoPattern)) {
                   JOptionPane.showMessageDialog(null, "Subject Number should start with JP-Sub ,IT-Sub or FE-Sub", "Invalid Subject Number", JOptionPane.ERROR_MESSAGE);
                 } else {
                   String cno = txtsubno.getText().trim();
                   if(new SubjectDAO().isSubjectNoExist(cno)){
                  JOptionPane.showMessageDialog(this, "This subject No. is already exists","Existing data",JOptionPane.ERROR_MESSAGE);
                   }else {
                    
			if(txtCourseName.getSelectedItem()==null){
				JOptionPane.showMessageDialog(null, "Course Name is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
				
			}
                            else{
                                if(txtsubname.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Subject Name is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
                                }else{
                                    if(txtsubrefbook.getText().isEmpty()){
                                        JOptionPane.showMessageDialog(null, "Reference Book is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
                                    }else{
                                        if(txtsubdesc.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Subject Description is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
                                }else return true;
                                    }
                                }
                            }
                        }
                    }
                }
			
		return result;
	}
    
    public boolean inputupdateCheck(){
		boolean result=false;
	
			if(txtCourseName.getSelectedItem()==null){
				JOptionPane.showMessageDialog(null, "Course Name is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
				
			}
                            else{
                                if(txtsubname.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Subject Name is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
                                }else{
                                    if(txtsubrefbook.getText().isEmpty()){
                                        JOptionPane.showMessageDialog(null, "Reference Book is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
                                    }else{
                                        if(txtsubdesc.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Subject Description is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
                                }else return true;
                                    }
                                }
                            }
                       
                    
                
			
		return result;
	}
    
    
     public void loadAllSubjectDataintoTable(ArrayList<Subject_Class>listsub){
        
        DefaultTableModel dtm=(DefaultTableModel) subjtable.getModel();
        dtm.setRowCount(0);
        
        for(Subject_Class scc :listsub){
            Vector v=new Vector();
            v.add(scc.getSub_id());
            v.add(scc.getSub_no());
            v.add(scc.getCoursename());
            v.add(scc.getSubname());
            v.add(scc.getRefbook());
            v.add(scc.getDesc_book());
            dtm.addRow(v);
            
        } 
      }
  
        
        
     
        public void loadSubjecttable(){
            
            SubjectDAO sdao=new SubjectDAO();
            ArrayList listsub=sdao.loadSubjectdata();
            loadAllSubjectDataintoTable(listsub);
        }


}
