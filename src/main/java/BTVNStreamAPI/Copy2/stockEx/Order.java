/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTVNStreamAPI.Copy2.stockEx;

/**
 *
 * @author Admin
 */
public class Order implements Comparable<Order>{
    
      Integer type;// 1-- mua, 2-- bán
      String sIDStock;// 
      String sIDTrader;//
      Integer amount;//
      Float price;//
    Order (Integer type, String sIDStock, Float price) {
        this.type=type;
        this.sIDStock=sIDStock;
        this.price=price;
    }

    @Override
    public int compareTo(Order o) {
      return  this.price.compareTo(o.price);
    }
}
