/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTVNStreamAPI.stockEx;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Trader {
    private String sIDTrader;
    private String nameTrader;

    public Trader(String sIDTrader, String nameTrader) {
        this.sIDTrader = sIDTrader;
        this.nameTrader = nameTrader;
    }

    public Trader(String sIDTrader) {
        this.sIDTrader = sIDTrader;
    }

    public Trader() {
    }

    public String getsIDTrader() {
        return sIDTrader;
    }

    public void setsIDTrader(String sIDTrader) {
        this.sIDTrader = sIDTrader;
    }

    public String getNameTrader() {
        return nameTrader;
    }

    public void setNameTrader(String nameTrader) {
        this.nameTrader = nameTrader;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "sIDTrader='" + sIDTrader + '\'' +
                ", nameTrader='" + nameTrader + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.sIDTrader.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((Trader) obj).sIDTrader.equals(this.sIDTrader);
    }
}
