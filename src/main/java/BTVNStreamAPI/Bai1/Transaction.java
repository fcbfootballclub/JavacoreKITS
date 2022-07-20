package BTVNStreamAPI.Bai1;

public class Transaction {
    private Customer trader;
    private Integer year;// Năm thực hiện giao dịch
    private String prodName;// Tên sản phẩm
    private Integer amount; // Số lượng

    public Transaction(Customer trader, Integer year, String prodName, Integer amount) {
        this.trader = trader;
        this.year = year;
        this.prodName = prodName;
        this.amount = amount;
    }

    public Transaction() {
    }

    public Customer getTrader() {
        return trader;
    }

    public void setTrader(Customer trader) {
        this.trader = trader;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", prodName='" + prodName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
