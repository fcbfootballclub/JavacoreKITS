package BTVNStreamAPI.stockEx;

import java.util.ArrayList;
import java.util.Map;
//2.5. Viết và thực thi các thủ tục

public class AppDatabase {

    public static void main(String[] args) {
        DAO dao = new DAO();

        //2.5.1 Tính tổng số tiền giao dịch
        System.out.println("Tổng số tiền giao dịch");
        float a = dao.getAllTransactionsValue();
        System.out.println(a);

        //2.5.2 Lấy ra danh sách cổ phiếu với tổng số tiền giao dịch tương ứng;
        System.out.println("Danh sách cổ phiếu và số tiền giao dịch tương ứng");
        Map<String, Float> stockRev = dao.getTransactionValueByStock();
        for(String x : stockRev.keySet()) {
            System.out.println(x + ". Value: " + stockRev.get(x));
        }

        //2.5.3 Lấy danh sách cổ phiếu có số tiền giao dịch lớn nhất
        Map<String, Float> bestStockList = dao.getListBestStocks();
        System.out.println("Danh sách cổ phiếu có doanh thu cao nhất");
        for(String x : bestStockList.keySet()) {
            System.out.println("Stock: " + x + ". Value: " + bestStockList.get(x) );
        }

        //2.5.4 Lấy ra danh sách những người mua nhiều cố phiếu nhất của từng mã cổ phiếu
        System.out.println("Danh sách những người mua nhiều nhất của mỗi cổ phiếu");
        Map<Map<String, Float>, ArrayList<String>> stock_trader_bestsell = dao.getListBestTradersByStock();
        for(Map<String, Float> x : stock_trader_bestsell.keySet()){
            for(String maCP : x.keySet()){
                System.out.println("MaCP: " + maCP + ". Revenue: " + x.get(maCP) + ". ID user: " + stock_trader_bestsell.get(x));
            }
        }
    }
}
