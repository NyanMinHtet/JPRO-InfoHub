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
public class RelationshipDAO {
     private Connection con;
    
    public RelationshipDAO(){
        
         try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
        }
        catch(SQLException e){
         e.printStackTrace();
        }
    }
    public int getStudentID() throws SQLException{
            int id=0;
            String maxId = "SELECT MAX(std_id) FROM student";
            
            PreparedStatement statement = con.prepareStatement(maxId);
            ResultSet rs = statement.executeQuery();
            
            
            while (rs.next()) {
                id = rs.getInt(1);
                
            }
             return id;
        }
    
    public void addRelationship(Relationship a) throws SQLException{
        PreparedStatement pst = con.prepareStatement("insert into relationship(std_id,name,phno,occupation,rs_type) values(?,?,?,?,?)");
           pst.setInt(1,a.getStd_id());
        pst.setString(2,a.getName());
        pst.setString(3,a.getPhno());
        pst.setString(4,a.getOccupation());
        pst.setString(5,a.getRs_type());
    
        
       
        int i = pst.executeUpdate();
        
        
	pst.close();   
    }
    
      //For 
//Show data from database
public ArrayList<Relationship> loaddataRS(){
         ArrayList<Relationship> list=new ArrayList<>();
         try{
             String query=" select * from relationship where std_id = (select max(std_id) from student)";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
           
         int Rid= rs.getInt("Rrid");
         int Sid=rs.getInt("std_id");
         String n=rs.getString("name");
         String pno=rs.getString("phno");
         String occup=rs.getString("occupation"); 
	 String rsType=rs.getString("rs_type");
	     
	
         

         Relationship rsp =new Relationship(Rid,Sid,n,pno,occup, rsType);
        list.add(rsp);
        }
      
        
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
         return list;
         
     }
      
//For View Function

     public Relationship returnAllDataToTextfieldRS(int sid){
         Relationship rsp=null;
         try{
             String query="select* from relationship where std_id="+sid;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int rid=rs.getInt("Rrid");
         String n=rs.getString("name");
         String pno=rs.getString("phno");
         String occup=rs.getString("occupation"); 
	 String rsType=rs.getString("rs_type");
         

        rsp= new Relationship(rid,sid,n,pno,occup,rsType);
     
        }
         }catch(Exception e){
         JOptionPane.showMessageDialog(null, ""+e);
         }
         return rsp;
         }
     
     //For Update Function   

 public void updateDataRS(Relationship rs){
        try{
             
               
            String query="Update relationship set name=?,phno=?,occupation=?,rs_type=? where rRid=?";
            PreparedStatement pst=con.prepareStatement(query);
           
         
        pst.setString(1,rs.getName());
        pst.setString(2,rs.getPhno());
        pst.setString(3,rs.getOccupation());
        pst.setString(4,rs.getRs_type());
        pst.setInt(5,rs.getRid());
            if(pst.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
            }
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, ""+e);
 }
}   
 public ArrayList<Relationship> loadupdatedataRS(int sidd){
         ArrayList<Relationship> list=new ArrayList<>();
         try{
             String query="select* from relationship where std_id="+sidd;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
           
         int Rid= rs.getInt("Rrid");
         String n=rs.getString("name");
         String pno=rs.getString("phno");
         String occup=rs.getString("occupation"); 
	 String rsType=rs.getString("rs_type");
	     
	
         

         Relationship rsp =new Relationship(Rid,sidd,n,pno,occup, rsType);
        list.add(rsp);
        }
      
        
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
         return list;
         
     }

}
