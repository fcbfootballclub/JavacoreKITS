/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections.demo;

import java.util.TreeMap;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.stream.Stream;

/**
 *
 * @author Kien-PC
 */
public class Bai2_1 {

    public static void main(String[] agrs) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        TreeMap<Order, ArrayList<OrderDetail>> tm = new TreeMap<>();
        Order or1 = new Order(11, dateFormat.parse("2022-08-06"), "Cus01");
        Order or2 = new Order(2, dateFormat.parse("2022-08-06"), "Cus02");
        ArrayList<OrderDetail> list = new ArrayList<>();
        ArrayList<OrderDetail> list1 = new ArrayList<>();
        OrderDetail orDetail1 = new OrderDetail(11, 1, 1, 10, 100F);
        OrderDetail orDetail2 = new OrderDetail(11, 2, 5, 7, 40F);
        OrderDetail orDetail3 = new OrderDetail(2, 3, 3, 1110, 100F);
        OrderDetail orDetail4 = new OrderDetail(2, 4, 7, 7, 30F);
        list.add(orDetail1);
        list.add(orDetail2);
        list.add(new OrderDetail(2, 3, 3, 10, 100F));
        list1.add(orDetail3);
        list1.add(orDetail4);
        tm.put(or1, list);
        tm.put(or2, list1); 
        // convert map to stream
        // Tìm hóa đơn có tổng số lượng lớn nhất
        Stream<Map.Entry<Order, ArrayList<OrderDetail>>> str1=tm.entrySet().stream(); 
        Optional<Map.Entry<Order, ArrayList<OrderDetail>>> 
               tt= str1.max((x,y) -> new Integer(x.getValue().stream().mapToInt(x1->x1.getAmount()).sum())
                       .compareTo(new Integer(y.getValue().stream().mapToInt(y1->y1.getAmount()).sum())));
       
        System.out.println(tt);
        
        //Tong Tien
        float max = 0;
        int idx = 0;
        for (Map.Entry<Order, ArrayList<OrderDetail>> lst : tm.entrySet()) {
            float tong = 0;

            for (int i = 0; i < lst.getValue().size(); i++) {
                tong += lst.getValue().get(i).Price;
            }
            if (tong > max) {
                max = tong;
                idx++;
            }

        }
        System.out.println("Hoa don " + idx + " co tong tien lon nhat");
        System.out.println(max);
        System.out.println("---------------->");
        
//Bai2.1.2
        Customer cus1 = new Customer("Cus01", "Vu Trung Kien", "Ha Noi", "03123");
        Customer cus2 = new Customer("Cus02", "Nguyen Van Khanh", "Ha Nam", "01236");
        ArrayList<Order> ord1 = new ArrayList<>();
        ArrayList<Order> ord2 = new ArrayList<>();
        ord1.add(or1);
        ord1.add(new Order(3, dateFormat.parse("2022-08-06"), "Cus01"));
        ord2.add(or2);
        TreeMap<Customer, ArrayList<Order>> tmCus = new TreeMap<>();
        tmCus.put(cus1, ord1);
        tmCus.put(cus2, ord2);
        Customer cusKey0 = new Customer("Cus02", "", "", "");
        boolean ktra1 = tmCus.containsKey(cusKey0);
        if (ktra1) {
            System.out.println("Found Order");
            ArrayList<Order> value = tmCus.get(cusKey0);
            System.out.println(value);
        } else {
            System.out.println("Not found Order");
        }
        System.out.println("---------------->");
        int demMax = 0;
        Customer cuss = new Customer("", "", "", "");
        for (Map.Entry<Customer, ArrayList<Order>> lst1 : tmCus.entrySet()) {
            if (demMax < lst1.getValue().size()) {
                demMax = lst1.getValue().size();
                cuss = lst1.getKey();
            }
        }
        System.out.println(cuss);
        System.out.println("So hoa don mua " + demMax);

        System.out.println("---------------->");
    }
}
