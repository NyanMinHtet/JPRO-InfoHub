/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ITStudent;
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
 * @author Thet Mhue Aung
 */
public class AddressDAO {
     private Connection con;
    
    public AddressDAO(){
       
         try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
        }
        catch(SQLException e){
         e.printStackTrace();
        }
    }

    
    public void addAddress(Address a) throws SQLException{
        PreparedStatement pst = con.prepareStatement("insert into address(std_id,Region,City,Township) values(?,?,?,?)");
        pst.setInt(1,a.getStd_id());
	pst.setString(2,a.getRegion());
        pst.setString(3,a.getCity());
        pst.setString(4,a.getTown());
        
       
        int i = pst.executeUpdate();
        
         if(i>0)
		JOptionPane.showMessageDialog(null, "Your Data have been saved successfully", "Finished Saving",JOptionPane.INFORMATION_MESSAGE);
		else
	       JOptionPane.showMessageDialog(null, "Can't save your data", "Error Saving", JOptionPane.WARNING_MESSAGE);;
	pst.close();   
    }

    
public ArrayList<Address> loaddataAdd(int adid){
         ArrayList<Address> list=new ArrayList<>();
         try{
             String query="select* from Address where std_id="+adid;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
           
         int aid=rs.getInt("Aid");
         String r=rs.getString("Region");
         String c=rs.getString("City");
	 String t=rs.getString("Township");
	      
	
         

         Address add=new Address(aid,adid,r,c,t);
         list.add(add);
      
        }
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
         return list;
         
     }
      
//For View Function

     public Address returnAllDataToTextfieldAdd(int stid){
         Address add=null;
         try{
             String query="select* from address where std_id="+stid;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
          int ai=rs.getInt("aid");  
         String r=rs.getString("Region"); 
         String c=rs.getString("City");
	 String t=rs.getString("Township"); 
         

         add=new Address(ai,stid,r,c,t);
     
        }
         }catch(Exception e){
         JOptionPane.showMessageDialog(null, ""+e);
         }
         return add;
         }
     
     //For Update Function   

 public void updateDataAdd(Address a){
        try{
             
               
            String query="Update Address set Region=?,City=?,Township=? where std_id=?";
            PreparedStatement pst=con.prepareStatement(query);
           
         pst.setString(1,a.getRegion());
        pst.setString(2,a.getCity());
        pst.setString(3,a.getTown());
        pst.setInt(4, a.getStd_id());
        
            if(pst.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
            }
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, ""+e);
 }
}
}
