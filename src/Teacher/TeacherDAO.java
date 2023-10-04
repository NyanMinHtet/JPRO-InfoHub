/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teacher;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class TeacherDAO {
    private Connection con;
    public  TeacherDAO(){
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
    public void insert(Teacher_Class tcc){
        
        try{
        String query="insert into teacher(Name,DoB,Ph_no,Edu_back) values(?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(query);
     
        pst.setString(1, tcc.getName());
        pst.setDate(2, tcc.getDoB());
        pst.setString(3, tcc.getPhno());
        pst.setString(4, tcc.getEduback());
  
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Your data is successfully save");
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null,""+e);
    }
    
}
    
     public ArrayList<Teacher_Class> loadTeacherData(){
         ArrayList<Teacher_Class> list=new ArrayList<>();
         try{
             String query="select* from teacher";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int ids=rs.getInt("TID");
         String Name=rs.getString("Name");
         Date d=rs.getDate("DoB");
         String pno=rs.getString("Ph_no");
         String edu=rs.getString("Edu_Back");
         Teacher_Class tcc=new Teacher_Class(ids,Name,d,pno,edu);
         list.add(tcc);
      
        }
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
         return list;
         
     }
     
     
     public Teacher_Class returnAllDataToTextfield(int id){
         Teacher_Class tcc=null;
         try{
             String query="select* from teacher where tid="+id;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int ids=rs.getInt("TID");
            String Name=rs.getString("Name");
            Date d=rs.getDate("DoB");
            String pno=rs.getString("Ph_no");
            String edu=rs.getString("Edu_Back");
       
          
         tcc=new Teacher_Class(ids,Name,d,pno,edu);
     
        }
         }catch(Exception e){
         JOptionPane.showMessageDialog(null, ""+e);
         }
         return tcc;
         }
     
     public void updateData(Teacher_Class tcc) {
    try {
        String query = "UPDATE teacher SET Name=?, DoB=?, Ph_no=?, Edu_Back=? WHERE tid=?";
        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, tcc.getName());
        pst.setDate(2, tcc.getDoB());
        pst.setString(3, tcc.getPhno());
        pst.setString(4, tcc.getEduback());
        pst.setInt(5, tcc.getTid());


        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "" + e);
    }
}

     
 
}
