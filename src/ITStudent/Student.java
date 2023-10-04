/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ITStudent;
import java.sql.Date;
/**
 *
 * @author Thet Mhue Aung
 */
public class Student {
    
    int  std_id;
    String std_no;
    String name;
    Date dob;
    String email;
    String phno;
    String gender;
    String religion;
    String nrc;
    String nation;
    String tele_no;
    String photo;
    
    public Student(){}
    
    public Student(int id, String no, String name, Date d, String email, String pno, String gender, String reli,  String nation, String tno,String nrc,String poto){
        
        std_id =  id;
        std_no = no;
        this.name = name;
        dob = d;
        this.email = email;
        phno = pno;
        this.gender = gender;
        religion = reli;
        this.nrc = nrc;
        this.nation = nation;
        tele_no = tno;
        photo=poto;
    
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

   

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_no) {
        this.std_id = std_id;
    }

    public String getStd_no() {
        return std_no;
    }

    public void setStd_no(String std_no) {
        this.std_no = std_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getTele_no() {
        return tele_no;
    }

    public void setTele_no(String tele_no) {
        this.tele_no = tele_no;
    }

   // public String getPhoto() {
   //     return photo;
    //}

   // public void setPhoto(String photo) {
   //     this.photo = photo;
   // }

    
}
