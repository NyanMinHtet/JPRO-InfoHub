/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ITStudent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Thet Mhue Aung
 */
public class StudentDAO {
     private Connection con;
    
    public StudentDAO(){
        
         try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
        }
        catch(SQLException e){
         e.printStackTrace();
        }
    }
       public void addStudent(Student a,String img){
        
        try{
        String query="insert into student(std_no,name,DOB,Email,Ph_no,Gender,Religion,NRC,Nationality,Telegram,photo) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(query);
     
        pst.setString(1,a.getStd_no());
        pst.setString(2,a.getName());
        pst.setDate(3,a.getDob());
        pst.setString(4,a.getEmail());
        pst.setString(5,a.getPhno());
        pst.setString(6,a.getGender());
        pst.setString(7,a.getReligion());
          pst.setString(8,a.getNrc());
        pst.setString(9,a.getNation());
        pst.setString(10,a.getTele_no());
        pst.setString(11, a.getPhoto());
        File sourceFile = new File(img);
        File destinationFile = new File("D:\\JPRO\\RegiCourse\\Jpro_InfoHub_Update_Final\\src\\StdImg" + sourceFile.getName());
        Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
      
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Your data is successfully save");
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null,""+e);
    }
    
}
    

public ArrayList<Student> loaddataStd(){
         ArrayList<Student> list=new ArrayList<>();
         try{
             String query="select* from student";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int id=rs.getInt("Std_id");
         String no=rs.getString("Std_no");
         String name=rs.getString("name");
         Date d=rs.getDate("DoB");
         String email=rs.getString("Email");
         String pno=rs.getString("Ph_no");
	 String gender=rs.getString("Gender");
	 String reli=rs.getString("Religion");
	 String nation=rs.getString("Nationality");
	 String tno=rs.getString("Telegram");
         String photo=rs.getString("Photo");
         String nrc=rs.getString("NRC");
         
         
//StudentIT(int id, String no, String name, Date d, String email, String pno, String gender, String reli, String nrc, String nation, String tno, String photo)
         Student std=new Student(id,no, name, d, email,pno,gender,reli,nation,tno,nrc,photo);
         list.add(std);
      
        }
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
         return list;
         
     }
      
//For View Function


     public Student returnAllDataToTextfieldStd(int id){
         Student std=null;
         try{
             String query="select* from student where Std_id="+id;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
          int ids=rs.getInt("std_id");
         String no=rs.getString("Std_no");
         String name=rs.getString("name");
         Date d=rs.getDate("DoB");
         String email=rs.getString("Email");
         String pno=rs.getString("Ph_no");
	 String gender=rs.getString("Gender");
	 String reli=rs.getString("Religion");
	 String nation=rs.getString("Nationality");
	 String tno=rs.getString("Telegram");
         String nrc=rs.getString("NRC");
         String img=rs.getString("photo");
         
         std=new Student(ids,no, name, d, email, pno, gender, reli, nation, tno, nrc,img);
     
        }
         }catch(Exception e){
         JOptionPane.showMessageDialog(null, ""+e);
         }
         
         return std;
         }
     
     //For Update Function   

 public void updateDataStd(Student s,String img){
        try{
             
               
            String query="Update student set std_no=?,name=?,DOB=?,Email=?,Ph_no=?,Gender=?,Religion=?,nrc=?,Nationality=?,Telegram=?,Photo=? where Std_id=?";
            PreparedStatement pst=con.prepareStatement(query);
           
        pst.setString(1,s.getStd_no());
        pst.setString(2,s.getName());
        pst.setDate(3,s.getDob());
        pst.setString(4,s.getEmail());
        pst.setString(5,s.getPhno());
        pst.setString(6,s.getGender());
        pst.setString(7,s.getReligion());
        pst.setString(8,s.getNrc());
        pst.setString(9,s.getNation());
        pst.setString(10,s.getTele_no());
        pst.setString(11,s.getPhoto());
        pst.setInt(12, s.getStd_id());

        File sourceFile = new File(img);
        File destinationFile = new File("D:\\JPRO\\RegiCourse\\Jpro_InfoHub_Update_Final\\src\\StdImg" + sourceFile.getName());
        Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        int index= pst.executeUpdate();
         if(index>0){
            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
            }
         else  JOptionPane.showMessageDialog(null, "Error Updated");
         
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, ""+e);
 }
}
              public boolean isStdNoExist(String stdno){
    
          try {
              PreparedStatement pst=con.prepareStatement("select * from student where std_no=?");
              pst.setString(1, stdno);
              ResultSet rs=pst.executeQuery();
              if(rs.next()){
                  return true;
              }

          } catch (SQLException ex) {
              Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
              return false;
         }
}
