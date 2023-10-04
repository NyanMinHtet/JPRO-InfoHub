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
public class Qualification {
    public int Qid;
    public int Std_id;
      String dip_name;
     String field_name;
     String org_name;
     String type;
    Date from_date;
     Date to_date;
    
    public Qualification(){}
    
    public Qualification(int qid,int sid,String d,String f,String o,String t,Date fd,Date td){
    Qid=qid;
    Std_id=sid;
    dip_name=d;
    field_name=f;
    org_name=o;
    type=t;
    from_date=fd;
    to_date=td;
    }

    public int getQid() {
        return Qid;
    }

    public void setQid(int Qid) {
        this.Qid = Qid;
    }

    public int getStd_id() {
        return Std_id;
    }

    public void setStd_id(int Std_id) {
        this.Std_id = Std_id;
    }

    public String getDip_name() {
        return dip_name;
    }

    public void setDip_name(String dip_name) {
        this.dip_name = dip_name;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }
    
    
}
