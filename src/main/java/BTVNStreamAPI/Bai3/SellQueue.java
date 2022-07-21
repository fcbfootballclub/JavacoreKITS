package BTVNStreamAPI.Bai3;

import java.util.PriorityQueue;
import java.util.Queue;

public class SellQueue {
    //lưu tất cả sell request
    Queue<SellRequest> sellRequestQueue = new PriorityQueue<>();

    //lưu sell request của một mã chứng khoán cụ thể
//    Queue<SellRequest> list = new PriorityQueue<>();
//    void getAllSellRequestByStock(Stock stock){
//        list.clear();
//        for(SellRequest x: sellRequestQueue) {
//            if(x.getStockToSell().equals(stock)){
//                list.add(x);
//            }
//        }
//    }
}
