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
public class QualificationDAO {
     private Connection con;
    
    public QualificationDAO(){
        
         try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
        }
        catch(SQLException e){
         e.printStackTrace();
        }
    }

    
        public void addQualification(Qualification a) throws SQLException{
        PreparedStatement pst = con.prepareStatement("insert into qualification(std_id,Dname,Field_name,Org_name,Type,From_date,To_date) values(?,?,?,?,?,?,?)");
       
	pst.setInt(1, a.getStd_id());
	pst.setString(2,a.getDip_name());
        pst.setString(3,a.getField_name());
	pst.setString(4,a.getOrg_name());
	pst.setString(5,a.getType());
        pst.setDate(6,a.getFrom_date());
	pst.setDate(7,a.getTo_date());
        
       
        int i = pst.executeUpdate();
        
         if(i>0)
		JOptionPane.showMessageDialog(null, "Your Data have been saved successfully", "Finished Saving",JOptionPane.INFORMATION_MESSAGE);
		    else
			JOptionPane.showMessageDialog(null, "Can't save your data", "Error Saving", JOptionPane.WARNING_MESSAGE);;
	pst.close();   
    }
      //For 
//Show data from database
public ArrayList<Qualification> loaddataQua(){
         ArrayList<Qualification> list=new ArrayList<>();
         try{
             String query="select * from qualification where std_id = (select max(std_id) from student)";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
           
         int qid=rs.getInt("Qid");
         int sid=rs.getInt("Std_id");
         String d=rs.getString("Dname");
         String f=rs.getString("field_name");
	 String o=rs.getString("org_name");
	 String t=rs.getString("type");     
	 Date fd=rs.getDate("from_date");
	 Date td=rs.getDate("to_date");
         

         Qualification qua=new Qualification(qid,sid,d,f,o,t,fd,td);
         list.add(qua);
      
        }
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
         return list;
         
     }
      
//For View Function

     public Qualification returnAllDataToTextfieldQua(int sqid){
         Qualification qua=null;
         try{
             String query="select* from Qualification where std_id="+sqid;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int sid=rs.getInt("qid");
         String d=rs.getString("dname"); 
         String f=rs.getString("field_name");
	 String o=rs.getString("org_name");
	 String t=rs.getString("type");     
	 Date fd=rs.getDate("from_date");
	 Date td=rs.getDate("to_date"); 
         

         qua=new Qualification(sqid,sid,d,f,o,t,fd,td);
     
        }
         }catch(Exception e){
         JOptionPane.showMessageDialog(null, ""+e);
         }
         return qua;
         }
     
     //For Update Function   

 public void updateDataQua(Qualification a){
        try{
             
               
            String query="Update Qualification set Dname=?,Field_name=?,Org_name=?,Type=?,From_date=?,To_date=? where std_id=?";
            PreparedStatement pst=con.prepareStatement(query);
           
        pst.setString(1,a.getDip_name());
        pst.setString(2,a.getField_name());
	pst.setString(3,a.getOrg_name());
	pst.setString(4,a.getType());
        pst.setDate(5,a.getFrom_date());
	pst.setDate(6,a.getTo_date());
        pst.setInt(7, a.getStd_id());
        
            if(pst.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
            }
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, ""+e);
 }
}
 
        public ArrayList<Qualification> loadUpdatedataQua(int qsid){
         ArrayList<Qualification> list=new ArrayList<>();
         try{
             String query="select * from qualification where std_id="+qsid;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
           
         int qid=rs.getInt("Qid");
         String d=rs.getString("Dname");
         String f=rs.getString("field_name");
	 String o=rs.getString("org_name");
	 String t=rs.getString("type");     
	 Date fd=rs.getDate("from_date");
	 Date td=rs.getDate("to_date");
         

         Qualification qua=new Qualification(qid,qsid,d,f,o,t,fd,td);
         list.add(qua);
      
        }
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
         return list;
         
     }
}
