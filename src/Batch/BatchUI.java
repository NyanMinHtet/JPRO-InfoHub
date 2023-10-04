/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Batch;

import AdminLogin.AdminPanel;
import Payment.PaymentSlip;
import Payment.PaymentDAO;
import Payment.PayData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Subject.SubjectDAO;
import Teacher.TeacherDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.Statement;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import Teacher.Teacher_Class;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import ITStudent.Student;
import ITStudent.StudentDAO;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class BatchUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private Connection conn;
    
    public BatchUI() {
        initComponents();
         Image ic=new ImageIcon(this.getClass().getResource("/jpro.jpg")).getImage();
        this.setIconImage(ic);
      
    }

//    BatchPayModel payModel = new BatchPayModel(new MemberDAO().getAllBatchMember(0),new StudentDAO().getAllStudent(0),new PaymentDAO().getAllPayment(0));
    public void getCourseNameAdd(){
        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
            String query = "SELECT Course_name FROM course";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Step 9: Use a loop to iterate over the ResultSet and add each item to the combo box
            while (resultSet.next()) {
                String item = resultSet.getString("Course_name");
                txtCname.addItem(item);
            }

            // Step 10: Close the database connection
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
   
    public void getCourseNameUpdate(){
        try {

           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
            String query = "SELECT Course_name FROM course";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Step 9: Use a loop to iterate over the ResultSet and add each item to the combo box
            while (resultSet.next()) {
                String item = resultSet.getString("Course_name");
                cboNameU.addItem(item);
            }

            // Step 10: Close the database connection
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    
    public void getSubjectNameAdd() {
        try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
        String query = "select subject_Name from subject";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            String sub = rs.getString("subject_Name");
            cboSubAdd.addItem(sub);
            
        }
        
        conn.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
    
    public void getSubjectNameUp() {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
        String query = "select subject_Name from subject";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            String sub = rs.getString("subject_Name");
            cboSUBU.addItem(sub);
            
        }
        
        conn.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
   
    public void loadDataintoStdTable1 (ArrayList<Student> listStd){
        
        DefaultTableModel dtm=(DefaultTableModel) jtableExistStd.getModel();
        dtm.setRowCount(0);
        
        for(Student std :listStd){
            Vector v=new Vector();
            v.add(std.getStd_id());
//            v.add(std.getStd_no());
            v.add(std.getName());
            v.add(std.getDob());
            v.add(std.getEmail());
            v.add(std.getPhno());
            v.add(std.getGender());
            v.add(std.getReligion());
            v.add(std.getNrc());
            v.add(std.getNation());
            v.add(std.getTele_no());
            v.add(std.getPhoto());
            
            dtm.addRow(v);
            
        } 
      }
     
      public void loadTableStd1() throws SQLException{
            
            BatchDAO bdao = new BatchDAO();
            ArrayList listStd=bdao.loadDataStudent();
            loadDataintoStdTable1(listStd);
             
        }
      
       public void loadDataintoStdTable2 (ArrayList<Student> listStd){
        
        DefaultTableModel dtm=(DefaultTableModel) jTstdExistU.getModel();
        dtm.setRowCount(0);
        
        for(Student std :listStd){
            Vector v=new Vector();
            v.add(std.getStd_id());
//            v.add(std.getStd_no());
            v.add(std.getName());
            v.add(std.getDob());
            v.add(std.getEmail());
            v.add(std.getPhno());
            v.add(std.getGender());
            v.add(std.getReligion());
            v.add(std.getNrc());
            v.add(std.getNation());
            v.add(std.getTele_no());
            v.add(std.getPhoto());
            
            dtm.addRow(v);
            
        } 
      }
       
       public void loadTableStd2() throws SQLException{
            
            BatchDAO bdao = new BatchDAO();
            ArrayList listStd=bdao.loadDataStudent();
            loadDataintoStdTable2(listStd);
             
        }
      
      
       public void loadDataintoBatchTable(ArrayList<Batch> listBatch){
        
        DefaultTableModel dtm=(DefaultTableModel) jtBatchInfo.getModel();
        dtm.setRowCount(0);
        
        for(Batch bt :listBatch){
            Vector v1=new Vector();
            v1.add(bt.getBatch_id());
//            v.add(std.getStd_no());
            v1.add(bt.getBatch_name());
            v1.add(bt.getCourse_name());
            v1.add(bt.getStart_date());
            v1.add(bt.getDesc());
      
            dtm.addRow(v1);
            
        } 
      }
       
       public void loadTableBatch() throws SQLException{
            
            BatchDAO bdao = new BatchDAO();
            ArrayList listBatch=bdao.loadBatchData();
            loadDataintoBatchTable(listBatch);
             
        }
       

        
         
        public void getBatchName1() {
            try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
            String query = "SELECT Batch_Name FROM batch";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
             while (resultSet.next()) {
                String item = resultSet.getString("Batch_Name");
                cbBatchName2.addItem(item);
            }
             
             conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
//        public void getBatchName2() {
//            try{
//          
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","ilovepyae");
//            String query = "SELECT Batch_Name FROM batch";
//            PreparedStatement statement = conn.prepareStatement(query);
//            ResultSet resultSet = statement.executeQuery();
//            
//             while (resultSet.next()) {
//                String item = resultSet.getString("Batch_Name");
//                cbBatchName1.addItem(item);
//            }
//             
//             conn.close();
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//        }
        
        public int getBatchMemberID() throws SQLException{
         
            int id=0;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
            String maxId = "SELECT MAX(Bm_id) FROM Batch_member";
            
            PreparedStatement statement = conn.prepareStatement(maxId);
            ResultSet rs = statement.executeQuery();
            
            
            while (rs.next()) {
                id = rs.getInt(1);
                
            }
             return id;
        }
        
        public int getBatchID() throws SQLException{
           
            int bid=0;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
            String maxId = "SELECT MAX(Batch_id) FROM Batch";
            
            PreparedStatement statement = conn.prepareStatement(maxId);
            ResultSet rs = statement.executeQuery();
            
             
            while (rs.next()) {
                bid = rs.getInt(1);
                
            }
             return bid;
        }
        
      
        public void loadDataintoPaymentTable (ArrayList<PayData> listPay){
            DefaultTableModel dtm=(DefaultTableModel) jTstdV.getModel();
            dtm.setRowCount(0);
            
            for(PayData pay :listPay){
            Vector v=new Vector();
            v.add(pay.getPayID());
            v.add(pay.getbmID());
            v.add(pay.getPayDate());
            v.add(pay.getAmount());
            v.add(pay.getDiscount());
            v.add(pay.getPaymethod());
            v.add(pay.getPersonInfo());
            v.add(pay.getDesc());
            v.add(pay.getRemark());
            
            dtm.addRow(v);
            
        } 
    }
        
        public void loadTablePayment() throws SQLException{
            
            PaymentDAO pdao = new PaymentDAO();
            ArrayList PayList=pdao.loadPaymentData();
            loadDataintoPaymentTable(PayList);
             
        }
        
        public void loadDataintoTeacherTableA(ArrayList<Teacher_Class> teacherList){
        
        DefaultTableModel dtm=(DefaultTableModel) jTableExistTechA.getModel();
        dtm.setRowCount(0);
        
        for(Teacher_Class t :teacherList){
            Vector v1=new Vector();
            v1.add(t.getTid());
            v1.add(t.getName());
            v1.add(t.getDoB());
            v1.add(t.getPhno());
            v1.add(t.getEduback());
      
            dtm.addRow(v1);    
        } 
      }
        
         public void loadDataintoTeacherTableU(ArrayList<Teacher_Class> teacherList){
        
        DefaultTableModel dtm=(DefaultTableModel) jTableExistTechU.getModel();
        dtm.setRowCount(0);
        
        for(Teacher_Class t :teacherList){
            Vector v1=new Vector();
            v1.add(t.getTid());
            v1.add(t.getName());
            v1.add(t.getDoB());
            v1.add(t.getPhno());
            v1.add(t.getEduback());
      
            dtm.addRow(v1);    
        } 
      }
          
          public void loadTableTeacherA() throws SQLException{
            
            TeacherDAO tdao = new TeacherDAO();
            ArrayList teacherList = tdao.loadTeacherData();
           loadDataintoTeacherTableA( teacherList);
             
        }
          
          public void loadTableTeacherU() throws SQLException{
            
            TeacherDAO tdao = new TeacherDAO();
            ArrayList teacherList = tdao.loadTeacherData();
            loadDataintoTeacherTableU( teacherList);
             
        }
          
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Batch_Add = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnCreateA1 = new javax.swing.JButton();
        btnChangeTechA = new javax.swing.JButton();
        btnChangeStdA = new javax.swing.JButton();
        btnRestd = new javax.swing.JButton();
        jscrolStdB = new javax.swing.JScrollPane();
        JTstdBatchA = new javax.swing.JTable();
        jscrolTechB = new javax.swing.JScrollPane();
        jTableBatchTechA = new javax.swing.JTable();
        btnAddstd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnAddTech = new javax.swing.JButton();
        btnCancelA = new javax.swing.JButton();
        btnReTech = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jscrolStdE = new javax.swing.JScrollPane();
        jtableExistStd = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        labBackA = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtCname = new javax.swing.JComboBox<>();
        txtBname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        dcBdate = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jscrolTechE = new javax.swing.JScrollPane();
        jTableExistTechA = new javax.swing.JTable();
        cboSubAdd = new javax.swing.JComboBox<>();
        txtTeSearchA = new javax.swing.JTextField();
        txtStdSearchA = new javax.swing.JTextField();
        Batch_View = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btPayment = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTstdV = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTteacherV = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        labBackV = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblHomeInfo = new javax.swing.JLabel();
        labSearchstdV = new javax.swing.JLabel();
        cbBatchName2 = new javax.swing.JComboBox<>();
        cbBatchName1 = new javax.swing.JComboBox<>();
        Batch_Info = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jtable = new javax.swing.JScrollPane();
        jtBatchInfo = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnAddMain = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labBack = new javax.swing.JLabel();
        labSearchBatch = new javax.swing.JLabel();
        txtInfoSearch = new javax.swing.JTextField();
        btnrefresh = new javax.swing.JLabel();
        Batch_Update = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnChangeTechU = new javax.swing.JButton();
        btnChangeStdU = new javax.swing.JButton();
        btnUpdateU = new javax.swing.JButton();
        btnRestdU = new javax.swing.JButton();
        jscrolStdBU = new javax.swing.JScrollPane();
        jTstdBatchU = new javax.swing.JTable();
        btnAddstdU = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnAddTechU = new javax.swing.JButton();
        btnCancelU = new javax.swing.JButton();
        btnReTechU = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jscrolStdEU = new javax.swing.JScrollPane();
        jTstdExistU = new javax.swing.JTable();
        jscrolTechEU = new javax.swing.JScrollPane();
        jTableExistTechU = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        labBackU = new javax.swing.JLabel();
        lblHomeU = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        cboNameU = new javax.swing.JComboBox<>();
        txtNameU = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAU = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        dcBtStartDate = new com.toedter.calendar.JDateChooser();
        jscrolTechU = new javax.swing.JScrollPane();
        jTableBatchTechU = new javax.swing.JTable();
        cboSUBU = new javax.swing.JComboBox<>();
        txStdSearch = new javax.swing.JTextField();
        txtTeacherSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JPRO InfoHub Course Management System");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Batch_Add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 3));
        jPanel7.setMinimumSize(new java.awt.Dimension(1100, 690));
        jPanel7.setPreferredSize(new java.awt.Dimension(1100, 690));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreateA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreateA1.setText("CREATE");
        btnCreateA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateA1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnCreateA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 120, 40));

        btnChangeTechA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangeTechA.setText("Teacher");
        btnChangeTechA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeTechAActionPerformed(evt);
            }
        });
        jPanel7.add(btnChangeTechA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 120, 40));

        btnChangeStdA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangeStdA.setText("Student");
        btnChangeStdA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeStdAActionPerformed(evt);
            }
        });
        jPanel7.add(btnChangeStdA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 120, 40));

        btnRestd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRestd.setText("REMOVE");
        btnRestd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestdActionPerformed(evt);
            }
        });
        jPanel7.add(btnRestd, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 90, 40));

        JTstdBatchA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Std_ID", "Std_Name", "DOB", "Email", "Ph_NO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jscrolStdB.setViewportView(JTstdBatchA);

        jPanel7.add(jscrolStdB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 690, 270));

        jTableBatchTechA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher_ID", "Teacher_Name", "DOB", "Ph_NO", "Edu_Back"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jscrolTechB.setViewportView(jTableBatchTechA);

        jPanel7.add(jscrolTechB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 690, 270));

        btnAddstd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddstd.setText("ADD");
        btnAddstd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddstdActionPerformed(evt);
            }
        });
        jPanel7.add(btnAddstd, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, 90, 40));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("Existing ");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 120, 30));

        btnAddTech.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddTech.setText("ADD");
        btnAddTech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTechActionPerformed(evt);
            }
        });
        jPanel7.add(btnAddTech, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, 90, 40));

        btnCancelA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelA.setText("CANCEL");
        btnCancelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelAActionPerformed(evt);
            }
        });
        jPanel7.add(btnCancelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 120, 40));

        btnReTech.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReTech.setText("REMOVE");
        btnReTech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReTechActionPerformed(evt);
            }
        });
        jPanel7.add(btnReTech, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 90, 40));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Batch");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 150, 30));

        jtableExistStd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Std_ID", "Std_Name", "DOB", "Email", "Ph_NO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jscrolStdE.setViewportView(jtableExistStd);

        jPanel7.add(jscrolStdE, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 700, 250));

        jPanel8.setBackground(new java.awt.Color(153, 0, 0));
        jPanel8.setMinimumSize(new java.awt.Dimension(1100, 65));
        jPanel8.setPreferredSize(new java.awt.Dimension(1200, 65));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(204, 0, 0));
        jLabel19.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Batch Adding");
        jLabel19.setVerifyInputWhenFocusTarget(false);
        jLabel19.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, -10, 340, -1));

        labBackA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        labBackA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBackAMouseClicked(evt);
            }
        });
        jPanel9.add(labBackA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hupdate.png"))); // NOI18N
        lblHome.setText("jLabel2");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        jPanel9.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 60, 50));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, 50));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 0, 0));
        jLabel22.setText("Enter Batch Data");
        jPanel11.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 130, 40));

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 130, -1));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 3));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnameActionPerformed(evt);
            }
        });
        jPanel10.add(txtCname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 190, 30));
        getCourseNameAdd();

        txtBname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBnameActionPerformed(evt);
            }
        });
        jPanel10.add(txtBname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 190, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Couse_Name  ");
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Start_Date   ");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 30));

        txtDesc.setColumns(20);
        txtDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDesc.setRows(5);
        jScrollPane1.setViewportView(txtDesc);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 200, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Description  ");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 100, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 0, 0));
        jLabel21.setText("Batch_Name  ");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));
        jPanel10.add(dcBdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 192, 190, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("*");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 30, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("*");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 30, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("*");
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 30, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("*");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 30, 30));

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 410));

        jTableExistTechA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Teacher_ID", "Teacher_Name", "DOB", "Ph_NO", "Edu_Back"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jscrolTechE.setViewportView(jTableExistTechA);

        jPanel7.add(jscrolTechE, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 700, 250));

        cboSubAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubAddActionPerformed(evt);
            }
        });
        jPanel7.add(cboSubAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 140, -1));
        getSubjectNameAdd();

        txtTeSearchA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTeSearchAKeyReleased(evt);
            }
        });
        jPanel7.add(txtTeSearchA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 130, -1));

        txtStdSearchA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStdSearchAKeyReleased(evt);
            }
        });
        jPanel7.add(txtStdSearchA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 130, -1));

        Batch_Add.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 690));

        getContentPane().add(Batch_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 690));

        Batch_View.setMinimumSize(new java.awt.Dimension(1100, 690));
        Batch_View.setPreferredSize(new java.awt.Dimension(1100, 690));
        Batch_View.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPayment.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btPayment.setForeground(new java.awt.Color(153, 0, 0));
        btPayment.setText("Payment");
        btPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPaymentMouseClicked(evt);
            }
        });
        btPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPaymentActionPerformed(evt);
            }
        });
        jPanel4.add(btPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 340, 100, 30));

        jLabel11.setBackground(new java.awt.Color(102, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setText("Batch's Student_Info");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 112, 170, 30));

        jTstdV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Bm_Id", "Std_Name", "DOB", "Email", "Ph_No", "Telegram_No", "Amount", "Discount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTstdV);

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1000, 190));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText("Batch's Teacher_Info");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 170, -1));

        jTteacherV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher_ID", "Teacher_Name", "DOB", "Ph_No", "Edu_Back"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTteacherV);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 1000, 190));

        jPanel5.setBackground(new java.awt.Color(153, 0, 0));
        jPanel5.setMinimumSize(new java.awt.Dimension(1100, 65));
        jPanel5.setPreferredSize(new java.awt.Dimension(1200, 65));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(204, 0, 0));
        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Batch's View");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setVerifyInputWhenFocusTarget(false);
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 340, 50));

        labBackV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        labBackV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBackVMouseClicked(evt);
            }
        });
        jPanel6.add(labBackV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, -1, -1));

        lblHomeInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hupdate.png"))); // NOI18N
        lblHomeInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeInfoMouseClicked(evt);
            }
        });
        jPanel6.add(lblHomeInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 50, 50));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, 50));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        labSearchstdV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/searchp.png"))); // NOI18N
        labSearchstdV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labSearchstdVMouseClicked(evt);
            }
        });
        jPanel4.add(labSearchstdV, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 40, 30));

        cbBatchName2.setModel(new javax.swing.DefaultComboBoxModel<>());
        cbBatchName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBatchName2ActionPerformed(evt);
            }
        });
        jPanel4.add(cbBatchName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 160, 30));
        getBatchName1();

        cbBatchName1.setModel(new javax.swing.DefaultComboBoxModel<>());
        cbBatchName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBatchName1ActionPerformed(evt);
            }
        });
        jPanel4.add(cbBatchName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 160, 30));
        //getBatchName2();

        Batch_View.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 690));

        getContentPane().add(Batch_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 690));

        Batch_Info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 3));
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 690));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtBatchInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Batch_ID", "Batch_Name", "Couse_Name", "Start_Date", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtable.setViewportView(jtBatchInfo);

        jPanel1.add(jtable, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 1000, 440));

        btnView.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnView.setText("VIEW");
        btnView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewMouseClicked(evt);
            }
        });
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel1.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, 120, 40));

        btnAddMain.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAddMain.setText("ADD");
        btnAddMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMainMouseClicked(evt);
            }
        });
        btnAddMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMainActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 620, 120, 40));

        btnUpdate1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnUpdate1.setText("UPDATE");
        btnUpdate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdate1MouseClicked(evt);
            }
        });
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 620, 120, 40));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setMinimumSize(new java.awt.Dimension(1100, 65));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 65));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 0, 0));
        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Batch's Info");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 340, 50));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hupdate.png"))); // NOI18N
        labBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBackMouseClicked(evt);
            }
        });
        jPanel3.add(labBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 50, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        labSearchBatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/searchp.png"))); // NOI18N
        jPanel1.add(labSearchBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 40, 30));

        txtInfoSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInfoSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtInfoSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 210, 30));

        btnrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Sync30px-removebg-preview.png"))); // NOI18N
        btnrefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrefreshMouseClicked(evt);
            }
        });
        jPanel1.add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, 35, 35));

        Batch_Info.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 690));

        getContentPane().add(Batch_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 690));
        Batch_Add.setVisible(false);
        Batch_Update.setVisible(false);
        Batch_View.setVisible(false);

        Batch_Update.setMinimumSize(new java.awt.Dimension(1100, 690));
        Batch_Update.setPreferredSize(new java.awt.Dimension(1100, 690));
        Batch_Update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 3));
        jPanel12.setMinimumSize(new java.awt.Dimension(1100, 690));
        jPanel12.setPreferredSize(new java.awt.Dimension(1100, 690));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChangeTechU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangeTechU.setText("Teacher");
        btnChangeTechU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeTechUActionPerformed(evt);
            }
        });
        jPanel12.add(btnChangeTechU, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 120, 40));

        btnChangeStdU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangeStdU.setText("Student");
        btnChangeStdU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeStdUActionPerformed(evt);
            }
        });
        jPanel12.add(btnChangeStdU, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 120, 40));

        btnUpdateU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateU.setText("Update");
        btnUpdateU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUActionPerformed(evt);
            }
        });
        jPanel12.add(btnUpdateU, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 120, 40));

        btnRestdU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRestdU.setText("REMOVE");
        btnRestdU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestdUActionPerformed(evt);
            }
        });
        jPanel12.add(btnRestdU, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 90, 40));

        jTstdBatchU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Std_ID", "Std_Name", "DOB", "Email", "Ph_NO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jscrolStdBU.setViewportView(jTstdBatchU);

        jPanel12.add(jscrolStdBU, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 700, 260));

        btnAddstdU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddstdU.setText("ADD");
        btnAddstdU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddstdUActionPerformed(evt);
            }
        });
        jPanel12.add(btnAddstdU, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, 90, 40));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Existing ");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 120, 30));

        btnAddTechU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddTechU.setText("ADD");
        btnAddTechU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTechUActionPerformed(evt);
            }
        });
        jPanel12.add(btnAddTechU, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, 90, 40));

        btnCancelU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelU.setText("CANCLE");
        btnCancelU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUActionPerformed(evt);
            }
        });
        jPanel12.add(btnCancelU, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 120, 40));

        btnReTechU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReTechU.setText("REMOVE");
        btnReTechU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReTechUActionPerformed(evt);
            }
        });
        jPanel12.add(btnReTechU, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 90, 40));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Batch");
        jPanel12.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 150, 30));

        jTstdExistU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Std_ID", "Std_Name", "DOB", "Email", "Ph_NO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jscrolStdEU.setViewportView(jTstdExistU);

        jPanel12.add(jscrolStdEU, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 700, 250));

        jTableExistTechU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher_ID", "Teacher_Name", "DOB", "Ph_NO", "Edu_Back"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jscrolTechEU.setViewportView(jTableExistTechU);

        jPanel12.add(jscrolTechEU, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 700, 250));

        jPanel13.setBackground(new java.awt.Color(153, 0, 0));
        jPanel13.setMinimumSize(new java.awt.Dimension(1100, 65));
        jPanel13.setPreferredSize(new java.awt.Dimension(1200, 65));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(204, 0, 0));
        jLabel20.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Batch Updating");
        jLabel20.setVerifyInputWhenFocusTarget(false);
        jLabel20.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel14.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, -2, 340, 50));

        labBackU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        labBackU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBackUMouseClicked(evt);
            }
        });
        jPanel14.add(labBackU, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        lblHomeU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hupdate.png"))); // NOI18N
        lblHomeU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeUMouseClicked(evt);
            }
        });
        jPanel14.add(lblHomeU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 50, 50));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, 50));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 0, 0));
        jLabel23.setText("Enter Batch Data");
        jPanel15.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 40));

        jPanel12.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 170, -1));

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 3));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboNameU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNameUActionPerformed(evt);
            }
        });
        jPanel16.add(cboNameU, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 190, 30));
        getCourseNameUpdate();

        txtNameU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNameU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameUActionPerformed(evt);
            }
        });
        jPanel16.add(txtNameU, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 190, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 0));
        jLabel13.setText("Couse_Name  ");
        jPanel16.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 0, 0));
        jLabel14.setText("Start_Date   ");
        jPanel16.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 30));

        txtAU.setColumns(20);
        txtAU.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAU.setRows(5);
        jScrollPane2.setViewportView(txtAU);

        jPanel16.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 200, 80));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 0, 0));
        jLabel15.setText("Description  ");
        jPanel16.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 100, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 0, 0));
        jLabel24.setText("Batch_Name  ");
        jPanel16.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));
        jPanel16.add(dcBtStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 180, 30));

        jPanel12.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 410));

        jTableBatchTechU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher_ID", "Teacher_Name", "DOB", "Ph_NO", "Edu_Back"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jscrolTechU.setViewportView(jTableBatchTechU);

        jPanel12.add(jscrolTechU, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 700, 250));

        cboSUBU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSUBUActionPerformed(evt);
            }
        });
        jPanel12.add(cboSUBU, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 140, -1));
        getSubjectNameUp();

        txStdSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txStdSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txStdSearchKeyReleased(evt);
            }
        });
        jPanel12.add(txStdSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 72, 160, 30));

        txtTeacherSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTeacherSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTeacherSearchKeyReleased(evt);
            }
        });
        jPanel12.add(txtTeacherSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 72, 160, 30));

        Batch_Update.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1100, 680));

        getContentPane().add(Batch_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewMouseClicked
        Batch_Add.setVisible(false);
        Batch_View.setVisible(true);
        Batch_Info.setVisible(false);
        Batch_Update.setVisible(false);

    }//GEN-LAST:event_btnViewMouseClicked

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        Batch_Add.setVisible(false);
        Batch_View.setVisible(true);
        Batch_Info.setVisible(false);
        Batch_Update.setVisible(false);
        cbBatchName1.setVisible(false);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnAddMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMainMouseClicked
        // TODO add your handling code here:
        Batch_Add.setVisible(true);
        Batch_View.setVisible(false);
        Batch_Info.setVisible(false);
        Batch_Update.setVisible(false);
        
        try {
            loadTableStd1();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            loadTableTeacherA();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddMainMouseClicked

    private void btnAddMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMainActionPerformed
        Batch_Add.setVisible(true);
        Batch_View.setVisible(false);
        Batch_Info.setVisible(false);
        Batch_Update.setVisible(false);
        
        try {
            loadTableStd1();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            loadTableTeacherU();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_btnAddMainActionPerformed

    private void btnUpdate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdate1MouseClicked

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        Batch_Add.setVisible(false);
        Batch_View.setVisible(false);
        Batch_Info.setVisible(false);
        Batch_Update.setVisible(true);
        cboSUBU.setVisible(false);
        cboSubAdd.setVisible(false);
        try {
            loadTableStd2();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        int id = 0;
        int index = jtBatchInfo.getSelectedRow();
        if(index < 0)
            JOptionPane.showMessageDialog(null,"Please select any record from table for update");
        else 
        {
            id = (int) jtBatchInfo.getValueAt(index, 0);
            BatchDAO bdao = new BatchDAO();
            try {
               
                Batch batch = bdao.returnAllDataToTextField(id);
                Batch_Update.setVisible(true);
                txtNameU.setText(batch.getBatch_name());
                cboNameU.setSelectedItem(batch.getCourse_name());
                dcBtStartDate.setDate(batch.getStart_date());
                txtAU.setText(batch.getDesc());
            } catch (SQLException ex) {
                Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void labBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBackMouseClicked
        dispose();
        AdminPanel ad = new AdminPanel();
             ad.setVisible(true);
             ad.loginPane.setVisible(false);
             ad.logoutpane.setVisible(false);
    }//GEN-LAST:event_labBackMouseClicked

    private void btPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPaymentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btPaymentMouseClicked

    private void btPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPaymentActionPerformed
       PaymentSlip pslip = new PaymentSlip();
       pslip.setVisible(true);
 
        int id;
        int index = jTstdV.getSelectedRow();
        if(index < 0)
            JOptionPane.showMessageDialog(null,"Please select any record from table for update");
        else 
        {
            id = (int) jTstdV.getValueAt(index, 0);
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
                pslip.accname.setText(pay.getAmount());
//                dcBtStartDate.setDate(batch.getStart_date());
                pslip.txtDisc.setText(pay.getDiscount());
                pslip.Payremark.setText(null);
//                txtAU.setText(null);
            } catch (SQLException ex) {
                Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
      
    }//GEN-LAST:event_btPaymentActionPerformed

    private void labBackVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBackVMouseClicked
        Batch_Add.setVisible(false);
        Batch_View.setVisible(false);
        Batch_Info.setVisible(true);
        Batch_Update.setVisible(false);

    }//GEN-LAST:event_labBackVMouseClicked

    private void btnChangeStdAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeStdAActionPerformed
        jscrolTechE.setVisible(false);
        jscrolTechB.setVisible(false);
        jscrolStdE.setVisible(true);
        jscrolStdB.setVisible(true);
        btnAddTech.setVisible(false);
        btnReTech.setVisible(false);
        btnAddstd.setVisible(true);
        btnRestd.setVisible(true);
        btnChangeStdA.setVisible(false);
        btnChangeTechA.setVisible(true);
        cboSubAdd.setVisible(false);
         txtTeSearchA.setVisible(false);
         txtStdSearchA.setVisible(true);
        
    }//GEN-LAST:event_btnChangeStdAActionPerformed

    private void btnCreateA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateA1ActionPerformed
        boolean ch = false;
        
        try {
            ch = inputCheck();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ch == true){
        String bname = txtBname.getText();
        String cname = txtCname.getSelectedItem().toString();
        Date start_date= new Date(dcBdate.getDate().getTime());
        String desc = txtDesc.getText();
        
       
        Date join_date = new Date(dcBdate.getDate().getTime());
        int batchID = 0;
        int memId = 0;
        
        Batch b = new Batch(0,bname,cname,start_date,desc);
        try {
            int choice = JOptionPane.showConfirmDialog(null, "Do you really want to save your data","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
            if(choice==JOptionPane.YES_OPTION){
                new BatchDAO().addBatch(b);
                JOptionPane.showMessageDialog(null, "Successfully save to Batch");
                batchID = getBatchID();
            }
	} catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1.toString(),"DB Error",JOptionPane.ERROR_MESSAGE);
	}
            try {
                loadTableBatch();
            } catch (SQLException ex) {
                Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        int sindex ;
        int tindex ;
             sindex = JTstdBatchA.getSelectedRow()+1;
             tindex =  jTableBatchTechA.getSelectedRow()+1;
//             System.out.println(sindex);
//             System.out.println(tindex);

        
        if(sindex < 0){
            JOptionPane.showMessageDialog(null, "Please select one record from table for adding batch member");}
        if(sindex>0){
        DefaultTableModel modelInfo = (DefaultTableModel) JTstdBatchA.getModel();
        int selectRow = JTstdBatchA.getSelectedRow();
        int sId = Integer.parseInt(JTstdBatchA.getValueAt(selectRow, 0).toString());
        if(new MemberDAO().isStdIdExist(sId)){
                JOptionPane.showMessageDialog(this, "This Student Id has already existed");
        }
        else
        { BatchMember bm = new BatchMember(0,batchID,sId,join_date);
          try {
            int choice = JOptionPane.showConfirmDialog(null, "Do you really want to save your member","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
            {if(choice==JOptionPane.YES_OPTION)
                new MemberDAO().addBatchMember(bm);
            JOptionPane.showMessageDialog(null, "Successfully save to Batch Member");
            memId = getBatchMemberID();
            }
            PayData data = new PayData(0,memId,null,null,null,null,null,null,null);
            new PaymentDAO().addPaymentInfo(data);
	} catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1.toString(),"DB Error",JOptionPane.ERROR_MESSAGE);
	}
        }}
        
        else if(tindex>0){
            DefaultTableModel modelt = (DefaultTableModel) jTableBatchTechA.getModel();
            int[] selectRows = jTableBatchTechA.getSelectedRows();
            for(int i=0;i<selectRows.length;i++){
            int tId = Integer.parseInt(jTableBatchTechA.getValueAt(i,0).toString());
            int subID=0;
                try {
                    subID = new SubjectDAO().getSubjectId(cboSubAdd.getSelectedItem().toString());
                } catch (SQLException ex) {
                    Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            BatchTeacher bt = new BatchTeacher(0,batchID,tId,subID);
            try {
            int choice = JOptionPane.showConfirmDialog(null, "Do you really want to save your teacher","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
            {if(choice==JOptionPane.YES_OPTION)
                new BatchTeacherDAO().addBatchTeacher(bt);
            JOptionPane.showMessageDialog(null, "Successfully save to Batch Teacher");
            }
        }
         catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1.toString(),"DB Error",JOptionPane.ERROR_MESSAGE);
	}
        }
       }
        }
    }//GEN-LAST:event_btnCreateA1ActionPerformed

    private void btnRestdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestdActionPerformed
        String data="Std_ID : "+JTstdBatchA.getValueAt(JTstdBatchA.getSelectedRow(), 0).toString();
	data+="\nStd_Name : "+JTstdBatchA.getValueAt(JTstdBatchA.getSelectedRow(), 1).toString();
        data+="\nDOB : "+JTstdBatchA.getValueAt(JTstdBatchA.getSelectedRow(), 2).toString();
	data+="\nEmail : "+JTstdBatchA.getValueAt(JTstdBatchA.getSelectedRow(), 3).toString();
	data+="\nPh_NO : "+JTstdBatchA.getValueAt(JTstdBatchA.getSelectedRow(), 4).toString();
        data+="\n Do you want to really delete above data";
	int ch=JOptionPane.showConfirmDialog(null, data, "Confirm Message",JOptionPane.WARNING_MESSAGE);
            if(ch==JOptionPane.YES_OPTION){
            DefaultTableModel model1 =(DefaultTableModel) JTstdBatchA.getModel();
            int[] ind = JTstdBatchA.getSelectedRows();
            Object[] row = new Object[5];
            DefaultTableModel model2 = (DefaultTableModel) jtableExistStd.getModel(); //JTstdBatchA  jtableExistStd
            for(int i =0; i<ind.length;i++){
            row[0] = model1.getValueAt(ind[i], 0);
            row[1] = model1.getValueAt(ind[i], 1);
            row[2] = model1.getValueAt(ind[i], 2);
            row[3] = model1.getValueAt(ind[i], 3);
            row[4] = model1.getValueAt(ind[i], 4);
            model2.addRow(row);
            model1.removeRow(JTstdBatchA.getSelectedRow());
            } 
         }
    }//GEN-LAST:event_btnRestdActionPerformed

    private void btnAddstdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddstdActionPerformed

        DefaultTableModel model1 = (DefaultTableModel) jtableExistStd.getModel();
        int[] indexs = jtableExistStd.getSelectedRows();
        Object[] row = new Object[5];
        DefaultTableModel model2 = (DefaultTableModel) JTstdBatchA.getModel();
        for(int i =0; i<indexs.length; i++){
            row[0] = model1.getValueAt(indexs[i], 0);
            row[1] = model1.getValueAt(indexs[i], 1);
            row[2] = model1.getValueAt(indexs[i], 2);
            row[3] = model1.getValueAt(indexs[i], 3);
            row[4] = model1.getValueAt(indexs[i], 4);
            model2.addRow(row);
            model1.removeRow(indexs[i]);
        }

    }//GEN-LAST:event_btnAddstdActionPerformed

    private void btnChangeTechAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeTechAActionPerformed
        jscrolTechE.setVisible(true);
        jscrolTechB.setVisible(true);
        jscrolStdE.setVisible(false);
        jscrolStdB.setVisible(false);
        btnAddTech.setVisible(true);
        btnReTech.setVisible(true);
        btnAddstd.setVisible(false);
        btnRestd.setVisible(false);
        btnChangeStdA.setVisible(true);
        btnChangeTechA.setVisible(false);
         cboSubAdd.setVisible(true);
         txtTeSearchA.setVisible(true);
         txtStdSearchA.setVisible(false);
         
        try {
            loadTableTeacherA();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_btnChangeTechAActionPerformed

    private void btnAddTechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTechActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) jTableExistTechA.getModel();
        int[] indexs = jTableExistTechA.getSelectedRows();
        Object[] row = new Object[5];
        DefaultTableModel model2 = (DefaultTableModel) jTableBatchTechA.getModel();
        for(int i =0; i<indexs.length; i++){
            row[0] = model1.getValueAt(indexs[i], 0);
            row[1] = model1.getValueAt(indexs[i], 1);
            row[2] = model1.getValueAt(indexs[i], 2);
            row[3] = model1.getValueAt(indexs[i], 3);
            row[4] = model1.getValueAt(indexs[i], 4);
            model2.addRow(row);
            model1.removeRow(indexs[i]);
        }
    }//GEN-LAST:event_btnAddTechActionPerformed

    private void btnCancelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelAActionPerformed
        txtBname.setText("");
        txtCname.setSelectedIndex(0);
        dcBdate.setDate(null);
        txtDesc.setText("");
    }//GEN-LAST:event_btnCancelAActionPerformed

    private void btnReTechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReTechActionPerformed
        String data="Std_ID : "+jTableBatchTechA.getValueAt(jTableBatchTechA.getSelectedRow(), 0).toString();
	data+="\nStd_Name : "+jTableBatchTechA.getValueAt(jTableBatchTechA.getSelectedRow(), 1).toString();
        data+="\nDOB : "+jTableBatchTechA.getValueAt(jTableBatchTechA.getSelectedRow(), 2).toString();
	data+="\nEmail : "+jTableBatchTechA.getValueAt(jTableBatchTechA.getSelectedRow(), 3).toString();
	data+="\nPh_NO : "+jTableBatchTechA.getValueAt(jTableBatchTechA.getSelectedRow(), 4).toString();
        data+="\n Do you want to really delete above data";
	int ch=JOptionPane.showConfirmDialog(null, data, "Confirm Message",JOptionPane.WARNING_MESSAGE);
            if(ch==JOptionPane.YES_OPTION){
            DefaultTableModel model1 =(DefaultTableModel) jTableBatchTechA.getModel();
            int[] ind = jTableBatchTechA.getSelectedRows();
            Object[] row = new Object[5];
            DefaultTableModel model2 = (DefaultTableModel) jTableExistTechA.getModel(); //JTstdBatchA  jtableExistStd
            for(int i =0; i<ind.length;i++){
            row[0] = model1.getValueAt(ind[i], 0);
            row[1] = model1.getValueAt(ind[i], 1);
            row[2] = model1.getValueAt(ind[i], 2);
            row[3] = model1.getValueAt(ind[i], 3);
            row[4] = model1.getValueAt(ind[i], 4);
            model2.addRow(row);
            model1.removeRow(jTableBatchTechA.getSelectedRow());
            } 
         }
    }//GEN-LAST:event_btnReTechActionPerformed

    private void labBackAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBackAMouseClicked
        Batch_Add.setVisible(false);
        Batch_View.setVisible(false);
        Batch_Info.setVisible(true);
        Batch_Update.setVisible(false);

    }//GEN-LAST:event_labBackAMouseClicked

    private void txtCnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnameActionPerformed

    }//GEN-LAST:event_txtCnameActionPerformed

    private void txtBnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBnameActionPerformed

    private void btnChangeStdUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeStdUActionPerformed
       jscrolTechEU.setVisible(false);
        jscrolTechU.setVisible(false);
        jscrolStdEU.setVisible(true);
        jscrolStdBU.setVisible(true);
        btnAddTechU.setVisible(false);
        btnReTechU.setVisible(false);
        btnAddstdU.setVisible(true);
        btnRestdU.setVisible(true);
        btnChangeStdU.setVisible(false);
        btnChangeTechU.setVisible(true);
        cboSUBU.setVisible(false);
        txStdSearch.setVisible(true);
        txtTeacherSearch.setVisible(false);
    }//GEN-LAST:event_btnChangeStdUActionPerformed

    private void btnUpdateUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUActionPerformed
        // TODO add your handling code here:
       
        try {
            loadTableStd2();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            loadTableTeacherU();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        int SelectedRows = jTstdBatchU.getSelectedRow()+1;
        
        int tSelectRow = jTableBatchTechU.getSelectedRow()+1;
        
        System.out.println(SelectedRows);
        System.out.println(tSelectRow);
        
        if(SelectedRows> 0){
            
        DefaultTableModel modelInfo = (DefaultTableModel) jtBatchInfo.getModel();
        int selectRow = jtBatchInfo.getSelectedRow();
        int id = Integer.parseInt(modelInfo.getValueAt(selectRow, 0).toString());
        String bname=txtNameU.getText();
        String course_name = cboNameU.getSelectedItem().toString();
        Date da=new Date(dcBtStartDate.getDate().getTime());
        String desc=txtAU.getText();
 
        Batch btu = new Batch(id,bname,course_name,da,desc);
        BatchDAO bdao=new BatchDAO();
        bdao.updateBatch(btu);
//        
        int bId = id;
        DefaultTableModel model = (DefaultTableModel)jTstdBatchU.getModel();
        int sId = Integer.parseInt(model.getValueAt(SelectedRows-1, 0).toString());
            if(new MemberDAO().isStdIdExist(sId)){
                JOptionPane.showMessageDialog(this, "This Student Id has already existed");
            }
//        int sID = Integer.parseInt(modelInfo.getValueAt(SelectedRows, 0).toString());
            else{
                BatchMember bm = new BatchMember(0,bId,sId,da);
   
                int memberID= 0;
         try {
            int choice = JOptionPane.showConfirmDialog(null, "Do you really want to update your Batch member data","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
            if(choice==JOptionPane.YES_OPTION)
                {new MemberDAO().addBatchMember(bm);
            JOptionPane.showMessageDialog(null, "Successfully save to Batch Member");
            memberID = getBatchMemberID();
            }
            if(choice ==JOptionPane.NO_OPTION) {
             System.exit(0);
            }
            
            PayData pData = new PayData(0,memberID,null,null,null,null,null,null,null);
            new PaymentDAO().addPaymentInfo(pData);
	} catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1.toString(),"DB Error",JOptionPane.ERROR_MESSAGE);
	}
        
                }
        }
        
        if(tSelectRow>0){
            
        DefaultTableModel modelInfo = (DefaultTableModel) jtBatchInfo.getModel();
        int selectRow = jtBatchInfo.getSelectedRow();
        int id = Integer.parseInt(jtBatchInfo.getValueAt(selectRow, 0).toString());
        String bname=txtNameU.getText();
        String course_name = cboNameU.getSelectedItem().toString();
        Date da=new Date(dcBtStartDate.getDate().getTime());
        String desc=txtAU.getText();
 
        Batch btu = new Batch(id,bname,course_name,da,desc);
        BatchDAO bdao=new BatchDAO();
        bdao.updateBatch(btu);
        
        int bId = id;
        DefaultTableModel model = (DefaultTableModel)jTableBatchTechU.getModel();
        int tID = Integer.parseInt(jTableBatchTechU.getValueAt(tSelectRow-1, 0).toString());
        int subId = 0;
            try {
                subId = new SubjectDAO().getSubjectId(cboSUBU.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
         if(new BatchTeacherDAO().isTeacherIdExist(tID)){
                JOptionPane.showMessageDialog(this, "This Teacher Id has already existed");
        }
         else{
        BatchTeacher bt = new BatchTeacher(0,bId,tID,subId);
        
         try {
            int choice = JOptionPane.showConfirmDialog(null, "Do you really want to update your Batch teacher data","Confirm Message",JOptionPane.INFORMATION_MESSAGE);
            if(choice==JOptionPane.YES_OPTION){
                new BatchTeacherDAO().addBatchTeacher(bt);
            JOptionPane.showMessageDialog(null, "Successfully save to Teacher");
            
            }
            else if(choice==JOptionPane.NO_OPTION){
                System.exit(0);
            }
         
	}catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1.toString(),"DB Error",JOptionPane.ERROR_MESSAGE);
	}
        
        }
        
        txtNameU.setText("");
        cboNameU.setSelectedItem(null);
        dcBtStartDate.setDate(null);
        txtAU.setText("");
        try {
            loadTableBatch();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }//GEN-LAST:event_btnUpdateUActionPerformed

    private void btnRestdUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestdUActionPerformed
        // TODO add your handling code here:
        String data="Std_ID : "+jTstdBatchU.getValueAt(jTstdBatchU.getSelectedRow(), 0).toString();
	data+="\nStd_Name : "+jTstdBatchU.getValueAt(jTstdBatchU.getSelectedRow(), 1).toString();
        data+="\nDOB : "+jTstdBatchU.getValueAt(jTstdBatchU.getSelectedRow(), 2).toString();
	data+="\nEmail : "+jTstdBatchU.getValueAt(jTstdBatchU.getSelectedRow(), 3).toString();
	data+="\nPh_NO : "+jTstdBatchU.getValueAt(jTstdBatchU.getSelectedRow(), 4).toString();
        data+="\n Do you want to really delete above data";
	int ch=JOptionPane.showConfirmDialog(null, data, "Confirm Message",JOptionPane.WARNING_MESSAGE);
            if(ch==JOptionPane.YES_OPTION){
            DefaultTableModel model1 =(DefaultTableModel) jTstdBatchU.getModel();
            int[] indexs = jTstdBatchU.getSelectedRows();
            Object[] rowU = new Object[5];
            DefaultTableModel model2 = (DefaultTableModel) jTstdExistU.getModel(); //JTstdBatchA  jtableExistStd
            for(int i =0; i<indexs.length;i++){
            rowU[0] = model1.getValueAt(indexs[i], 0);
            rowU[1] = model1.getValueAt(indexs[i], 1);
            rowU[2] = model1.getValueAt(indexs[i], 2);
            rowU[3] = model1.getValueAt(indexs[i], 3);
            rowU[4] = model1.getValueAt(indexs[i], 4);
            model2.addRow(rowU);
            model1.removeRow(jTstdBatchU.getSelectedRow());
            } 
         }
    }//GEN-LAST:event_btnRestdUActionPerformed

    private void btnAddstdUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddstdUActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model1 = (DefaultTableModel) jTstdExistU.getModel();
        int[] indexs = jTstdExistU.getSelectedRows();
        Object[] rowU = new Object[5];
        DefaultTableModel model2 = (DefaultTableModel) jTstdBatchU.getModel();
        for(int i =0; i<indexs.length;i++){
            rowU[0] = model1.getValueAt(indexs[i], 0);
            rowU[1] = model1.getValueAt(indexs[i], 1);
            rowU[2] = model1.getValueAt(indexs[i], 2);
            rowU[3] = model1.getValueAt(indexs[i], 3);
            rowU[4] = model1.getValueAt(indexs[i], 4);
            model2.addRow(rowU);
            model1.removeRow(indexs[i]);
        }
    }//GEN-LAST:event_btnAddstdUActionPerformed

    private void btnChangeTechUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeTechUActionPerformed
        jscrolTechEU.setVisible(true);
        jscrolTechU.setVisible(true);
        jscrolStdEU.setVisible(false);
        jscrolStdBU.setVisible(false);
        btnAddTechU.setVisible(true);
        btnReTechU.setVisible(true);
        btnAddstdU.setVisible(false);
        btnRestdU.setVisible(false);
        btnChangeStdU.setVisible(true);
        btnChangeTechU.setVisible(false);
        cboSUBU.setVisible(true);
        txStdSearch.setVisible(false);
        txtTeacherSearch.setVisible(true);
        try {
            loadTableTeacherU();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChangeTechUActionPerformed

    private void btnAddTechUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTechUActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) jTableExistTechU.getModel();
        int[] indexs = jTableExistTechU.getSelectedRows();
        Object[] row = new Object[5];
        DefaultTableModel model2 = (DefaultTableModel) jTableBatchTechU.getModel();
        for(int i =0; i<indexs.length; i++){
            row[0] = model1.getValueAt(indexs[i], 0);
            row[1] = model1.getValueAt(indexs[i], 1);
            row[2] = model1.getValueAt(indexs[i], 2);
            row[3] = model1.getValueAt(indexs[i], 3);
            row[4] = model1.getValueAt(indexs[i], 4);
            model2.addRow(row);
            model1.removeRow(indexs[i]);
        }
    }//GEN-LAST:event_btnAddTechUActionPerformed

    private void btnCancelUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUActionPerformed
        // TODO add your handling code here:
        txtBname.setText("");
        txtCname.setSelectedIndex(0);
        dcBdate.setDate(null);
        txtDesc.setText("");
    }//GEN-LAST:event_btnCancelUActionPerformed

    private void btnReTechUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReTechUActionPerformed
        String data="Std_ID : "+jTableBatchTechU.getValueAt(jTableBatchTechU.getSelectedRow(), 0).toString();
	data+="\nStd_Name : "+jTableBatchTechU.getValueAt(jTableBatchTechU.getSelectedRow(), 1).toString();
        data+="\nDOB : "+jTableBatchTechU.getValueAt(jTableBatchTechU.getSelectedRow(), 2).toString();
	data+="\nEmail : "+jTableBatchTechU.getValueAt(jTableBatchTechU.getSelectedRow(), 3).toString();
	data+="\nPh_NO : "+jTableBatchTechU.getValueAt(jTableBatchTechU.getSelectedRow(), 4).toString();
        data+="\n Do you want to really delete above data";
	int ch=JOptionPane.showConfirmDialog(null, data, "Confirm Message",JOptionPane.WARNING_MESSAGE);
            if(ch==JOptionPane.YES_OPTION){
            DefaultTableModel model1 =(DefaultTableModel) jTableBatchTechU.getModel();
            int[] ind = jTableBatchTechU.getSelectedRows();
            Object[] row = new Object[5];
            DefaultTableModel model2 = (DefaultTableModel) jTableExistTechU.getModel(); //JTstdBatchA  jtableExistStd
            for(int i =0; i<ind.length;i++){
            row[0] = model1.getValueAt(ind[i], 0);
            row[1] = model1.getValueAt(ind[i], 1);
            row[2] = model1.getValueAt(ind[i], 2);
            row[3] = model1.getValueAt(ind[i], 3);
            row[4] = model1.getValueAt(ind[i], 4);
            model2.addRow(row);
            model1.removeRow(jTableBatchTechU.getSelectedRow());
            } 
         }
    }//GEN-LAST:event_btnReTechUActionPerformed

    private void labBackUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBackUMouseClicked
        Batch_Add.setVisible(false);
        Batch_View.setVisible(false);
        Batch_Info.setVisible(true);
        Batch_Update.setVisible(false);
    }//GEN-LAST:event_labBackUMouseClicked

    private void cboNameUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNameUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNameUActionPerformed

    private void txtNameUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameUActionPerformed

    private void cbBatchName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBatchName2ActionPerformed

        cbBatchName2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                BatchStdPayModel bspModel = null;
                 BatchTeacherModel tModel = null;
                try {
                    bspModel = new BatchStdPayModel(new BatchStdPayDAO().getAllStdPayment(new BatchStdPayDAO().getBatchId(cbBatchName2.getSelectedItem().toString())));
                    tModel = new BatchTeacherModel(new BatchTeacherDAO().getAllTeacher(new BatchTeacherDAO().getBatchId(cbBatchName2.getSelectedItem().toString())));
                } catch (SQLException ex) {
                    Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                jTstdV.setModel(bspModel);
                jTteacherV.setModel(tModel);
        } });
    }//GEN-LAST:event_cbBatchName2ActionPerformed

    private void lblHomeInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeInfoMouseClicked
        dispose();
        AdminPanel ad = new AdminPanel();
             ad.setVisible(true);
             ad.loginPane.setVisible(false);
             ad.logoutpane.setVisible(false);
    }//GEN-LAST:event_lblHomeInfoMouseClicked

    private void lblHomeUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeUMouseClicked
         dispose();
        AdminPanel ad = new AdminPanel();
             ad.setVisible(true);
             ad.loginPane.setVisible(false);
             ad.logoutpane.setVisible(false);
    }//GEN-LAST:event_lblHomeUMouseClicked

    private void cbBatchName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBatchName1ActionPerformed
