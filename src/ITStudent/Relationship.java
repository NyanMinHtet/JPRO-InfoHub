/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ITStudent;

/**
 *
 * @author Thet Mhue Aung
 */
public class Relationship {
    
     private int rid;
    private  int std_id;
    private String name;
    private String phno;
    private String occupation;
    private String rs_type;
    
    public Relationship(){}
    
    public Relationship(int Rid, int Sid, String n, String pno,String occup, String rsType ){
        rid = Rid;
        std_id = Sid;
        name = n;
        phno = pno;
        occupation = occup;
        rs_type = rsType;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRs_type() {
        return rs_type;
    }

    public void setRs_type(String rs_type) {
        this.rs_type = rs_type;
    }
    
}
