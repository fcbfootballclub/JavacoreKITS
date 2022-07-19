package GENERIC.collections.QuanLyHoaDon.Suppliers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase {
    private int IdPurchase;// mã đơn nhập hàng

    private Date purDate;// ngày nhập hàng

    private String SupplierID ;// mã nhà cung cấp

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Purchase(int idPurchase, String purDate, String supplierID) throws ParseException {
        IdPurchase = idPurchase;
        this.purDate = simpleDateFormat.parse(purDate);
        SupplierID = supplierID;
    }

    public Purchase() {
    }

    public int getIdPurchase() {
        return IdPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        IdPurchase = idPurchase;
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
    }

    public static SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public static void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        Purchase.simpleDateFormat = simpleDateFormat;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "IdPurchase=" + IdPurchase +
                ", purDate=" + simpleDateFormat.format(purDate) +
                ", SupplierID='" + SupplierID + '\'' +
                '}';
    }
}
