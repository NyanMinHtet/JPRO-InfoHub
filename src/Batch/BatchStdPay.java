/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batch;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class BatchStdPay {
    
    public int bm_id;
    public String name;
    public Date dob;
    public String email;
    public String phno;
    public String teleno;
    public String amount;
    public String discount;
    
    public BatchStdPay(){}
    
    public BatchStdPay(int id, String n, Date d, String e, String pno, String tele, String amt, String dis){
        bm_id = id;
        name = n;
        dob = d;
        email = e;
        phno = pno;
        teleno = tele;
        amount = amt;
        discount = dis;
    }

    public int getBm_id() {
        return bm_id;
    }

    public void setBm_id(int bm_id) {
        this.bm_id = bm_id;
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

    public String getTeleno() {
        return teleno;
    }

    public void setTeleno(String teleno) {
        this.teleno = teleno;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

   
}
