package patterns.design.designpatterns.adapter;

public class UPSAdapter implements ShippingService{

    private final UPSAPI upsAPI;

    public UPSAdapter(UPSAPI upsAPI) {
        this.upsAPI = upsAPI;
    }

    @Override
    public double calculateShippingCost(String origin, String destination, double weight) {
        return upsAPI.calculateCost(origin, destination, weight);
    }
}
