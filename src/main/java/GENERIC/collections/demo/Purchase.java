/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections.demo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Kien-PC
 */
import java.util.Date;
public class Purchase implements Comparable<Purchase>{
    Integer IdPurchase;
    Date purDate;
    String SupplierID;
    public Purchase (Integer IdPurchase ,Date purDate, String SupplierID){
        this.IdPurchase=IdPurchase;
        this.purDate=purDate;
        this.SupplierID=SupplierID;
    }
    public Integer getIdPurchase(){
        return IdPurchase;
    }
    public void setIdPurchase(Integer IdPurchase){
        this.IdPurchase=IdPurchase;
    }
    public Date getpurDate(){
        return purDate;
    }
    public void setpurDate(Date purDate){
        this.purDate=purDate;
    }
    public String getSupplierID(){
        return SupplierID;
    }
    public void setSupplierID(String SupplierID){
        this.SupplierID=SupplierID;
    }
    @Override
    public String toString(){
        DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        return "Purchase: "+
                "IdPurchase= "+IdPurchase+'\''+
                ",purDate= "+dateFormat.format(purDate)+
                ",SupplierID= "+SupplierID+' ';
    }
    @Override
    public int compareTo(Purchase another){
        return 0;
    }
}
