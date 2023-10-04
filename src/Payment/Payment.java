/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Payment;


import AdminLogin.AdminPanel;
import Batch.BatchUI;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Batch.BatchStdPayModel;
import Batch.BatchStdPayDAO;
import Batch.BatchStdPay;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author shoto
 */
public class Payment extends javax.swing.JFrame {

    /**
     * Creates new form Payment
     */
    public Payment() {
        initComponents();
         Image ic=new ImageIcon(this.getClass().getResource("/jpro.jpg")).getImage();
        this.setIconImage(ic);
    }

//    public void loadDataintoPaymentTable(ArrayList<PayData> PayList){
//        
//        DefaultTableModel dtm=(DefaultTableModel) jtPaymentInfo.getModel();
//        dtm.setRowCount(0);
//        
//        for(PayData pd :PayList){
//            Vector v1=new Vector();
//            v1.add(pd);
////            v.add(std.getStd_no());
//            v1.add(pd.getBatch_name());
//            v1.add(pd.getCourse_name());
//            v1.add(pd.getStart_date());
//            v1.add(pd.getDesc());
//      
//            dtm.addRow(v1);
//            
//        } 
//      }
    
    public void loadPaymet(){
        BatchStdPayModel bspModel = null;
        try {
                    bspModel = new BatchStdPayModel(new BatchStdPayDAO().getAllStdPayment1());
                } catch (SQLException ex) {
                    Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                jtPaymentInfo.setModel(bspModel);
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Backbtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPaymentInfo = new javax.swing.JTable();
        txtPaySearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnpayadd = new javax.swing.JButton();
        btnview = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JPRO InfoHub Course Management System");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 70));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Backbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hupdate.png"))); // NOI18N
        Backbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackbtnMouseClicked(evt);
            }
        });
        jPanel3.add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, -1, 50));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Payment Information");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, -10, -1, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtPaymentInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bm_Id", "Std_Name", "DOB", "Email", "Ph_No", "Telegram_No", "Amount", "Discount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtPaymentInfo);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1060, 440));

        txtPaySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaySearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaySearchKeyTyped(evt);
            }
        });
        jPanel2.add(txtPaySearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 250, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 40, -1, -1));

        btnpayadd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnpayadd.setForeground(new java.awt.Color(102, 0, 0));
        btnpayadd.setText("Pay Add");
        btnpayadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayaddActionPerformed(evt);
            }
        });
        jPanel2.add(btnpayadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 100, 40));

        btnview.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnview.setForeground(new java.awt.Color(102, 0, 0));
        btnview.setText("View");
        btnview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnviewMouseClicked(evt);
            }
        });
        jPanel2.add(btnview, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 540, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Sync30px-removebg-preview.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 40, 35, 35));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1100, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackbtnMouseClicked
     AdminPanel ad = new AdminPanel();
             ad.setVisible(true);
             ad.loginPane.setVisible(false);
             ad.logoutpane.setVisible(false);
    }//GEN-LAST:event_BackbtnMouseClicked

    private void btnpayaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayaddActionPerformed
        
 
        int id;
        int index = jtPaymentInfo.getSelectedRow();
        if(index < 0)
            JOptionPane.showMessageDialog(null,"Please select any record from table for update");
        else 
        {
            id = (int) jtPaymentInfo.getValueAt(index, 0);
            PaymentSlip pslip = new PaymentSlip();
        pslip.setVisible(true);
            BatchStdPayDAO bspDAO = new BatchStdPayDAO();
            try {
               
                BatchStdPay pay = bspDAO.returnAllDataToTextField(id);
                pslip.setVisible(true);
                pslip.txtBmId.setText(String.valueOf(pay.getBm_id()));
                pslip.Sname.setText(pay.getName());
                pslip.txtEmail.setText(pay.getEmail());
                pslip.Ph_no.setText(pay.getPhno());
                pslip.dcSlipDate.setDate(null);
                pslip.txtAmt.setText(pay.getAmount());
                pslip.txtDisc.setText(pay.getDiscount());
                pslip.cbPmethod.setSelectedItem(null);
                pslip.accname.setText(null);
                pslip.paydesc.setText(null);
                pslip.Payremark.setText(null);
            } catch (SQLException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
          
    }//GEN-LAST:event_btnpayaddActionPerformed

    private void txtPaySearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaySearchKeyTyped
      
    }//GEN-LAST:event_txtPaySearchKeyTyped

    private void btnviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewMouseClicked
        int bmid;
         
        int index = jtPaymentInfo.getSelectedRow();
        if(index < 0)
            JOptionPane.showMessageDialog(null,"Please select any record from table for View");
        else 
        {
            bmid = (int) jtPaymentInfo.getValueAt(index, 0);
            PaymentSlip pslip = new PaymentSlip();
            pslip.setVisible(true);
            pslip.dcSlipDate.setVisible(false);
            pslip.txtDate.setVisible(true);
            BatchStdPayDAO bspDAO = new BatchStdPayDAO();
            try {
               
                BatchStdPay pay = bspDAO.returnAllDataToTextField(bmid);
                PaymentDAO pd =new PaymentDAO();
                PayData payData = pd.getPayment(bmid);
//                System.out.println(payData);
                pslip.setVisible(true);
                pslip.txtBmId.setText(String.valueOf(pay.getBm_id()));
                pslip.Sname.setText(pay.getName());
                pslip.txtEmail.setText(pay.getEmail());
                pslip.Ph_no.setText(pay.getPhno());
                pslip.txtDate.setText(payData.getPayDate().toString());
                pslip.txtAmt.setText(pay.getAmount());
                pslip.txtDisc.setText(pay.getDiscount());
                pslip.cbPmethod.setSelectedItem(payData.getPaymethod());
                pslip.accname.setText(payData.getPersonInfo());
                pslip.paydesc.setText(payData.getDesc());
                pslip.Payremark.setText(payData.getRemark());
            } catch (SQLException ex) {
                Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }//GEN-LAST:event_btnviewMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
     
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtPaySearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaySearchKeyReleased
          
         AbstractTableModel model = (AbstractTableModel)jtPaymentInfo.getModel();
        TableRowSorter<AbstractTableModel>tr= new TableRowSorter<AbstractTableModel>(model);
        jtPaymentInfo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtPaySearch.getText()));
        loadPaymet();
        

    }//GEN-LAST:event_txtPaySearchKeyReleased

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backbtn;
    private javax.swing.JButton btnpayadd;
    private javax.swing.JButton btnview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtPaymentInfo;
    private javax.swing.JTextField txtPaySearch;
    // End of variables declaration//GEN-END:variables
}
