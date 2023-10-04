/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Course;

/**
 *
 * @author MSI
 */
public class Course_Class {
    int cid;
    String cno;
    String cname;
    String cdesc;
    String du;
    int fees;
         public Course_Class(){
         }
         public Course_Class(int cid,String cno,String cname,String cdesc,String du,int fees){
             this.cid=cid;
             this.cno=cno;
             this.cname=cname;
             this.cdesc=cdesc;
             this.du=du;
             this.fees=fees;
}

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
         
}
