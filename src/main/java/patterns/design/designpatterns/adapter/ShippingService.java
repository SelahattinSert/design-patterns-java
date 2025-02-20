package patterns.design.designpatterns.adapter;

public interface ShippingService {
    double calculateShippingCost(String origin, String destination, double weight);
}