//        cbBatchName1.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent arg0) {
//            BatchTeacherModel tModel = null;
//                try {
//                    tModel = new BatchTeacherModel(new BatchTeacherDAO().getAllTeacher(new BatchTeacherDAO().getBatchId(cbBatchName1.getSelectedItem().toString())));
//                } catch (SQLException ex) {
//                    Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                jTteacherV.setModel(tModel);
//                
//        } });
    }//GEN-LAST:event_cbBatchName1ActionPerformed

    private void cboSUBUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSUBUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSUBUActionPerformed

    private void cboSubAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSubAddActionPerformed

    private void txStdSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txStdSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel)jTstdExistU.getModel();
                  TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
                  jTstdExistU.setRowSorter(tr);
                  tr.setRowFilter(RowFilter.regexFilter(txStdSearch.getText())); 
    }//GEN-LAST:event_txStdSearchKeyReleased

    private void txtTeacherSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeacherSearchKeyReleased
         DefaultTableModel model = (DefaultTableModel)jTableExistTechU.getModel();
                  TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
                  jTableExistTechU.setRowSorter(tr);
                  tr.setRowFilter(RowFilter.regexFilter(txtTeacherSearch.getText())); 
    }//GEN-LAST:event_txtTeacherSearchKeyReleased

    private void txtTeSearchAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeSearchAKeyReleased
      DefaultTableModel model = (DefaultTableModel)jTableExistTechA.getModel();
                  TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
                  jTableExistTechA.setRowSorter(tr);
                  tr.setRowFilter(RowFilter.regexFilter(txtTeSearchA.getText())); 
    }//GEN-LAST:event_txtTeSearchAKeyReleased

    private void txtStdSearchAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdSearchAKeyReleased
        DefaultTableModel model = (DefaultTableModel)jtableExistStd.getModel();
                  TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
                  jtableExistStd.setRowSorter(tr);
                  tr.setRowFilter(RowFilter.regexFilter(txtStdSearchA.getText())); 
    }//GEN-LAST:event_txtStdSearchAKeyReleased

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
       dispose();
        AdminPanel ad = new AdminPanel();
       ad.setVisible(true);
       ad.loginPane.setVisible(false);
    }//GEN-LAST:event_lblHomeMouseClicked

    private void txtInfoSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInfoSearchKeyReleased
       DefaultTableModel model = (DefaultTableModel)jtBatchInfo.getModel();
       TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
       jtBatchInfo.setRowSorter(tr);
       tr.setRowFilter(RowFilter.regexFilter(txtInfoSearch.getText())); 
    }//GEN-LAST:event_txtInfoSearchKeyReleased

    private void btnrefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrefreshMouseClicked
         try {
            txtInfoSearch.setText(null);
            DefaultTableModel model = (DefaultTableModel)jtBatchInfo.getModel();
            TableRowSorter<DefaultTableModel>tr= new TableRowSorter<DefaultTableModel>(model);
            jtBatchInfo.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(txtInfoSearch.getText()));
            loadTableBatch();
        } catch (SQLException ex) {
            Logger.getLogger(BatchUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnrefreshMouseClicked

    private void labSearchstdVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labSearchstdVMouseClicked
        
    }//GEN-LAST:event_labSearchstdVMouseClicked

    public boolean inputCheck() throws SQLException {
    boolean result = false;
    

    if (txtBname.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Batch Name is required data", "Input Missing Error", JOptionPane.ERROR_MESSAGE);
        txtBname.requestFocus();
    } else {
        String bnamePt = "^(JP|IT)-Batch\\d+$";
        String bname = txtBname.getText().trim();

        if (!bname.matches(bnamePt)) {
            JOptionPane.showMessageDialog(null, "Batch Name should start with JP-Batch, IT-Batch", "Invalid Course Number", JOptionPane.ERROR_MESSAGE);
        } else {
            String name = txtBname.getText().trim();
             if(new BatchDAO().isBatchNameExist(name)){
                  JOptionPane.showMessageDialog(this, "This Batch Name has already been existed");
           }else {
                    if (dcBdate.getDate()== null) {
                                JOptionPane.showMessageDialog(null, "Date is required data", "Input Missing Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                    if (txtDesc.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Description is required data", "Input Missing Error", JOptionPane.ERROR_MESSAGE);
                                    } 
                                    else {
                                                result = true;
                                        }
                                    }
                }
                               
            }
    }
    
    return result;
    }
    
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
            java.util.logging.Logger.getLogger(BatchUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatchUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatchUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatchUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatchUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Batch_Add;
    private javax.swing.JPanel Batch_Info;
    private javax.swing.JPanel Batch_Update;
    private javax.swing.JPanel Batch_View;
    public javax.swing.JTable JTstdBatchA;
    private javax.swing.JButton btPayment;
    private javax.swing.JButton btnAddMain;
    private javax.swing.JButton btnAddTech;
    private javax.swing.JButton btnAddTechU;
    private javax.swing.JButton btnAddstd;
    private javax.swing.JButton btnAddstdU;
    private javax.swing.JButton btnCancelA;
    private javax.swing.JButton btnCancelU;
    private javax.swing.JButton btnChangeStdA;
    private javax.swing.JButton btnChangeStdU;
    private javax.swing.JButton btnChangeTechA;
    private javax.swing.JButton btnChangeTechU;
    private javax.swing.JButton btnCreateA1;
    private javax.swing.JButton btnReTech;
    private javax.swing.JButton btnReTechU;
    private javax.swing.JButton btnRestd;
    private javax.swing.JButton btnRestdU;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnUpdateU;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel btnrefresh;
    private javax.swing.JComboBox<String> cbBatchName1;
    private javax.swing.JComboBox<String> cbBatchName2;
    public javax.swing.JComboBox<String> cboNameU;
    private javax.swing.JComboBox<String> cboSUBU;
    public javax.swing.JComboBox<String> cboSubAdd;
    public com.toedter.calendar.JDateChooser dcBdate;
    private com.toedter.calendar.JDateChooser dcBtStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JTable jTableBatchTechA;
    private javax.swing.JTable jTableBatchTechU;
    public javax.swing.JTable jTableExistTechA;
    private javax.swing.JTable jTableExistTechU;
    private javax.swing.JTable jTstdBatchU;
    private javax.swing.JTable jTstdExistU;
    private javax.swing.JTable jTstdV;
    private javax.swing.JTable jTteacherV;
    private javax.swing.JScrollPane jscrolStdB;
    private javax.swing.JScrollPane jscrolStdBU;
    private javax.swing.JScrollPane jscrolStdE;
    private javax.swing.JScrollPane jscrolStdEU;
    private javax.swing.JScrollPane jscrolTechB;
    private javax.swing.JScrollPane jscrolTechE;
    private javax.swing.JScrollPane jscrolTechEU;
    private javax.swing.JScrollPane jscrolTechU;
    private javax.swing.JTable jtBatchInfo;
    private javax.swing.JScrollPane jtable;
    public javax.swing.JTable jtableExistStd;
    private javax.swing.JLabel labBack;
    private javax.swing.JLabel labBackA;
    private javax.swing.JLabel labBackU;
    private javax.swing.JLabel labBackV;
    private javax.swing.JLabel labSearchBatch;
    private javax.swing.JLabel labSearchstdV;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblHomeInfo;
    private javax.swing.JLabel lblHomeU;
    public javax.swing.JTextField txStdSearch;
    private javax.swing.JTextArea txtAU;
    public javax.swing.JTextField txtBname;
    public javax.swing.JComboBox<String> txtCname;
    public javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtInfoSearch;
    private javax.swing.JTextField txtNameU;
    private javax.swing.JTextField txtStdSearchA;
    private javax.swing.JTextField txtTeSearchA;
    public javax.swing.JTextField txtTeacherSearch;
    // End of variables declaration//GEN-END:variables
}
