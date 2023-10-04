/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Teacher;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import AdminLogin.AdminPanel;

/**
 *
 * @author shoto
 */
public class Teacher extends javax.swing.JFrame {

    /** Creates new form Teacher */
    public Teacher() {
        initComponents();
        Image ic=new ImageIcon(this.getClass().getResource("/jpro.jpg")).getImage();
        this.setIconImage(ic);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.S
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnView = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacherTable = new javax.swing.JTable();
        txttesearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TePh = new javax.swing.JTextField();
        TeName = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TeDob = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        TeBck = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JPRO InfoHub Course Management System");
        setMinimumSize(new java.awt.Dimension(1100, 690));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 100, 40));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(102, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 100, 40));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(102, 0, 0));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 100, 40));

        teacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "DoB", "Phone No", "Edu Background"
            }
        ));
        teacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(teacherTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 680, 550));

        txttesearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttesearchActionPerformed(evt);
            }
        });
        txttesearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttesearchKeyReleased(evt);
            }
        });
        jPanel2.add(txttesearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 250, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, -1));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Enter Teacher's Data");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 8, 180, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 0, 0));
        jLabel14.setText(":");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 10, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Edu Background");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Phone No");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Date of Birth");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText(":");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 20, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 0));
        jLabel12.setText(":");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 20, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 0));
        jLabel13.setText(":");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 20, 30));

        TePh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TePh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TePhActionPerformed(evt);
            }
        });
        jPanel4.add(TePh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 230, 30));

        TeName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeNameActionPerformed(evt);
            }
        });
        jPanel4.add(TeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 230, 30));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 0, 51));
        jLabel67.setText("*");
        jPanel4.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 20, 20));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 0, 51));
        jLabel68.setText("*");
        jPanel4.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 20, 20));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 0, 51));
        jLabel69.setText("*");
        jPanel4.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 20, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Name");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        jPanel4.add(TeDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 230, 30));

        TeBck.setColumns(20);
        TeBck.setRows(5);
        jScrollPane2.setViewportView(TeBck);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 230, 120));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 390, 460));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Sync30px-removebg-preview.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 35, 35));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1100, 620));

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 70));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Teacher Information");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hupdate.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 60, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TePhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TePhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TePhActionPerformed

    private void TeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeNameActionPerformed

    private void txttesearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttesearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttesearchActionPerformed
  int id=0;
    private void teacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherTableMouseClicked
        int index = teacherTable.getSelectedRow();

            if(index<0){
               JOptionPane.showMessageDialog(null, "Please select any record from table for update");
            }else
            { 
                int id=(int) teacherTable.getValueAt(index, 0);
                TeacherDAO tdao=new TeacherDAO();
                Teacher_Class tcc=tdao.returnAllDataToTextfield(id);
                TeName.setText(tcc.getName());
                  TeDob.setDate(tcc.getDoB());
                  TePh.setText(tcc.getPhno());
                  TeBck.setText(tcc.getEduback());
   


            }
    }//GEN-LAST:event_teacherTableMouseClicked

    private void txttesearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttesearchKeyReleased
                DefaultTableModel model = (DefaultTableModel)teacherTable.getModel();
                  TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
                  teacherTable.setRowSorter(tr);
                  tr.setRowFilter(RowFilter.regexFilter(txttesearch.getText()));
    }//GEN-LAST:event_txttesearchKeyReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         dispose(); 
        AdminPanel ad = new AdminPanel();
             ad.setVisible(true);
             ad.loginPane.setVisible(false);
             ad.logoutpane.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean ch=inputCheck();
        if(ch==true){

            String name=TeName.getText();
            Date d=new Date(TeDob.getDate().getTime());
            String pno=TePh.getText();
            String edu=TeBck.getText();
            Teacher_Class tcc = new Teacher_Class(0, name, d, pno, edu);
            TeacherDAO tdao=new TeacherDAO();

            int choice=JOptionPane.showConfirmDialog(null, "Do you really want to save your data","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
            if(choice==JOptionPane.YES_OPTION)

            tdao.insert(tcc);
            loadtable();
            TeName.setText("");
            TeDob.setDate(null);
            TePh.setText(null);
            TeBck.setText(null);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        int SelectedRows = teacherTable.getSelectedRow();
        if(SelectedRows<0){
            JOptionPane.showMessageDialog(null, "Please select any record from table for update");
        }else
        {
            boolean ch=inputCheck();
            if(ch==true){

                DefaultTableModel model = (DefaultTableModel)teacherTable.getModel();
                id = Integer.parseInt(teacherTable.getValueAt(SelectedRows, 0).toString());

                String name=TeName.getText();
                Date d=new Date(TeDob.getDate().getTime());
                String pno=TePh.getText();
                String edu=TeBck.getText();

                Teacher_Class tcc = new Teacher_Class(id, name, d, pno, edu);
                TeacherDAO tdao=new TeacherDAO();
                int choice=JOptionPane.showConfirmDialog(null, "Do you really want to save your data","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
                if(choice==JOptionPane.YES_OPTION)
                tdao.updateData(tcc);
                loadtable();
                TeName.setText("");
                TeDob.setDate(null);
                TePh.setText("");
                TeBck.setText("");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
//        loadtable();
                TeName.setText("");
                TeDob.setDate(null);
                TePh.setText("");
                TeBck.setText("");
    }//GEN-LAST:event_btnViewActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       txttesearch.setText(null);
         DefaultTableModel model = (DefaultTableModel)teacherTable.getModel();
        TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
        teacherTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txttesearch.getText()));
      loadtable();
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TeBck;
    private com.toedter.calendar.JDateChooser TeDob;
    private javax.swing.JTextField TeName;
    private javax.swing.JTextField TePh;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTable teacherTable;
    private javax.swing.JTextField txttesearch;
    // End of variables declaration//GEN-END:variables

 public boolean inputCheck(){
		boolean result=false;
		if(TeName.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Name is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
		  TeName.requestFocus();
		  }
		else{
			if(TeDob.getDate()==null){
				JOptionPane.showMessageDialog(null, "Date Of Birth is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
				
			}
                            else{
                                if(TePh.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Phone Number is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
                                }else{
                                    String tepnoPattern = "09-\\d{9}";
                                    String teNo = TePh.getText().trim();
          
                                         if (!teNo.matches(tepnoPattern)) {
                                        JOptionPane.showMessageDialog(null, "Phone Number should start with 09- and only 11 digits", "Invalid Course Number", JOptionPane.ERROR_MESSAGE);
                                        TePh.requestFocus();
                                         } else {
                                    if(TeBck.getText().isEmpty()){
                                        JOptionPane.showMessageDialog(null, "Eduaction Background is required data","Input Missing Error",JOptionPane.ERROR_MESSAGE);
                                    }else return true;
                                }
                            }
                        }
                }
			
		return result;
	}
 
 public void loadAllDataintoTable(ArrayList<Teacher_Class>list){
        
        DefaultTableModel dtm=(DefaultTableModel) teacherTable.getModel();
        dtm.setRowCount(0);
        
        for(Teacher_Class tcc :list){
            Vector v=new Vector();
            v.add(tcc.getTid());
            v.add(tcc.getName());
            v.add(tcc.getDoB());
            v.add(tcc.getPhno());
            v.add(tcc.getEduback());
            dtm.addRow(v);
            
        } 
      }
  
        
        
     
        public void loadtable(){
            
            TeacherDAO tdao=new TeacherDAO();
            ArrayList list=tdao.loadTeacherData();
            loadAllDataintoTable(list);
        }

   
        
     

}
