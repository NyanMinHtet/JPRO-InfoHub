/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batch;

import ITStudent.StudentDAO;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class MemberDAO {
    
    private Connection con;
    public MemberDAO(){
         try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JPro_InfoHub","root","root");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
   
    
//     public int getStudentId (String Sname) throws SQLException{
//    PreparedStatement pst = con.prepareStatement("select std_id from student where name = ?");
//            pst.setString(1, Sname);
//            ResultSet rs = pst.executeQuery();
//            
//            int sid = 0;
//		while(rs.next())
//			sid = rs.getInt(1);
//                return sid;
//    }
//     
    public void addBatchMember(BatchMember m) throws SQLException {


        PreparedStatement pst = con.prepareStatement("insert into batch_member(Batch_id,Std_id,Join_date) values(?,?,?)");
        pst.setInt(1,m.getBatchId());
        pst.setInt(2,m.getStd_id());
        pst.setDate(3,m.getJoind());
        pst.executeUpdate();
    }
    
    
    public ArrayList<BatchMember> getAllBatchMember (int id) throws SQLException{
        ArrayList<BatchMember>  bMem = new ArrayList<BatchMember>() ;
        PreparedStatement pst = null;
        if(id > 0){
            pst = con.prepareStatement(" select Bm_id,Std_id from Batch_member where Batch_Member.Batch_id=?");
            pst.setInt(1, id);
        }
        else
             pst = con.prepareStatement("select Bm_id,Std_id from Batch_member");
        ResultSet rs = pst.executeQuery();
        while(rs.next())
            bMem.add(new BatchMember(rs.getInt(1),0,rs.getInt(2),null));
       pst.close();
       rs.close();
       return bMem;
    }
    
    public boolean isStdIdExist(int sid){
    
          try {
              PreparedStatement pst=con.prepareStatement("select * from Batch_member where std_id=?");
              pst.setInt(1, sid);
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
