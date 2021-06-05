package features;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import revolut.PaymentService;
import revolut.Person;

public class MyStepdefs {

    private double topUpAmount;
    //private String topUpMethod;
    PaymentService topUpMethod;
    Person danny;


    @Before//Before hooks run before the first step in each scenario
    public void setUp(){
        //We can use this to setup test data for each scenario
        danny = new Person("Danny");
    }

    @Given("Danny selects dollars as the withdraw amount")
    public void danny_selects_dollars_as_the_withdraw_amount() {
        // Write code here that turns the phrase above into concrete actions
        danny.getAccountBalance("usd");

    }
    @When("Danny withdraws {int} dollars")
    public void danny_withdraws_dollars(double withdrawAmount) {
        // Write code here that turns the phrase above into concrete actions
        double currentBalance = danny.getAccountBalance("usd");
        double newBalance = currentBalance - withdrawAmount;
        danny.setAccountBalance(newBalance);
    }



}
