package GENERIC.collections.QuanLyHoaDon.Suppliers;

public class PurchaseDetail {
    private int IdPurchase;
    private int IdDetail;
    private int ItemID;// mã mặt hàng
    private int Amount;
    private float Price;

    public PurchaseDetail(int idPurchase, int idDetail, int itemID, int amount, float price) {
        IdPurchase = idPurchase;
        IdDetail = idDetail;
        ItemID = itemID;
        Amount = amount;
        Price = price;
    }

    public PurchaseDetail() {
    }

    public int getIdPurchase() {
        return IdPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        IdPurchase = idPurchase;
    }

    public int getIdDetail() {
        return IdDetail;
    }

    public void setIdDetail(int idDetail) {
        IdDetail = idDetail;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "PurchaseDetail{" +
                "IdPurchase=" + IdPurchase +
                ", IdDetail=" + IdDetail +
                ", ItemID=" + ItemID +
                ", Amount=" + Amount +
                ", Price=" + Price +
                '}';
    }
}
