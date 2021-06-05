package revolut;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class Account {
    private Currency accCurrency;
    private double balance;
    private final List<String> blacklistedPaymentServices = Arrays.asList("PayPal");

    public Account(Currency currency, double balance){
        this.balance = balance;
        this.accCurrency = currency;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void addFunds(double topUpAmount, PaymentService paymentService) {
        //check if payment method is blacklisted


        if(!blacklistedPaymentServices.contains(paymentService.getType())){ this.balance += topUpAmount;  //dont add anything to balance

        }else{ this.balance += 0; } //add balance to new balance


    }
}
