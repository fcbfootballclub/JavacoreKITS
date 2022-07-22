/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTVNStreamAPI.stockEx;

/**
 *
 * @author Admin
 */
public class Order implements Comparable<Order>{
    private Integer orderID;
    private Integer type;// 1-- mua, 2-- bán
    private String sIDStock;// 
    private String sIDTrader;//
    private Integer amount;//
    private Float price;//

    public Order(Integer orderID, Integer type, String sIDStock, String sIDTrader, Integer amount, Float price) {
        this.orderID = orderID;
        this.type = type;
        this.sIDStock = sIDStock;
        this.sIDTrader = sIDTrader;
        this.amount = amount;
        this.price = price;

    }

    public Order() {
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getsIDStock() {
        return sIDStock;
    }

    public void setsIDStock(String sIDStock) {
        this.sIDStock = sIDStock;
    }

    public String getsIDTrader() {
        return sIDTrader;
    }

    public void setsIDTrader(String sIDTrader) {
        this.sIDTrader = sIDTrader;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", type=" + type +
                ", sIDStock='" + sIDStock + '\'' +
                ", sIDTrader='" + sIDTrader + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return (int) (this.price - o.getPrice());
    }
}
