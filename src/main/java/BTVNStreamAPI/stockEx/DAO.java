package BTVNStreamAPI.stockEx;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {
    static String connectionUrl = "jdbc:sqlserver://Localhost:1433;"
            + "databaseName=StockExchange;user=sa;password=sa";
    // Nạp driver
    static Connection conn = null;

    //get all Stock are listing in the database
    List<String> getStockList() {
        List<String> lstStock = new ArrayList<>(10);
        // Establish the connection.
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// buoc 1
            conn = DriverManager.getConnection(connectionUrl); // buoc 2
            String sql = "select * from Stock";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                lstStock.add(rs.getString("sIDStock"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lstStock.get(2));
        return lstStock;
    }

    //get all traderID from database
    List<String> getAllTrader() {
        List<String> lstTrader = new ArrayList<>(100);
        // Establish the connection.
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// buoc 1
            conn = DriverManager.getConnection(connectionUrl); // buoc 2
            String sql = "select * from Trader";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                lstTrader.add(rs.getString("sIDTrader"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return lstTrader;
    }

    //insert order into database
    void insertOrder(int orderType, String sIDStock, String sIdTrader, int amount, float price) {
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
        }
    }

    //insert Transaction
    void insertTransaction(String idStock, String idBuyer, String idSeller, int amount, float price, String orderDate) {
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
        }
    }


    //2.4.1 get total transactions value
    float getAllTransactionsValue() {
        try {
            conn = DriverManager.getConnection(connectionUrl); // buoc 2
            CallableStatement statement = conn.prepareCall("{call dbo.pro_total_revenue}");
            ResultSet rs = statement.executeQuery();
            rs.next();
            float Revenue = rs.getFloat(1);
            statement.close();
            return Revenue;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }


    //2.4.2 Lấy ra danh sách cổ phiếu với tổng số tiền giao dịch tương ứng
    Map<String, Float> getTransactionValueByStock() {
        Map<String, Float> list = new HashMap<>();
        try {
            conn = DriverManager.getConnection(connectionUrl); // buoc 2
            CallableStatement statement = conn.prepareCall("{call dbo.MaCP_Revenue}");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String stockID = rs.getString(1);
                Float rev = rs.getFloat(2);
                list.put(stockID, rev);
            }
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //2.4.3 Lấy danh sách cổ phiếu có số tiền giao dịch lớn nhất
    Map<String, Float> getListBestStocks() {
        Map<String, Float> list = new HashMap<>();
        try {
            conn = DriverManager.getConnection(connectionUrl); // buoc 2
            CallableStatement statement = conn.prepareCall("{call dbo.danhSachCP_BestRevenue}");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String stockID = rs.getString(1);
                Float rev = rs.getFloat(2);
                list.put(stockID, rev);
            }
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //2.4.3 Lấy danh sách traders giao dịch lớn nhất của từng cổ phiếu
    Map<Map<String, Float>, ArrayList<String>> getListBestTradersByStock() {
        Map<Map<String, Float>, ArrayList<String>> list = new HashMap<>();
        try {
            conn = DriverManager.getConnection(connectionUrl); // buoc 2
            CallableStatement statement = conn.prepareCall("{call dbo.MaxValueByTraderAndStock}");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Map<String, Float> rev_idStock_list = new HashMap<>();
                ArrayList<String> bestTrader = new ArrayList<>();
                String traderID = rs.getString(1);
                String stockID = rs.getString(2);
                float rev = rs.getFloat(3);

                rev_idStock_list.put(stockID, rev);
                if(list.containsKey(rev_idStock_list)){
                    list.get(rev_idStock_list).add(traderID);
                } else {
                    bestTrader.add(traderID);
                    rev_idStock_list.put(stockID, rev);
                    list.put(rev_idStock_list, bestTrader);
                }
            }
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }


}
