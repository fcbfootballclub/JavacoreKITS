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

/**
 *
 * @author Kien-PC
 */
public class Bai2_2 {

    public static void main(String[] agrs) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        TreeMap<Order, ArrayList<OrderDetail>> tm1 = new TreeMap<>();
        TreeMap<Order, ArrayList<OrderDetail>> tm2 = new TreeMap<>();
        OrderDetail orDetail1 = new OrderDetail(1, 1, 1, 10, 100F);
        OrderDetail orDetail2 = new OrderDetail(1, 2, 5, 7, 40F);
        OrderDetail orDetail3 = new OrderDetail(2, 3, 3, 10, 100F);
        OrderDetail orDetail4 = new OrderDetail(2, 4, 7, 7, 30F);
        OrderDetail orDetail5 = new OrderDetail(3, 5, 2, 1, 20F);
        OrderDetail orDetail6 = new OrderDetail(3, 6, 6, 3, 150F);
        OrderDetail orDetail7 = new OrderDetail(4, 7, 8, 5, 15F);
        OrderDetail orDetail8 = new OrderDetail(4, 8, 9, 7, 25F);
        ArrayList<OrderDetail> list1 = new ArrayList<>();
        ArrayList<OrderDetail> list2 = new ArrayList<>();
        ArrayList<OrderDetail> list3 = new ArrayList<>();
        ArrayList<OrderDetail> list4 = new ArrayList<>();
        Order or1 = new Order(1, dateFormat.parse("2022-08-06"), "Cus01");
        Order or2 = new Order(2, dateFormat.parse("2022-08-06"), "Cus01");
        Order or3 = new Order(3, dateFormat.parse("2022-08-06"), "Cus02");
        Order or4 = new Order(4, dateFormat.parse("2022-08-06"), "Cus02");
        list1.add(orDetail1);
        list1.add(orDetail2);
        list2.add(orDetail3);
        list2.add(orDetail4);
        list3.add(orDetail5);
        list3.add(orDetail6);
        list4.add(orDetail7);
        list4.add(orDetail8);
        tm1.put(or1, list1);
        tm1.put(or2, list2);
        tm2.put(or3, list3);
        tm2.put(or4, list4);
        Customer cus1 = new Customer("Cus01", "Vu Trung Kien", "Ha Noi", "03123");
        Customer cus2 = new Customer("Cus02", "Nguyen Van Khanh", "Ha Nam", "01236");
        HashMap<Customer, TreeMap<Order, ArrayList<OrderDetail>>> hm1 = new HashMap<>();

        hm1.put(cus1, tm1);
        hm1.put(cus2, tm2);
        Customer cusKey = new Customer("Cus01", "", "", "");
        boolean ktCo = false;

        for (Map.Entry<Customer, TreeMap<Order, ArrayList<OrderDetail>>> ss : hm1.entrySet()) {
            if (cusKey.IdCus.equals(ss.getKey().IdCus)) {
                ktCo = true;
                TreeMap<Order, ArrayList<OrderDetail>> k = ss.getValue();
                for (Map.Entry<Order, ArrayList<OrderDetail>> i : k.entrySet()) {
                    System.out.println(i.getKey());
                }
            }
        }
        if (ktCo) {
            System.out.println("Found Order");

        } else {
            System.out.println("Not found Order");
        }
        System.out.println("---------------->");
        float tongTien = 0;
        float tongTienMax = 0;
        Customer d = new Customer("", "", "", "");
        for (Map.Entry<Customer, TreeMap<Order, ArrayList<OrderDetail>>> ss : hm1.entrySet()) {
            TreeMap<Order, ArrayList<OrderDetail>> k = ss.getValue();
            for (Map.Entry<Order, ArrayList<OrderDetail>> i : k.entrySet()) {
                for (int j = 0; j < i.getValue().size(); j++) {
                    tongTien += i.getValue().get(j).Price;
                }
            }
            if (tongTien > tongTienMax) {
                tongTienMax = tongTien;
                d = ss.getKey();
            }
            tongTien = 0;
        }
        System.out.println(d);
        System.out.println("Tong thanh toan: " + tongTienMax);

    }
}
