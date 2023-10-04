/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batch;

import Teacher.Teacher_Class;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class BatchTeacherModel extends AbstractTableModel{
     private String title[] = {"Teacher_ID","Teacher_Name","DOB","Ph_No","Edu_Back"};
    private ArrayList<Teacher_Class> teacher = new ArrayList<Teacher_Class>();
    
    public BatchTeacherModel(ArrayList<Teacher_Class> t){
       teacher = t;
   }

     //to show column name
	public String getColumnName(int col){
		return title[col];
	}
    
    @Override
    public int getRowCount() {
        return teacher.size();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
        return title.length;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int row, int col) {
        Teacher_Class t = teacher.get(row);
          
          switch(col){
//              case 0: return row+1;
              case 0: return t.getTid();
              case 1: return t.getName();
              case 2: return t.getDoB();
	      case 3: return t.getPhno();
	      case 4: return t.getEduback();
          }
          return null;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
