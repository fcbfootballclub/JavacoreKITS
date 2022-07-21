package BTVNStreamAPI.Bai3;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyQueue {
    Queue<BuyRequest> buyRequestQueue = new PriorityQueue<>();

    //trả về queue nhóm cổ phiếu đang cần mua cụ thể
//    Queue<BuyRequest> list = new PriorityQueue<>();
//
//    void getAllBuyRequestByStockID(Stock stock){
//        list.clear();
//        for(BuyRequest x : buyRequestQueue){
//            if(x.getStockToBuy().equals(stock)){
//                list.add(x);
//            }
//        }
//    }

    @Override
    public String toString() {
        return "BuyQueue{" +
                "buyRequestQueue=" + buyRequestQueue +
                '}';
    }
}
