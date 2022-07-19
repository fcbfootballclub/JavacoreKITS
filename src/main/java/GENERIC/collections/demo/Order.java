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
public class Order implements Comparable<Order>{
    Integer IdOrder;
    Date OrdDate;
    String CustomerID;
    public Order (Integer IdOrder ,Date OrdDate, String CustomerID){
        this.IdOrder=IdOrder;
        this.OrdDate=OrdDate;
        this.CustomerID=CustomerID;
    }
    public Integer getIdOrder(){
        return IdOrder;
    }
    public void setIdOrder(Integer IdOrder){
        this.IdOrder=IdOrder;
    }
    public Date getOrdDate(){
        return OrdDate;
    }
    public void setOrdDate(Date OrdDate){
        this.OrdDate=OrdDate;
    }
    public String getCustomerID(){
        return CustomerID;
    }
    public void setCustomerID(String CustomerID){
        this.CustomerID=CustomerID;
    }
    @Override
    public String toString(){
        DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        return "Order: "+
                "IdOrder= "+IdOrder+
                ",OrdDate= "+dateFormat.format(OrdDate)+
                ",CustomerID= "+CustomerID+' ';
    }
    @Override
    public int compareTo(Order another){
        return this.getIdOrder().compareTo(another.getIdOrder());
    }
}
