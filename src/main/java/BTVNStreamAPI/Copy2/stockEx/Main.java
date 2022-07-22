///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package BTVNStreamAPI.Copy2.stockEx;
//
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.PriorityQueue;
//import java.util.Queue;
//class PriceDesc implements Comparator<Order> {
//    @Override
//    public int compare(Order o1, Order o2) {
//        return o2.price.compareTo(o1.price);
//    }
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//        String[] lstStock = {"VIN","SSB", "SHB", "EIB", "MSB", "OCB", "FPT"};
//
//        Map<String, Stock> hm = new HashMap<>();
//        for (String sId : lstStock) {
//            Stock st = new Stock(sId);
//            hm.put(sId, st);
//        }
//
//        Map<String, PriorityQueue<Order>> hm_st_Sellq = new HashMap<>();
//        Map<String, PriorityQueue<Order>> hm_st_Buyq = new HashMap<>();
//
//        for (String sIdStock : hm.keySet()) {
//            hm_st_Sellq.put(sIdStock, new PriorityQueue<>());
//            hm_st_Buyq.put(sIdStock, new PriorityQueue<>(new PriceDesc()));
//        }
//
//        while (true) {
//            // Lệnh mua, bán ngẫu nhiên
//            int iIDStock = (int) Math.round(Math.random() * (lstStock.length - 1));
//            double x = Math.random();
//            Float price = (float) Math.random() * 1000;
//            if (x < 0.5) {
//                Order ord1 = new Order(1, lstStock[iIDStock], price);
//                PriorityQueue<Order> bQ = hm_st_Buyq.get(lstStock[iIDStock]);
//                bQ.add(ord1);
//            } else {
//                Order ord2 = new Order(2, lstStock[iIDStock], price);
//                PriorityQueue<Order> sellQ = hm_st_Sellq.get(lstStock[iIDStock]);
//                sellQ.add(ord2);
//            }
//            // Khớp lệnh
//            Queue sQ = hm_st_Sellq.get(lstStock[iIDStock]);
//            Queue bQ = hm_st_Buyq.get(lstStock[iIDStock]);
//            //Bổ sung vào đây
//            System.out.println("Khớp lệnh"+ lstStock[iIDStock]);
//
//            while(!sQ.isEmpty() && !bQ.isEmpty()) {
////            System.out.println("buy size: " + bQ_FPT.size());
////            System.out.println("sell size: " + sQ_FPT.size());
//                Order buyOrder = bQ.peek();
//                Order sellOrder = sQ.peek();
//                if(buyOrder.getPrice() >= sellOrder.getPrice()) {
//                    Transantion transantion = new Transantion();
//                    transantion.idStock = buyOrder.getsIDStock();
//                    transantion.idBuyer = buyOrder.getsIDTrader();
//                    transantion.idSeller = sellOrder.getsIDTrader();
//                    transantion.price = sellOrder.getPrice();
//                    if(buyOrder.getAmount() < sellOrder.getAmount()){
//                        transantion.amount = buyOrder.getAmount();
//                        //cập nhật lại số lượng của chứng khoán của queue
//                        sellOrder.setAmount(sellOrder.getAmount() - buyOrder.getAmount());
//                        bQ_FPT.poll();
//                    } else if (buyOrder.getAmount() > sellOrder.getAmount()){
//                        transantion.amount = sellOrder.getAmount();
//                        //cập nhật lại số lượng của chứng khoán của queue
//                        buyOrder.setAmount(buyOrder.getAmount() - sellOrder.getAmount());
//                        sQ_FPT.poll();
//                    } else {
//                        transantion.amount = sellOrder.getAmount();
//                        bQ_FPT.poll();
//                        sQ_FPT.poll();
//                    }
//                    transantionList.add(transantion);
//                } else {
//                    break;
//                }
//
//            }
//
//
//        }
//    }
//
//}
