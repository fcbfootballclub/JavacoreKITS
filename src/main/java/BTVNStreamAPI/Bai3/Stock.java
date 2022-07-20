package BTVNStreamAPI.Bai3;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private String maStock;
    private String nameStock;

    public Stock(String maStock, String nameStock) {
        this.maStock = maStock;
        this.nameStock = nameStock;
    }

    public Stock() {
    }

    public String getMaStock() {
        return maStock;
    }

    public void setMaStock(String maStock) {
        this.maStock = maStock;
    }

    public String getNameStock() {
        return nameStock;
    }

    public void setNameStock(String nameStock) {
        this.nameStock = nameStock;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "maStock='" + maStock + '\'' +
                ", nameStock='" + nameStock + '\'' +
                '}';
    }
}
