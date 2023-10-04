/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batch;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import ITStudent.Student;
import Teacher.Teacher_Class;

/**
 *
 * @author DELL
 */
public class BatchDAO {
    private Connection con;
    public BatchDAO(){
       
        try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JPro_InfoHub","root","root");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param b
     * @throws SQLException
     */
    public void addBatch(Batch b) throws SQLException{
        PreparedStatement pst = con.prepareStatement("select Course_id from Course where Course_name=?");
	pst.setString(1, b.getCourse_name());
	ResultSet rs = pst.executeQuery();
        
        int id=0;
	while(rs.next())
            id = rs.getInt(1);
            pst = con.prepareStatement("insert into Batch (Batch_Name,Course_id,Start_date,Description) values(?,?,?,?)");
           pst.setString(1, b.getBatch_name());
           pst.setInt(2,id);
           pst.setDate(3,b.getStart_date());
           pst.setString(4,b.getDesc());
           
           int i = pst.executeUpdate();
           if(i>0)
			JOptionPane.showMessageDialog(null, "Your Data have been saved successfully", "Finished Saving",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Can't save your data", "Error Saving", JOptionPane.WARNING_MESSAGE);;
		pst.close();
                rs.close();
		
       }
    
        public ArrayList<Student> loadDataStudent() throws SQLException{
        ArrayList<Student> listStd = new ArrayList<>();
        
        try{
        String query = "select * from student";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int sid = rs.getInt("Std_id");
            String sno = rs.getString("std_no");
            String name = rs.getString("name");
            Date d = rs.getDate("DoB"); 
            String email = rs.getString("Email");
            String pno = rs.getString("Ph_no");
            String gender = rs.getString("Gender");
            String reli = rs.getString("Religion");
            String nrc = rs.getString("NRC");
            String nation = rs.getString("Nationality");
            String tele = rs.getString("Telegram");
            String photo = rs.getString("Photo");
           
            
            Student std = new Student(sid, sno,name, d, email, pno, gender, reli, nrc, nation, tele, photo);
            listStd.add(std);
        }
        }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
            return listStd;
        }
        
        public ArrayList<Batch> loadBatchData(){
             ArrayList<Batch> batchList = new ArrayList<>();
        
        try{
        String query = "select * from batch";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int bid = rs.getInt("Batch_id");
            String bname = rs.getString("Batch_name");
            int cid = rs.getInt("Course_id");
            Date d = rs.getDate("Start_date"); 
            String desc = rs.getString("Description");
           
            Batch bat = new Batch(bid, bname, getCName(cid), d, desc);
            batchList.add(bat);
        }
        }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
            return batchList;
        }
        
         public ArrayList<Teacher_Class> loadTeacherData(){
             ArrayList<Teacher_Class> teacherList = new ArrayList<>();
             
             try{
        String query = "select * from teacher";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int tid = rs.getInt(1);
            String tname = rs.getString(2);
            Date d = rs.getDate(3); 
            String pno = rs.getString(4);
            String edu = rs.getString(5);
           
            Teacher_Class tc = new Teacher_Class(tid, tname, d, pno, edu);
            teacherList.add(tc);
        }
        }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
            return teacherList;
        }
        
        public String getCName(int cid) throws SQLException{
            PreparedStatement pst = con.prepareStatement("select Course_name from Course where Course_id = ?");
            pst.setInt(1,cid);
            ResultSet rs = pst.executeQuery();
            
            String name = null;
		while(rs.next())
			name = rs.getString(1);
                return name;
        }
        
        
        public Batch returnAllDataToTextField(int id) throws SQLException{
            Batch bt = null;
            
            PreparedStatement pst = con.prepareStatement("select * from batch where Batch_id ="+id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int bid = rs.getInt("Batch_id");
                String bname = rs.getString("Batch_name");
                int cid = rs.getInt("Course_id");
                String course_name = getCName(cid);
                Date sd = rs.getDate("Start_Date");
                String des = rs.getString("Description");
             bt = new Batch(bid,bname,course_name,sd,des);
            }
              return bt;
        }
        
        public void updateBatch(Batch bt){
        try{
             PreparedStatement pst = con.prepareStatement("select Course_id from Course where Course_name=?");
            pst.setString(1, bt.getCourse_name());
            ResultSet rs = pst.executeQuery();
            int id=0;
            while(rs.next())
                 id = rs.getInt(1);
            
            String query="Update Batch set Batch_Name=?,Course_id=?,Start_date=?, Description=? where Batch_id=?";
            pst=con.prepareStatement(query);
           
            pst.setString(1, bt.getBatch_name());
            pst.setInt(2, id);
            pst.setDate(3, bt.getStart_date());
            pst.setString(4, bt.getDesc());
            pst.setInt(5, bt.getBatch_id());
            pst.executeUpdate();
            if(pst.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, ""+e);
        }
    }
        
//      public int getStudentId (String Sname) throws SQLException{
//    PreparedStatement pst = con.prepareStatement("select std_id from student where name = ?");
//            pst.setString(1, Sname);
//            ResultSet rs = pst.executeQuery();
//            
//            int sid = 0;
//		while(rs.next())
//			sid = rs.getInt(1);
//                return sid;
//    }
        
        public int getBatchId (String name) throws SQLException {
            PreparedStatement pst = con.prepareStatement("select Batch_id from Batch where Batch_name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            int bid = 0;
            while(rs.next())
                bid = rs.getInt(1);
            return bid;
        }
        
        public boolean isBatchNameExist(String bname){
    
          try {
              PreparedStatement pst=con.prepareStatement("select * from batch where Batch_Name=?");
              pst.setString(1, bname);
              ResultSet rs=pst.executeQuery();
              if(rs.next()){
                  return true;
              }

          } catch (SQLException ex) {
              Logger.getLogger(BatchDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
              return false;
         }
}


    
