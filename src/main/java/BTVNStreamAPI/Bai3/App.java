package BTVNStreamAPI.Bai3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class App implements Runnable{
    static HashMap<Stock, BuyQueue> buyQueueHashMap = new HashMap<>();
    static HashMap<Stock, SellQueue> sellQueueHashMap = new HashMap<>();

    List<Thread> xuLyGiaoDich = new ArrayList<>(10);


    static int sumGiaoDich = 0;
    static int countGiaoDich  = 0;

    public static void main(String[] args) {
        App app1 = new App();
        Thread thread1 = new Thread(app1);
        thread1.start();

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

        //Tạo yêu cầu bán chứng khoán
        SellRequest sellRequest1 = new SellRequest(1, trader1, VCB,100);
        SellRequest sellRequest2 = new SellRequest(2, trader3, VCB,90);
        SellRequest sellRequest3 = new SellRequest(3, trader2, VCB,110);
        SellRequest sellRequest4 = new SellRequest(4, trader4, VCB,80);
        SellQueue sellQueueVCB = new SellQueue(); //tạo object chứa queue lưu lại sell request của VCB
        sellQueueVCB.sellRequestQueue.add(sellRequest1);
        sellQueueVCB.sellRequestQueue.add(sellRequest2);
        sellQueueVCB.sellRequestQueue.add(sellRequest3);
        sellQueueVCB.sellRequestQueue.add(sellRequest4);
        sellQueueHashMap.put(VCB, sellQueueVCB); //put stock và queue sell vào map
        System.out.println("---------");

        //Tạo yêu cầu mau chứng khoán
        BuyRequest buyRequest1 = new BuyRequest(1, trader4, VCB, 100);
        BuyRequest buyRequest2 = new BuyRequest(2, trader5, VCB, 80);
        BuyRequest buyRequest3 = new BuyRequest(3, trader1, VCB, 70);
        BuyQueue buyQueueVCB = new BuyQueue();
        buyQueueVCB.buyRequestQueue.add(buyRequest1);
        buyQueueVCB.buyRequestQueue.add(buyRequest2);
        buyQueueVCB.buyRequestQueue.add(buyRequest3);
        buyQueueHashMap.put(VCB, buyQueueVCB);

        khopLenh();

    }

    static void khopLenh(){
        for(Stock x : buyQueueHashMap.keySet()){
            System.out.println(x + ". Value: " + buyQueueHashMap.get(x));
        }

        //Lấy ra Stock VCB trong Map các Stock đang listing để khớp giao dịch
        BuyQueue buy = buyQueueHashMap.get(new Stock("VCB", "a"));
        SellQueue sell = sellQueueHashMap.get(new Stock("VCB", "a"));

        System.out.println("buy id");
        System.out.println(buy.buyRequestQueue);
        System.out.println("sell id");
        System.out.println(sell.sellRequestQueue);
        while(buy.buyRequestQueue.peek().getBuyPrice() > sell.sellRequestQueue.peek().getSellPrice()){
            buy.buyRequestQueue.poll();
            SellRequest sellRequest = sell.sellRequestQueue.poll();
            countGiaoDich++;
            sumGiaoDich += sellRequest.sellPrice;
        }
        System.out.println("Count giao dich: " + countGiaoDich);
        System.out.println("Sum giao dich: " + sumGiaoDich);
    }

    @Override
    public void run() {
        khopLenh();
    }
}
