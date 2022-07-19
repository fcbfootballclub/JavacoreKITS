package GENERIC.collections.QuanLyHoaDon;

import GENERIC.collections.QuanLyHoaDon.Orders.Order;
import GENERIC.collections.QuanLyHoaDon.Orders.OrderDetail;

import java.text.ParseException;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        //Tao khách hàng
        Customer customer1 = new Customer("CS01", "Henry1", "HN", "123");
        Customer customer2 = new Customer("CS02", "Henry2", "HN", "124");
        Customer customer3 = new Customer("CS03", "Henry3", "HN", "125");
        Customer customer4 = new Customer("CS04", "Henry4", "HN", "126");

        //Tạo nhà cung cấp
        Supplier supplier1 = new Supplier(1, "Supplier1", "Saigon", "121");
        Supplier supplier2 = new Supplier(2, "Supplier2", "Saigon", "122");
        Supplier supplier3 = new Supplier(3, "Supplier3", "Saigon", "123");
        Supplier supplier4 = new Supplier(4, "Supplier4", "Saigon", "124");

        //Tạo Order
        Order order1;
        Order order2;
        Order order3;
        try {
            order1 = new Order(1, "15-07-2022", "CS01");
            order2 = new Order(2, "14-07-2022", "CS02");
            order3 = new Order(3, "16-07-2022", "CS02");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //Tạo order chi tiết
        OrderDetail orderDetail1 = new OrderDetail(1, 1, 1, 2, 20);
        OrderDetail orderDetail2 = new OrderDetail(1, 2, 3, 1, 40);
        OrderDetail orderDetail3 = new OrderDetail(2, 3, 2, 3, 30);
        OrderDetail orderDetail4 = new OrderDetail(3, 4, 1, 1, 20);
        OrderDetail orderDetail5 = new OrderDetail(3, 5, 2, 1, 30);


        //Bai 1. Tao TreeMap <Order, ArrayList>
        TreeMap<Order, ArrayList<OrderDetail>> OrderList = new TreeMap<>();

        //Key value cua order1
        List<OrderDetail> orderDetailList1 = new ArrayList<>();
        orderDetailList1.add(orderDetail1);
        orderDetailList1.add(orderDetail2);
        OrderList.put(order1, (ArrayList<OrderDetail>) orderDetailList1);

        //Key value cua order2
        List<OrderDetail> orderDetailList2 = new ArrayList<>();
        orderDetailList2.add(orderDetail3);
        OrderList.put(order2, (ArrayList<OrderDetail>) orderDetailList2);

        //Key value cua order3
        List<OrderDetail> orderDetailList3 = new ArrayList<>();
        orderDetailList3.add(orderDetail4);
        orderDetailList3.add(orderDetail5);
        OrderList.put(order3, (ArrayList<OrderDetail>) orderDetailList3);

        for(Order x : OrderList.keySet()){
            System.out.println(x.toString() + ". Value: " + OrderList.get(x));
        }

        //Tim kiem hoa don theo ma hoa don
        int searchIDOrder = 1;
        for(Order x : OrderList.keySet()){
            int sumMoney = 0;
            int sumItem = 0;
            if(x.getIdOrder() == 1){
                for(OrderDetail detail : OrderList.get(x)){
                    sumItem += detail.getAmount();
                    sumMoney += detail.getAmount() * detail.getPrice();
                }
                System.out.println("Hoa don 1 chi tiet mua: " + sumItem + ". Tong so tien:" + sumMoney);
                break;
            }
        }

        //Tìm hóa đơn có tổng số lượng lớn nhất và hóa đơn có total value lớn nhất
        int maxQuantityOrder = 0;
        Map<Integer, Integer> maxQuantityOrderID = new HashMap<>(); //lưu những order có quantity lớn nhất vào đây
        int maxTotalOrderValue = 0;
        Map<Integer, Integer> maxTotalValueOrderID = new HashMap<>(); //Lưu những order có giá trị lớn nhất vào đây

        int sumQuantity;
        int totalValue;
        for(Order x : OrderList.keySet()){
            sumQuantity = 0;
            totalValue = 0;
            for(OrderDetail a : OrderList.get(x)){
                sumQuantity += a.getAmount();
                totalValue += a.getAmount() * a.getPrice();
            }

            //check số lượng item nhiều nhất và gắn vào dãy
            if(sumQuantity == maxQuantityOrder){
                maxQuantityOrderID.put(x.getIdOrder(), maxQuantityOrder);
            } else if (sumQuantity > maxQuantityOrder) {
                maxQuantityOrder = sumQuantity;
                maxQuantityOrderID.clear();
                maxQuantityOrderID.put(x.getIdOrder(), maxQuantityOrder);
            }

            //check value to nhất vào gắn vào list
            if(totalValue == maxTotalOrderValue){
                maxTotalValueOrderID.put(x.getIdOrder(), maxTotalOrderValue);
            } else if (totalValue > maxTotalOrderValue) {
                maxTotalValueOrderID.clear();
                maxTotalOrderValue = totalValue;
                maxTotalValueOrderID.put(x.getIdOrder(), maxTotalOrderValue);
            }

        }

        //in ra kết quả
        System.out.println("Những order có số lượng item lớn nhất là: ");
        for(Integer x : maxQuantityOrderID.keySet()){
            System.out.println("Order ID: " + x + ". Quantity: " + maxQuantityOrderID.get(x));
        }

        System.out.println("Những order có số lượng total Value lớn nhất là: ");
        for(Integer x : maxTotalValueOrderID.keySet()){
            System.out.println("Order ID: " + x + ". Quantity: " + maxTotalValueOrderID.get(x));
        }
    }
}
