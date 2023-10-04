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
public class BatchMember {
    
    public int bmId;
    public int batchId;
    int std_id;
    Date joind;
 
    public BatchMember(){
    }
    public BatchMember(int bmID,int bid, int sid, Date d){
        bmId = bmID;
        batchId = bid;
        std_id= sid;
        joind = d;
       
    }

    public int getBmId() {
        return bmId;
    }

    public void setBmId(int bmId) {
        this.bmId = bmId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public Date getJoind() {
        return joind;
    }

    public void setJoind(Date joind) {
        this.joind = joind;
    }

    
    
}
