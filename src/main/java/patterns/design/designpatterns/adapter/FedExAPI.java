package patterns.design.designpatterns.adapter;

public class FedExAPI {

    public double getRate(String from, String to, double weight) {
        System.out.println("FedEx calculating rate from " + from + " to " + to + " for weight: " + weight);
        return weight * 1.5;
    }
}
