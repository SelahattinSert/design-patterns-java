package patterns.design.designpatterns.adapter;

public class FedExAdapter implements ShippingService{

    private final FedExAPI fedExAPI;

    public FedExAdapter(FedExAPI fedExAPI) {
        this.fedExAPI = fedExAPI;
    }

    @Override
    public double calculateShippingCost(String origin, String destination, double weight) {
        return fedExAPI.getRate(origin, destination, weight);
    }
}
