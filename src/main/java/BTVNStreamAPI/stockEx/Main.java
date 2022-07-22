package BTVNStreamAPI.stockEx;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        DAO dao = new DAO();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<String> lstStock = dao.getStockList();
        List<String> lstTrader = dao.getAllTrader();

        Map<String, Stock> hm = new HashMap<>();
        for (String sId : lstStock) {
            Stock st = new Stock(sId);
            hm.put(sId, st);
        }

        Map<String, PriorityQueue<Order>> hm_st_Sellq = new HashMap<>();
        Map<String, PriorityQueue<Order>> hm_st_Buyq = new HashMap<>();

        for (String sIdStock : hm.keySet()) {
            hm_st_Sellq.put(sIdStock, new PriorityQueue<>());
            hm_st_Buyq.put(sIdStock, new PriorityQueue<>(new OrderComparator()));
        }


        List<Transantion> transantionList = new ArrayList<>();
        while (true) {
            // Lệnh mua, bán ngẫu nhiên
            int iIDStock = (int) Math.round(Math.random() * (lstStock.size() - 1));
            int iIDTrader = (int) Math.round(Math.random() * (lstTrader.size() - 1));

            double x = Math.random();
            int iAmount = (int) Math.round(Math.random() * 100);

            float price = (float) Math.random() * 1000;
            if (x < 0.5) {
                Order ord1 = new Order(1, 1, lstStock.get(iIDStock), lstTrader.get(iIDTrader), iAmount, price);
                dao.insertOrder(1, lstStock.get(iIDStock), lstTrader.get(iIDTrader), iAmount, price);
                PriorityQueue<Order> bQ = hm_st_Buyq.get(lstStock.get(iIDStock));
                bQ.add(ord1);
            } else {
                Order ord2 = new Order(2, 2, lstStock.get(iIDStock), lstTrader.get(iIDTrader), iAmount, price);
                dao.insertOrder(2, lstStock.get(iIDStock), lstTrader.get(iIDTrader), iAmount, price);
                PriorityQueue<Order> sellQ = hm_st_Sellq.get(lstStock.get(iIDStock));
                sellQ.add(ord2);
            }
            // Khớp lệnh
            PriorityQueue<Order> sQ = hm_st_Sellq.get(lstStock.get(iIDStock));
            PriorityQueue<Order> bQ = hm_st_Buyq.get(lstStock.get(iIDStock));
            //Bổ sung vào đây
//            System.out.println("Khớp lệnh"+ lstStock[iIDStock]);
            //Tạo list chứa tất cả các transantion.

            while (!sQ.isEmpty() && !bQ.isEmpty()) {
//            System.out.println("buy size: " + bQ_FPT.size());
//            System.out.println("sell size: " + sQ_FPT.size());
                Order buyOrder = bQ.peek();
                Order sellOrder = sQ.peek();
                if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                    Transantion transantion = new Transantion();
                    transantion.idStock = buyOrder.getsIDStock();
                    transantion.idBuyer = buyOrder.getsIDTrader();
                    transantion.idSeller = sellOrder.getsIDTrader();
                    transantion.price = sellOrder.getPrice();
                    if (buyOrder.getAmount() < sellOrder.getAmount()) {
                        transantion.amount = buyOrder.getAmount();
                        //cập nhật lại số lượng của chứng khoán của queue
                        sellOrder.setAmount(sellOrder.getAmount() - buyOrder.getAmount());
                        bQ.poll();
                    } else if (buyOrder.getAmount() > sellOrder.getAmount()) {
                        transantion.amount = sellOrder.getAmount();
                        //cập nhật lại số lượng của chứng khoán của queue
                        buyOrder.setAmount(buyOrder.getAmount() - sellOrder.getAmount());
                        sQ.poll();
                    } else {
                        transantion.amount = sellOrder.getAmount();
                        bQ.poll();
                        sQ.poll();
                    }
                    transantionList.add(transantion);
                    transantion.date = new Date();
                    dao.insertTransaction(transantion.idStock, transantion.idBuyer, transantion.idSeller, transantion.amount, transantion.price, formatter.format(transantion.date));
                    transantionList.forEach(System.out::println);
                } else {
                    break;
                }
            }

        }
    }
}
