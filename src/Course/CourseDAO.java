/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Course;

import java.sql.Connection;
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
 * @author MSI
 */
public class CourseDAO {
      private Connection con;
    public  CourseDAO(){
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
		}
		catch(Exception e){
			e.printStackTrace();
                }
    }
      public static void close(Connection con,PreparedStatement pst,ResultSet rs) throws SQLException{
 		if(con!=null)con.close();
 		if(pst!=null) pst.close();
 		if(rs!=null) rs.close();
      }
                
       public void insert_course(Course_Class cc){
        
        try{
        String query="insert into Course(Course_no,Course_name,Course_desc,duration,fees) values(?,?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(query);
     
        pst.setString(1, cc.getCno());
        pst.setString(2, cc.getCname());
        pst.setString(3, cc.getCdesc());
        pst.setString(4, cc.getDu());
        pst.setInt(5, cc.getFees());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Your data is successfully save");
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null,""+e);
    }
 }
       
       public Course_Class returnAllDataToTextfield(int id){
         Course_Class cc=null;
         try{
             String query="select* from course where course_id="+id;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int ids=rs.getInt("course_id");
            String cno=rs.getString("course_no");
            String cname=rs.getString("course_name");
            String cdesc=rs.getString("course_desc");
            String per=rs.getString("duration");
             int fees=rs.getInt("fees");
            
            
           
         cc=new Course_Class(ids,cno,cname,cdesc,per,fees);
     
        }
         }catch(Exception e){
         JOptionPane.showMessageDialog(null, ""+e);
         }
         return cc;
         }
       
       
           public ArrayList<Course_Class> loadCoursedata(){
         ArrayList<Course_Class> list=new ArrayList<>();
         try{
             String query="select* from course";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int ids=rs.getInt("course_id");
            String cno=rs.getString("course_no");
            String cname=rs.getString("course_name");
            String cdesc=rs.getString("course_desc");
            String per=rs.getString("duration");
            int fees=rs.getInt("fees");
          Course_Class cc=new Course_Class(ids,cno,cname,cdesc,per,fees);
         list.add(cc);
      
        }
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
         return list;
         
     }
           
            public void updateCourse_Data(Course_Class cc){
        try{
             
               
            String query="Update course set Course_no=?,course_name=?,course_desc=?,duration=?,fees=? where course_id=?";
            PreparedStatement pst=con.prepareStatement(query);
            
            pst.setString(1, cc.getCno());
            pst.setString(2, cc.getCname());
            pst.setString(3, cc.getCdesc());
            pst.setString(4, cc.getDu());
            pst.setInt(5, cc.getFees());
            pst.setInt(6, cc.getCid());
                 
            if(pst.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
            }
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, ""+e);
 }
}
         public boolean isCourseNoExist(String cno){
    
          try {
              PreparedStatement pst=con.prepareStatement("select * from course where course_no=?");
              pst.setString(1, cno);
              ResultSet rs=pst.executeQuery();
              if(rs.next()){
                  return true;
              }

          } catch (SQLException ex) {
              Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
              return false;
         }
       
}

