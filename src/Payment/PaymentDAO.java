/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Batch.BatchStdPay;

/**
 *
 * @author DELL
 */
public class PaymentDAO {
    private Connection con;
    
    public PaymentDAO(){
        try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
     public void addPaymentInfo(PayData p) throws SQLException{
        try{
//        BatchStdPay bsp = new BatchStdPay();
        
        PreparedStatement pst = con.prepareStatement("insert into Payment(Bm_id,Payment_date,Amount,Discount,Payment_method,Payperson_info,Payment_desc,Remark) values(?,?,?,?,?,?,?,?)");
        pst.setInt(1,p.getbmID());
        pst.setDate(2,p.getPayDate());
        pst.setString(3, p.getAmount());
        pst.setString(4, p.getDiscount());
        pst.setString(5, p.getPaymethod());
        pst.setString(6, p.getPersonInfo());
        pst.setString(7, p.getDesc());
        pst.setString(8, p.getRemark());
       
        int i = pst.executeUpdate();
        
        if(i >0){
            JOptionPane.showMessageDialog(null, "Successfully Added to Payment");
            }
         }catch(Exception e){
           JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
    public void updatePaymentInfo(PayData p) throws SQLException{
        try{
        BatchStdPay bsp = new BatchStdPay();
        
        PreparedStatement pst = con.prepareStatement("update Payment set Payment_date=? ,Amount=? ,Discount=? ,Payment_method=? ,Payperson_info=? ,Payment_desc=? ,Remark=? where Bm_id=?");
       
        pst.setDate(1,p.getPayDate());
        pst.setString(2, p.getAmount());
        pst.setString(3, p.getDiscount());
        pst.setString(4, p.getPaymethod());
        pst.setString(5, p.getPersonInfo());
        pst.setString(6, p.getDesc());
        pst.setString(7, p.getRemark());
        pst.setInt(8,p.getbmID());
        pst.executeUpdate();
        if(pst.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
            }
         }catch(Exception e){
           JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
    public ArrayList<PayData> loadPaymentData() throws SQLException{
        ArrayList<PayData> payList = new ArrayList<PayData>();
        try{
        String query = "select * from payment";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int pid = rs.getInt(1);
            int bmid = rs.getInt(2);
            Date pdate = rs.getDate(3);
            String amt = rs.getString(4);
            String disc = rs.getString(5);
            String method = rs.getString(6);
            String info = rs.getString(7);
            String des = rs.getString(8);
            String remark = rs.getString(9);
           
            PayData pdata = new PayData(pid, bmid, pdate, amt, disc, method, info, des, remark);
            payList.add(pdata);
        }
        }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
            return payList;
        }
    
     public PayData getPayment(int id) throws SQLException{
        PayData pd = null;
//        PreparedStatement pst = con.prepareStatement(" select Payment_date,Payment_Method,Payperson_info,Payment_desc,Remark from payment,batch_member where payment.bm_id = batch_member.bm_id and payment.bm_id = ?");
        PreparedStatement pst = con.prepareStatement(" select * from payment,batch_member where payment.bm_id = batch_member.bm_id and payment.bm_id = "+id);
//        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            int bmid = rs.getInt("Bm_id");
            Date pdate = rs.getDate("Payment_date");
            String amount = rs.getString("Amount");
            String discount = rs.getString("Discount");
            String pmethod = rs.getString("Payment_Method");
            String personInfo = rs.getString("Payperson_info");
            String desc = rs.getString("Payment_desc");
            String remark = rs.getString("Remark");
            
            pd= new PayData(0,bmid,pdate,amount,discount,pmethod,personInfo,desc,remark);
        }
        
        return pd;
    }
    }
    
//    public ArrayList<PayData> getAllPayment (int id) throws SQLException{
//        ArrayList<PayData> payment = new ArrayList<PayData>();
//        PreparedStatement pst = null;
//        if(id > 0){
//            pst = con.prepareStatement("select Pay_id, Bm_id, Amount, Discount from payment where Payment.Bm_id = ?");
//            pst.setInt(1, id);
//        }
//        else
//            pst = con.prepareStatement("select Pay_id, Bm_id, Amount, Discount from payment");
//        ResultSet rs = pst.executeQuery();
//        while(rs.next())
//            payment.add(new PayData(rs.getInt(1),rs.getInt(2),null,rs.getString(3),rs.getString(4),null,null,null,null));
//        pst.close();
//        rs.close();
//        return payment;   
//    }



    

