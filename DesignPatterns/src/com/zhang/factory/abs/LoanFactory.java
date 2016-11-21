package com.zhang.factory.abs;

/**
 * Created by zhangxiangdong on 2016/11/21.
 */
public class LoanFactory extends AbstractFactory<Loan> {

    @Override
    public Loan get(String loan) {
        if (loan == null) {
            return null;
        }
        if (loan.equalsIgnoreCase("Home")) {
            return new HomeLoan();
        } else if (loan.equalsIgnoreCase("Business")) {
            return new BussinessLoan();
        } else if (loan.equalsIgnoreCase("Education")) {
            return new EducationLoan();
        }
        return null;
    }

}
