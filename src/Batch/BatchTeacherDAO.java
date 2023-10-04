/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batch;

import Teacher.Teacher_Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class BatchTeacherDAO {
    
    private Connection con;
    public BatchTeacherDAO(){
         try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JPro_InfoHub","root","root");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addBatchTeacher(BatchTeacher t) throws SQLException {


        PreparedStatement pst = con.prepareStatement("insert into batch_teacher(Batch_id,Tid,subId) values(?,?,?)");
        pst.setInt(1,t.getBatchId());
        pst.setInt(2,t.getTid());
        pst.setInt(3,t.getSubId());
        pst.executeUpdate();
    }
    
    public int getBatchId (String name) throws SQLException {
            PreparedStatement pst = con.prepareStatement("select Batch_id from Batch where Batch_name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            int bid = 0;
            while(rs.next())
                bid = rs.getInt(1);
            return bid;
      }
    
    public ArrayList<Teacher_Class> getAllTeacher (int id) throws SQLException{
        ArrayList<Teacher_Class> teacher = new ArrayList<Teacher_Class>();
        PreparedStatement pst = null;
        
        if(id == 2){
            pst = con.prepareStatement("select teacher.Tid, teacher.name, teacher.dob, teacher.ph_no, teacher.edu_back from teacher,batch_teacher,batch where Batch_teacher.Batch_id = Batch.Batch_id and Batch_teacher.Tid = Teacher.Tid");
        }
        else if(id > 2){
            pst = con.prepareStatement("select teacher.Tid, teacher.name, teacher.dob, teacher.ph_no, teacher.edu_back from teacher,batch_teacher,batch where Batch_teacher.Batch_id = Batch.Batch_id and Batch_teacher.Tid = Teacher.Tid and Batch_Teacher.Batch_id=?");
            pst.setInt(1, id);
        }
//        else 
//            pst = con.prepareStatement("select teacher.Tid, teacher.name, teacher.dob, teacher.ph_no, teacher.edu_back from teacher,batch_teacher,batch where Batch_teacher.Batch_id = Batch.Batch_id and Batch_teacher.Tid = Teacher.Tid");
        ResultSet rs = pst.executeQuery();
        while(rs.next())
            teacher.add(new Teacher_Class(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5)));
        pst.close();
        rs.close();
        return teacher;   
    }
    
     public boolean isTeacherIdExist(int tid){
    
          try {
              PreparedStatement pst=con.prepareStatement("select * from batch_teacher where Tid=?");
              pst.setInt(1, tid);
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
