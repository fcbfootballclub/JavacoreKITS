package BTVNStreamAPI.Bai3;

import BTVNStreamAPI.Bai1.Customer;

public class BuyRequest implements Comparable<BuyRequest>{
    int idBuyRequest;
    Trader trader; //FK to Trader
    Stock stockToBuy;
    float buyPrice;

    public BuyRequest(int idBuyRequest, Trader trader, Stock stockToBuy, float buyPrice) {
        this.idBuyRequest = idBuyRequest;
        this.trader = trader;
        this.stockToBuy = stockToBuy;
        this.buyPrice = buyPrice;
    }

    public BuyRequest() {
    }

    public int getIdBuyRequest() {
        return idBuyRequest;
    }

    public void setIdBuyRequest(int idBuyRequest) {
        this.idBuyRequest = idBuyRequest;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Stock getStockToBuy() {
        return stockToBuy;
    }

    public void setStockToBuy(Stock stockToBuy) {
        this.stockToBuy = stockToBuy;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "BuyRequest{" +
                "idBuyRequest=" + idBuyRequest +
                ", trader=" + trader +
                ", stockToBuy=" + stockToBuy +
                ", buyPrice=" + buyPrice +
                '}';
    }

    @Override
    public int compareTo(BuyRequest o) {
        return (int) (o.buyPrice - buyPrice);
    }
}
