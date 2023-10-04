/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subject;

/**
 *
 * @author MSI
 */
public class Subject_Class {
      int sub_id;
     String subname;
     String coursename;
     String refbook;
     String desc_book;
     String sub_no;
    public Subject_Class(){

}
       public Subject_Class(int sid,String coname,String subn,String refb,String descb,String sno){
       sub_id=sid;
       coursename=coname;
       subname=subn;
       refbook=refb;
       desc_book=descb;
       sub_no=sno;
       }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getRefbook() {
        return refbook;
    }

    public void setRefbook(String refbook) {
        this.refbook = refbook;
    }

    public String getDesc_book() {
        return desc_book;
    }

    public void setDesc_book(String desc_book) {
        this.desc_book = desc_book;
    }

    public String getSub_no() {
        return sub_no;
    }

    public void setSub_no(String sub_no) {
        this.sub_no = sub_no;
    }

}
