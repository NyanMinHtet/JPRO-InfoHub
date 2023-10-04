/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batch;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class BatchStdPayModel extends AbstractTableModel {
    private String title[] = {"Member_ID","Std_Name","DOB","Email","Ph_No","Telegram_No","Payment","Discount"};
    private ArrayList<BatchStdPay> bsp = new ArrayList<BatchStdPay>();
    
   public BatchStdPayModel(ArrayList<BatchStdPay> b){
       bsp = b;
   }

   //to show column name
	public String getColumnName(int col){
		return title[col];
	}
	
    @Override
    public int getRowCount() {
        return bsp.size();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
        return title.length;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int row, int col) {
          BatchStdPay spay = bsp.get(row);
          
          switch(col){
//              case 0: return row+1;
              case 0: return spay.getBm_id();
              case 1: return spay.getName();
              case 2: return spay.getDob();
	      case 3: return spay.getEmail();
	      case 4: return spay.getPhno();
              case 5: return spay.getTeleno();
              case 6: return spay.getAmount();
              case 7: return spay.getDiscount();
          }
          return null;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
