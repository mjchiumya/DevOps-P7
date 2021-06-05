package features;

import io.cucumber.java.ParameterType;
import revolut.PaymentService;

public class ParameterTypes {
    @ParameterType("BankAccount|DebitCard|PayPal|BitCoin")
    public PaymentService paymentService(String type){

        return new PaymentService(type);
    }
}

