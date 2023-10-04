package AdminLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class userDAO {
	private Connection con;
	 public userDAO(){
                       try{
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jpro_InfoHub","root","root");
        }
        catch(SQLException e){
         e.printStackTrace();
        }
	}
	     int checkUser(String email,String pwd) throws SQLException{
		 int id=0;
		 PreparedStatement pst=con.prepareStatement("select user_id from account where user_name=? and password=?");
		 pst.setString(1, email);
		 pst.setString(2, pwd);
		 ResultSet rs=pst.executeQuery();
		 while(rs.next())
			 id=rs.getInt(1);
		 return id;
	 }
             
//           public user returnAllDataToTextfield(String em){
//         user u=null;
//         try{
//             String query="select* from logindata where email="+em;
//        PreparedStatement pst=con.prepareStatement(query);
//        ResultSet rs=pst.executeQuery();
//        while(rs.next()){
//            int id=rs.getInt("user_id");
////            String em=rs.getString("email");
//            String pwd=rs.getString("password");
//            
//         u=new user(id,em,pwd);
//     
//        }
//         }catch(Exception e){
//         JOptionPane.showMessageDialog(null, ""+e);
//         }
//         return u;
//         }
             public user returnAllDataToTextField(String email) {
    user us = null;
    try {
        String query = "SELECT * FROM account WHERE user_name = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("user_id");
            String password = rs.getString("password");
            us = new user(id, email, password);
        }
        rs.close();
        pst.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "" + e);
    }
    return us;
}

	 
}
