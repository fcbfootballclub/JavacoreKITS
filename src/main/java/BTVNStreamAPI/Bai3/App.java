package BTVNStreamAPI.Bai3;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class App {
    static BuyQueue buyQueue = new BuyQueue();
    static SellQueue sellQueue = new SellQueue();

    static int sumGiaoDich = 0;
    static int countGiaoDich  = 0;

    public static void main(String[] args) {
        //tạo users
        Trader trader1 = new Trader(1, "Henry1");
        Trader trader2 = new Trader(2, "AHenry1");
        Trader trader3 = new Trader(3, "BHenry1");
        Trader trader4 = new Trader(4, "CHenry1");
        Trader trader5 = new Trader(5, "ZHenry1");
        List<Trader> traderList = new ArrayList<>();

        //tạo cổ phiếu
        Stock VCB = new Stock("VCB", "Vietcombank");
        Stock VIN = new Stock("VIN", "Vinfast");
        Stock TCB = new Stock("TCB", "Techcombank");
        Stock APP = new Stock("APP", "Apple");
        Stock SSG = new Stock("SSG", "Samsung");
        Stock BIDV = new Stock("BIDV", "BIDV");
        List<Stock> stockList = new ArrayList<>();

        //Tạo yêu cầu bán cổ phiếu
        SellRequest sellRequest1 = new SellRequest(1, trader1, VCB,100);
        SellRequest sellRequest2 = new SellRequest(2, trader3, VCB,90);
        SellRequest sellRequest3 = new SellRequest(3, trader2, VIN,110);
        SellRequest sellRequest4 = new SellRequest(4, trader4, VCB,80);
        sellQueue.sellRequestQueue.add(sellRequest1);
        sellQueue.sellRequestQueue.add(sellRequest2);
        sellQueue.sellRequestQueue.add(sellRequest3);
        sellQueue.sellRequestQueue.add(sellRequest4);
        sellQueue.sellRequestQueue.forEach(System.out::println);
        System.out.println("---------");


        //Tạo yêu cầu buy request
        BuyRequest buyRequest1 = new BuyRequest(1, trader4, VCB, 100);
        BuyRequest buyRequest2 = new BuyRequest(2, trader4, VCB, 80);
        buyQueue.buyRequestQueue.add(buyRequest1);
        buyQueue.buyRequestQueue.add(buyRequest2);
        buyQueue.getAllBuyRequestByStockID(new Stock("VCB", "Vietcombank"));
        buyQueue.list.forEach(System.out::println);
        System.out.println("--------");

        System.out.println("Peek: " + buyQueue.list.peek());
        buyQueue.list.poll();
        System.out.println("--------");




    }

    static void khopLenh(Queue<BuyQueue> list1, Queue<SellQueue> list2){
        for(BuyQueue x : list1){
            if(list1.)
        }
    }
}
