package BTVNStreamAPI.stockEx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        List<String> lstTrader = new ArrayList<>(10);
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
        System.out.println(lstTrader.get(2));
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
}
