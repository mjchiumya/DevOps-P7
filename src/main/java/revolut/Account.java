package revolut;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class Account {
    private Currency accCurrency;
    private double balance;
    //list of blacklisted payment services
    private final List<String> blacklistedPaymentServices = Arrays.asList("PayPal");

    public Account(Currency currency, double balance){
        this.balance = balance;
        this.accCurrency = currency;
    }

    public void setBalance(double newBalance) {

        this.balance = newBalance;
    }

    public double getBalance(String currency) {
        if(currency.equalsIgnoreCase("usd")){
            //to get accurate exchange rate of 1euro = 1.6' dollars {30eu = 50usd}
            this.balance = this.balance * 1.66666666666666666;
        }else if(currency.equalsIgnoreCase("EUR")){
              return this.balance ;
        }
        return this.balance;

    }

    public void addFunds(double topUpAmount, PaymentService paymentService) {
        //check if payment method is blacklisted
        if(blacklistedPaymentServices.contains(paymentService.getType())){
            this.balance = this.balance+0;
        }else{this.balance += topUpAmount; }
    }

}
