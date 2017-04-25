package me.zhang.generic;

import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/4/25.
 */
public class PortfolioTest {

    @Test
    public void portfolioQualityInspection() {
        Portfolio<String> portfolio = new Portfolio<>(12);
        portfolio.set(0, "HL");
        System.out.println(portfolio.get(0));
    }

}