/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class PayData {
    
    int payID;
    int bmID;
    Date payDate;
    String amount;
    String discount;
    String paymethod;
    String personInfo;
    String desc;
    String remark;

    public PayData(){}
    
    public PayData(int pid, int baId, Date pDate, String amt, String dis, String pmethod, String pInfo, String d, String r){
        payID = pid;
        bmID = baId;
        payDate = pDate;
        amount = amt;
        discount = dis;
        paymethod = pmethod;
        personInfo = pInfo;
        desc = d;
        remark = r;
    }
    
    public int getPayID() {
        return payID;
    }

    public void setPayID(int payID) {
        this.payID = payID;
    }

    public int getbmID() {
        return bmID;
    }

    public void setbmID(int bID) {
        this.bmID = bID;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
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

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public String getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(String personInfo) {
        this.personInfo = personInfo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    
}
