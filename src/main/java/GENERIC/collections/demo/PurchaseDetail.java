/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections.demo;

/**
 *
 * @author Kien-PC
 */
public class PurchaseDetail implements Comparable<PurchaseDetail>{    
    Integer IdPurchase;
    Integer IdDetail;
    Integer IdItem;
    Integer Amount;
    Float Price;
    public PurchaseDetail(Integer IdPurchase,Integer IdDetail,Integer IdItem,Integer Amount,Float Price){
        this.IdPurchase=IdPurchase;
        this.IdDetail=IdDetail;
        this.IdItem=IdItem;
        this.Amount=Amount;
        this.Price=Price;
    }
    public Integer getIdPurchase(){
    return IdPurchase;
    }
    public void setIdOrder(Integer IdPurchase){
        this.IdPurchase=IdPurchase;
    }
    public Integer getIdDetail(){
        return IdDetail;
    }
    public void setIdDetail(Integer IdDetail){
        this.IdDetail=IdDetail;
    }
    public Integer getIdItem(){
        return IdItem;
    }
    public void setIdItem(Integer IdItem){
        this.IdItem=IdItem;
    }
    public Integer getAmount(){
        return Amount;
    }
    public void setAmount(Integer Amount){
        this.Amount=Amount;
    }
    public Float getPrice(){
        return Price;
    }
    public void setPrice(Float Price){
        this.Price=Price;
    }
    @Override
    public String toString(){
        return "OrderDetail:"+
                ",IdOrder= "+IdPurchase+'\''+
                ",IdDetail= "+IdDetail+'\''+
                ",IdItem= "+IdItem+
                ",IdAmount= "+Amount+
                ",Price= "+Price+' ';
    }
    
    @Override
    public int compareTo(PurchaseDetail another){
        return 0;
    }
}

