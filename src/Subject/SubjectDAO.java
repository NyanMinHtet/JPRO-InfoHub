    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subject;

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
public class SubjectDAO {
    private Connection con;
    public  SubjectDAO(){
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
		}
		catch(Exception e){
			e.printStackTrace();
                }
    }
        public void insert_subject(Subject_Class scc) {
    try {
        PreparedStatement pst = con.prepareStatement("select Course_id from Course where Course_name=?");
        pst.setString(1, scc.getCoursename());
        ResultSet rs = pst.executeQuery();

        int courseId = 0;
        if (rs.next()) {
            courseId = rs.getInt("Course_id");

            pst = con.prepareStatement("insert into subject(course_id,subject_name,ref_book,desc_book,sub_no) values(?,?,?,?,?)");
            pst.setInt(1, courseId);
            pst.setString(2, scc.getSubname());
            pst.setString(3, scc.getRefbook());
            pst.setString(4, scc.getDesc_book());
            pst.setString(5, scc.getSub_no());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "" + e);
    }
}

        
        public String getCoName(int cid) throws SQLException{
            PreparedStatement pst = con.prepareStatement("select Course_name from Course where Course_id = ?");
            pst.setInt(1,cid);
            ResultSet rs = pst.executeQuery();
            
            String name = null;
		while(rs.next())
			name = rs.getString(1);
                return name;
        }
        
        public Subject_Class returnAllDataTosubjectTextfield(int id){
         Subject_Class scc=null;
         try{
             String query="select* from subject where subid="+id;
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int ids=rs.getInt("subid");
            int conid=rs.getInt("course_id");
            String subname=rs.getString("subject_name");
            String refbook=rs.getString("ref_book");
            String descbook=rs.getString("desc_book");
            String subno=rs.getString("sub_no");
            
            scc=new Subject_Class(ids,getCoName(conid),subname,refbook,descbook,subno);
     
        }
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null, ""+e);
         }
         return scc;
         }

       
       
           public ArrayList<Subject_Class> loadSubjectdata(){
         ArrayList<Subject_Class> listsub=new ArrayList<>();
         try{
             String query="select* from subject";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int ids=rs.getInt("subid");
            int conid=rs.getInt("course_id");
            String subname=rs.getString("subject_name");
            String refbook=rs.getString("ref_book");
            String descbook=rs.getString("desc_book");
            String subno=rs.getString("sub_no");
            
            Subject_Class scc=new Subject_Class(ids,getCoName(conid),subname,refbook,descbook,subno);
            listsub.add(scc);
      
        }
         }catch(Exception e) {
             JOptionPane.showMessageDialog(null, ""+e);
         }
         return listsub;
         
     }
            public void updateSubject_Data(Subject_Class scc){
        try{
            PreparedStatement pst = con.prepareStatement("select Course_id from Course where Course_name=?");
        pst.setString(1, scc.getCoursename());
        ResultSet rs = pst.executeQuery();

        int id = 0;
        while (rs.next()) 
            id = rs.getInt("Course_id");
             
            String query=  "Update subject set course_id=?,subject_name=?,ref_book=?,desc_book=?,sub_no=? where subid=?";
            pst=con.prepareStatement(query);
            
            pst.setInt(1, id);
            pst.setString(2, scc.getSubname());
            pst.setString(3, scc.getRefbook());
            pst.setString(4, scc.getDesc_book());
            pst.setString(5, scc.getSub_no()); 
            pst.setInt(6, scc.getSub_id());
            pst.executeUpdate();
            if(pst.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Your Data Successfully Updated");
            }     
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, ""+e);
        }
        
     }
              public boolean isSubjectNoExist(String sno){
    
          try {
              PreparedStatement pst=con.prepareStatement("select * from subject where sub_no=?");
              pst.setString(1, sno);
              ResultSet rs=pst.executeQuery();
              if(rs.next()){
                  return true;
              }

          } catch (SQLException ex) {
              Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
              return false;
         }
              
            public int getSubjectId (String name) throws SQLException {
            PreparedStatement pst = con.prepareStatement("select subid from subject where subject_name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            int sid = 0;
            while(rs.next())
                sid = rs.getInt(1);
            return sid;
      }

        
}
   
    

