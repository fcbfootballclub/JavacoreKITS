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
public class Bai2_3 {

    public static void main(String[] agrs) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        TreeMap<Purchase, ArrayList<PurchaseDetail>> tmPur1 = new TreeMap<>();
        TreeMap<Purchase, ArrayList<PurchaseDetail>> tmPur2 = new TreeMap<>();
        PurchaseDetail purDetail1 = new PurchaseDetail(1, 1, 1, 10, 100F);
        PurchaseDetail purDetail2 = new PurchaseDetail(1, 2, 5, 7, 40F);
        PurchaseDetail purDetail3 = new PurchaseDetail(2, 3, 3, 10, 90F);
        PurchaseDetail purDetail4 = new PurchaseDetail(2, 4, 7, 7, 30F);
        PurchaseDetail purDetail5 = new PurchaseDetail(3, 5, 2, 1, 20F);
        PurchaseDetail purDetail6 = new PurchaseDetail(3, 6, 6, 3, 170F);
        PurchaseDetail purDetail7 = new PurchaseDetail(4, 7, 8, 5, 15F);
        PurchaseDetail purDetail8 = new PurchaseDetail(4, 8, 9, 7, 125F);
        ArrayList<PurchaseDetail> list1 = new ArrayList<>();
        ArrayList<PurchaseDetail> list2 = new ArrayList<>();
        ArrayList<PurchaseDetail> list3 = new ArrayList<>();
        ArrayList<PurchaseDetail> list4 = new ArrayList<>();
        Purchase pur1 = new Purchase(1, dateFormat.parse("2022-06-06"), "Sup1");
        Purchase pur2 = new Purchase(2, dateFormat.parse("2022-06-06"), "Sup1");
        Purchase pur3 = new Purchase(3, dateFormat.parse("2022-06-06"), "Sup2");
        Purchase pur4 = new Purchase(4, dateFormat.parse("2022-06-06"), "Sup2");
        list1.add(purDetail1);
        list1.add(purDetail2);
        list2.add(purDetail3);
        list2.add(purDetail4);
        list3.add(purDetail5);
        list3.add(purDetail6);
        list4.add(purDetail7);
        list4.add(purDetail8);
        tmPur1.put(pur1, list1);
        tmPur1.put(pur2, list2);
        tmPur2.put(pur3, list3);
        tmPur2.put(pur4, list4);
        Supplier sup1 = new Supplier("Sup1", "LUVINA", "Cau Giay", "0123456");
        Supplier sup2 = new Supplier("Sup2", "DH Thuy Loi", "Dong Da", "0987654");
        HashMap<Supplier, TreeMap<Purchase, ArrayList<PurchaseDetail>>> hmSup = new HashMap<>();
        hmSup.put(sup1, tmPur1);
        hmSup.put(sup2, tmPur2);
        Supplier supKey = new Supplier("Sup1", "", "", "");
        boolean kt = false;  
        for (Map.Entry<Supplier, TreeMap<Purchase, ArrayList<PurchaseDetail>>> hmS : hmSup.entrySet()) {
            if (supKey.IdSup.equals(hmS.getKey().IdSup)) {
                kt = true;
                TreeMap<Purchase, ArrayList<PurchaseDetail>> k = hmS.getValue();
                for (Map.Entry<Purchase, ArrayList<PurchaseDetail>> i : k.entrySet()) {
                    System.out.println(i.getKey());
                }
            }
        }
        if (kt) {
            System.out.println("Found Order");

        } else {
            System.out.println("Not found Order");
        }
        System.out.println("---------------->");
        float tongTien = 0;
        float tongTienMax = 0;
        Supplier d = new Supplier("", "", "", "");
        for (Map.Entry<Supplier, TreeMap<Purchase, ArrayList<PurchaseDetail>>> hmS : hmSup.entrySet()) {
            TreeMap<Purchase, ArrayList<PurchaseDetail>> k = hmS.getValue();
            for (Map.Entry<Purchase, ArrayList<PurchaseDetail>> i : k.entrySet()) {
                for (int j = 0; j < i.getValue().size(); j++) {
                    tongTien += i.getValue().get(j).Price;
                }
            }
            if (tongTien > tongTienMax) {
                tongTienMax = tongTien;
                d = hmS.getKey();
            }
            tongTien = 0;
        }
        System.out.println(d);
        System.out.println("Tong thanh toan: " + tongTienMax);

    }

}
