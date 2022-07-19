package GENERIC.collections.QuanLyHoaDon.Orders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Comparable<Order>{
    private int IdOrder;
    private Date OrdDate;// ngày hoá đơn
    private String CustomerID; // mã khách hàng

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");

    public Order(int idOrder, String ordDate, String customerID) throws ParseException {
        IdOrder = idOrder;
        OrdDate = simpleDateFormat.parse(ordDate);
        CustomerID = customerID;
    }

    public Order() {
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public Date getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(Date ordDate) {
        OrdDate = ordDate;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "IdOrder=" + IdOrder +
                ", OrdDate=" + simpleDateFormat.format(getOrdDate()) +
                ", CustomerID='" + CustomerID + '\'' +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return this.IdOrder - o.IdOrder;
    }
}
