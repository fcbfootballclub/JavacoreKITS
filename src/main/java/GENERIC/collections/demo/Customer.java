/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections.demo;

/**
 *
 * @author Kien-PC
 */
public class Customer implements Comparable<Customer>{
    String IdCus;
    String Name;
    String Address;
    String Tel;
    public Customer(String IdCus,String Name,String Address,String Tel){
        this.IdCus=IdCus;
        this.Name=Name;
        this.Address=Address;
        this.Tel=Tel;
    }
    public String getIdCus(){
        return IdCus;
    }
    public void setIdCus(String IdCus){
        this.IdCus=IdCus;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getAddress(){
        return Address;
    }
    public void setAddress(String Address){
        this.Address=Address;
    }
    public String getTel(){
        return Tel;
    }
    public void setTel(String Tel){
        this.Tel=Tel;
    }
        @Override
    public String toString(){
        return "Customer: {"+
                ",IdSup= "+IdCus+'\''+
                ",Name= "+Name+'\''+
                ",Address= "+Address+
                ",Tel= "+Tel+
                '}';
    }
    
    @Override
    public int compareTo(Customer another){
        return this.getIdCus().compareTo(another.getIdCus());
    }
}
