package me.zhang.tdd;

import org.apache.commons.lang3.RandomStringUtils;
import org.javamoney.moneta.Money;

/**
 * Created by zhangxiangdong on 2017/2/13.
 */
public class Account {

    public static final String CURRENCY_CODE_USD = "USD";
    private String id = RandomStringUtils.randomAlphanumeric(6);
    private boolean isActive = true;
    private Zone zone = Zone.ZONE_1;
    private Money balance = Money.of(0.00, CURRENCY_CODE_USD);

    public Account() {
    }

    public Account(boolean isActive, Zone zone, double balance) {
        this.isActive = isActive;
        this.zone = zone;
        if (balance < 0) {
            throw new IllegalArgumentException("The balance can not be negative.");
        }
        this.balance = Money.of(balance, CURRENCY_CODE_USD);
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public Zone getZone() {
        return zone;
    }

    public Money getBalance() {
        return balance;
    }

    enum Zone {
        ZONE_1, ZONE_2, ZONE_3
    }

}
