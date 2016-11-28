package com.zhang.creational.factory.abs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangxiangdong on 2016/11/21.
 */
public class AbstractFactoryPatternExample {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the name of Bank from where you want to take loan amount: ");
        String bankName = br.readLine();

        System.out.print("\n");
        System.out.print("Enter the type of loan e.g. home loan or business loan or education loan : ");
        String loanName = br.readLine();

        AbstractFactory<Bank> bankFactory = FactoryCreator.getBankFactory();
        Bank b = bankFactory.get(bankName);

        System.out.print("\n");
        System.out.print("Enter the interest rate for " + b.getBankName() + ": ");

        double rate = Double.parseDouble(br.readLine());
        System.out.print("\n");
        System.out.print("Enter the loan amount you want to take: ");

        double loanAmount = Double.parseDouble(br.readLine());
        System.out.print("\n");
        System.out.print("Enter the number of years to pay your entire loan amount: ");
        int years = Integer.parseInt(br.readLine());

        System.out.print("\n");
        System.out.println("you are taking the loan from " + b.getBankName());

        AbstractFactory<Loan> loanFactory = FactoryCreator.getLoanFactory();
        Loan l = loanFactory.get(loanName);
        l.getInterestRate(rate);
        l.calculateLoanPayment(loanAmount, years);
    }

}
