package BTVNStreamAPI.Bai3;

public class SellRequest implements Comparable<SellRequest>{
    int idSellRequest;
    Trader trader;
    Stock stockToSell;
    float sellPrice;
    public SellRequest(int idSellRequest, Trader trader, Stock stockToSell, float sellPrice) {
        this.idSellRequest = idSellRequest;
        this.trader = trader;
        this.stockToSell = stockToSell;
        this.sellPrice = sellPrice;
    }
    public SellRequest() {
    }

    public int getIdSellRequest() {
        return idSellRequest;
    }

    public void setIdSellRequest(int idSellRequest) {
        this.idSellRequest = idSellRequest;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Stock getStockToSell() {
        return stockToSell;
    }

    public void setStockToSell(Stock stockToSell) {
        this.stockToSell = stockToSell;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "SellRequest{" +
                "idSellRequest=" + idSellRequest +
                ", trader=" + trader +
                ", stockToSell=" + stockToSell +
                ", sellPrice=" + sellPrice +
                '}';
    }

    @Override
    public int compareTo(SellRequest o) {
        return (int) (sellPrice - o.sellPrice);
    }
}
