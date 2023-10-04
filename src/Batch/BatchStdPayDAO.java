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
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BatchStdPayDAO {
    
     private Connection con;
     
     public BatchStdPayDAO(){
         try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JPro_InfoHub","root","root");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
     }
     
     public ArrayList<BatchStdPay> getAllStdPayment (int id) throws SQLException{
        ArrayList<BatchStdPay> payment = new ArrayList<BatchStdPay>();
        PreparedStatement pst = null;
        if(id == 2){
              pst = con.prepareStatement(" select Batch_member.Bm_id,name,DoB,Email,Ph_no,Telegram,Amount,Discount from student,batch_member,batch,payment where Batch.Batch_id = Batch_member.Batch_id and Batch_member.Std_id = Student.Std_id and Batch_member.Bm_id = Payment.Bm_id");
        }
        
        else if(id > 2){
            pst = con.prepareStatement("select Batch_member.Bm_id,name,DoB,Email,Ph_no,Telegram,Amount,Discount from student,batch_member,batch,payment where Batch.Batch_id = Batch_member.Batch_id and Batch_member.Std_id = Student.Std_id and Batch_member.Bm_id = Payment.Bm_id and Batch.Batch_id = ?");
            pst.setInt(1, id);
        }
//        else 
//            pst = con.prepareStatement(" select Batch_member.Bm_id,name,DoB,Email,Ph_no,Telegram,Amount,Discount from student,batch_member,batch,payment where Batch.Batch_id = Batch_member.Batch_id and Batch_member.Std_id = Student.Std_id and Batch_member.Bm_id = Payment.Bm_id");
        ResultSet rs = pst.executeQuery();
        while(rs.next())
            payment.add(new BatchStdPay(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
        pst.close();
        rs.close();
        return payment;   
    }
     
      public ArrayList<BatchStdPay> getAllStdPayment1 () throws SQLException{
        ArrayList<BatchStdPay> payment = new ArrayList<BatchStdPay>();
        PreparedStatement pst = null;
        
        pst = con.prepareStatement("select Batch_member.Bm_id,name,DoB,Email,Ph_no,Telegram,Amount,Discount from student,batch_member,batch,payment where Batch.Batch_id = Batch_member.Batch_id and Batch_member.Std_id = Student.Std_id and Batch_member.Bm_id = Payment.Bm_id");
        ResultSet rs = pst.executeQuery();
        while(rs.next())
            payment.add(new BatchStdPay(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
        pst.close();
        rs.close();
        return payment;   
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
     
            public BatchStdPay returnAllDataToTextField(int id) throws SQLException{
            BatchStdPay bsp = null;
            
            PreparedStatement pst = con.prepareStatement("select Batch_member.Bm_id,name,Email,Ph_no,Amount,Discount from student,batch_member,batch,payment where Batch.Batch_id = Batch_member.Batch_id and Batch_member.Std_id = Student.Std_id and Batch_member.Bm_id = Payment.Bm_id and Batch_member.Bm_id = "+id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int bmid = rs.getInt("Bm_id");
                String sname = rs.getString("name");
                String email = rs.getString("Email");
                String pno = rs.getString("Ph_no");
//                Date sd = rs.getDate("Start_Date");
                String amt = rs.getString("Amount");
                String dis = rs.getString("Discount");
                
             bsp = new BatchStdPay(bmid,sname,null,email,pno,null,amt,dis);
            }
             return bsp;
        }
//    
    
}
