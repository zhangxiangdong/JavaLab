package me.zhang.tdd;

import org.javamoney.moneta.Money;
import org.junit.Test;

import static me.zhang.tdd.Account.CURRENCY_CODE_USD;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by zhangxiangdong on 2017/2/13.
 */
public class AccountTest {

    /**
     * 使用默认构造方法创建Account对象，验证各个默认属性值
     */
    @Test
    public void defaultAccountCreationTest() {
        Account account = new Account();
        assertThat(account.getId().length(), equalTo(6));
        assertThat(account.isActive(), equalTo(true));
        assertThat(account.getZone(), equalTo(Account.Zone.ZONE_1));
        assertThat(account.getBalance(), equalTo(Money.of(0.00, CURRENCY_CODE_USD)));
    }

    /**
     * 验证使用参数创建Account对象后，各个属性值
     */
    @Test
    public void customAccountCreationTest() {
        Account account = new Account(false, Account.Zone.ZONE_2, 123.45);
        assertThat(account.getId().length(), equalTo(6));
        assertThat(account.isActive(), equalTo(false));
        assertThat(account.getZone(), equalTo(Account.Zone.ZONE_2));
        assertThat(account.getBalance(), equalTo(Money.of(123.45, CURRENCY_CODE_USD)));
    }

    /**
     * 使用非法参数，验证抛出非法参数异常
     */
    @Test(expected = IllegalArgumentException.class)
    public void negativeBalanceTest() {
        new Account(false, Account.Zone.ZONE_3, -789.00);
    }

}