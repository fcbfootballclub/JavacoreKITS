package BTVNStreamAPI.stockEx;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Main2 {
    static String connectionUrl = "jdbc:sqlserver://Localhost:1433;"
            + "databaseName=StockExchange;user=sa;password=sa";
    // Nạp driver
    static Connection conn = null;

    //get all Stock are listing in the database
    static List<String> getStockList(){
        List<String> lstStock = new ArrayList<>(10);
        // Establish the connection.
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// buoc 1
            conn = DriverManager.getConnection(connectionUrl); // buoc 2
            String sql = "select * from Stock";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                lstStock.add(rs.getString("sIDStock"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lstStock.get(2));
        return lstStock;
    }

    //get all traderID from database
    static List<String> getAllTrader(){
        List<String> lstTrader = new ArrayList<>(10);
        // Establish the connection.
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// buoc 1
            conn = DriverManager.getConnection(connectionUrl); // buoc 2
            String sql = "select * from Trader";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                lstTrader.add(rs.getString("sIDTrader"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lstTrader.get(2));
        return lstTrader;
    }

    //insert order into database
    static void insertOrder(int orderType, String sIDStock, String sIdTrader, int amount, float price){
        String sql = "INSERT INTO OrderList (orderType, sIDStock, sIDTrader, amount, price)"
                + " VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, orderType);
            statement.setString(2, sIDStock);
            statement.setString(3, sIdTrader);
            statement.setInt(4, amount);
            statement.setFloat(5, price);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //insert Transaction
    static void insertTransaction(String idStock, String idBuyer, String idSeller, int amount, float price, String orderDate){
        String sql = "INSERT INTO TransactionList (idStock, idBuyer, idSeller, amount, price, orderDate)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, idStock);
            statement.setString(2, idBuyer);
            statement.setString(3, idSeller);
            statement.setInt(4, amount);
            statement.setFloat(5, price);
            statement.setString(6, orderDate);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<String> lstStock = getStockList();
        List<String> lstTrader = getAllTrader();

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

            Float price = (float) Math.random() * 1000;
            if (x < 0.5) {
                Order ord1 = new Order(1, 1, lstStock.get(iIDStock), lstTrader.get(iIDTrader),iAmount, price);
//                insertOrder(1, lstStock.get(iIDStock),lstTrader.get(iIDTrader), iAmount, price);
                PriorityQueue<Order> bQ = hm_st_Buyq.get(lstStock.get(iIDStock));
                bQ.add(ord1);
            } else {
                Order ord2 = new Order(2,2, lstStock.get(iIDStock),lstTrader.get(iIDTrader),iAmount, price);
//                insertOrder(2, lstStock.get(iIDStock),lstTrader.get(iIDTrader), iAmount, price);
                PriorityQueue<Order> sellQ = hm_st_Sellq.get(lstStock.get(iIDStock));
                sellQ.add(ord2);
            }
            // Khớp lệnh
            PriorityQueue<Order> sQ = hm_st_Sellq.get(lstStock.get(iIDStock));
            PriorityQueue<Order> bQ = hm_st_Buyq.get(lstStock.get(iIDStock));
            //Bổ sung vào đây
//            System.out.println("Khớp lệnh"+ lstStock[iIDStock]);
            //Tạo list chứa tất cả các transantion.\
            DAO dao = new DAO();
            float a = dao.getAllTransactionsValue();
            System.out.println("ToTal revenue: " + a);

            while(!sQ.isEmpty() && !bQ.isEmpty()) {
//            System.out.println("buy size: " + bQ_FPT.size());
//            System.out.println("sell size: " + sQ_FPT.size());
                Order buyOrder = bQ.peek();
                Order sellOrder = sQ.peek();
                if(buyOrder.getPrice() >= sellOrder.getPrice()) {
                    Transantion transantion = new Transantion();
                    transantion.idStock = buyOrder.getsIDStock();
                    transantion.idBuyer = buyOrder.getsIDTrader();
                    transantion.idSeller = sellOrder.getsIDTrader();
                    transantion.price = sellOrder.getPrice();
                    if(buyOrder.getAmount() < sellOrder.getAmount()){
                        transantion.amount = buyOrder.getAmount();
                        //cập nhật lại số lượng của chứng khoán của queue
                        sellOrder.setAmount(sellOrder.getAmount() - buyOrder.getAmount());
                        bQ.poll();
                    } else if (buyOrder.getAmount() > sellOrder.getAmount()){
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
//                    insertTransaction(transantion.idStock, transantion.idBuyer, transantion.idSeller,transantion.amount, transantion.price, formatter.format(transantion.date));
                    transantionList.forEach(System.out::println);
                } else {
                    break;
                }
            }


        }
    }
}
