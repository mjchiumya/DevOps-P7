package revolut;

import java.util.Arrays;
import java.util.List;

public class PaymentService {

    private String serviceName;


    public PaymentService(String name){

        this.serviceName = name;
    }

    public String getType() {
        return serviceName;
    }


}
