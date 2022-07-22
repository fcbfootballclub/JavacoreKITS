package BTVNStreamAPI.stockEx;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppDatabase {
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
        lstStock.forEach(System.out::println);
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
                lstTrader.add(rs.getString("sIDStock"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lstTrader.get(2));
        lstTrader.forEach(System.out::println);
        return lstTrader;
    }




    public static void main(String[] args) {

        getStockList();
        getAllTrader();
    }
}
