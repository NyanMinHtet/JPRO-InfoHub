/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batch;

/**
 *
 * @author DELL
 */
public class BatchTeacher {
    int btid;
    int batchId;
    int tid;
    int subId;
    
    public BatchTeacher(){}
    
    public BatchTeacher(int id, int bid, int tid, int sid){
        btid = id;
        batchId = bid;
        this.tid = tid;
        subId = sid;
    }

    public int getBtid() {
        return btid;
    }

    public void setBtid(int btid) {
        this.btid = btid;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }
    
    
}
