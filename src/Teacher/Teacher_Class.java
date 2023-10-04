/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teacher;

import java.sql.Date;

/**
 *
 * @author MSI
 */
 public  class Teacher_Class {
               int tid;
               String Name;
               Date DoB;
               String Phno;
               String Eduback;
  
         


              public Teacher_Class(){
              }
              public Teacher_Class(int id,String n,Date d,String pno,String edu){
              tid=id;
              Name=n;
              DoB=d;
              Phno=pno;
              Eduback=edu;

            
              }

    


    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date DoB) {
        this.DoB = DoB;
    }

    public String getPhno() {
        return Phno;
    }

    public void setPhno(String Phno) {
        this.Phno = Phno;
    }

    public String getEduback() {
        return Eduback;
    }

    public void setEduback(String Eduback) {
        this.Eduback = Eduback;
    }

    
}
