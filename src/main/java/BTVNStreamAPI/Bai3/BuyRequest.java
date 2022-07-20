package BTVNStreamAPI.Bai3;

import BTVNStreamAPI.Bai1.Customer;

public class BuyRequest {
    int idBuyRequest;
    Trader trader; //FK to Trader
    Stock stockToBuy;
    float buyPrice;
}
