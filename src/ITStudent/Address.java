/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ITStudent;

/**
 *
 * @author Thet Mhue Aung
 */
public class Address {
    
       public int Aid;
    public int Std_id;
    public String region;
    public String city;
    public String town;
    
    public Address(){}
    
    

    public Address(int aid,int sid,String r, String c, String t) {
        Aid = aid;
        Std_id = sid;
        region = r;
        city = c;
        town = t;
    }

    public int getAid() {
        return Aid;
    }

    public void setAid(int Aid) {
        this.Aid = Aid;
    }

    public int getStd_id() {
        return Std_id;
    }

    public void setStd_id(int Std_id) {
        this.Std_id = Std_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
    
}
