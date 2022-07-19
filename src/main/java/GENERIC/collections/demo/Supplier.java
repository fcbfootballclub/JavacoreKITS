/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections.demo;

/**
 *
 * @author Kien-PC
 */
public class Supplier implements Comparable<Supplier>{
    String IdSup;
    String Name;
    String Address;
    String Tel;
    public Supplier(String IdSup,String Name,String Address,String Tel){
        this.IdSup=IdSup;
        this.Name=Name;
        this.Address=Address;
        this.Tel=Tel;
    }
    public String getIdSup(){
        return IdSup;
    }
    public void setIdSup(String IdSup){
        this.IdSup=IdSup;
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
        return "Supplier:"+
                ",IdSup= "+IdSup+'\''+
                ",Name= "+Name+'\''+
                ",Address= "+Address+
                ",Tel= "+Tel+
                ' ';
    }
    
    @Override
    public int compareTo(Supplier another){
        return 0;
    }
}
