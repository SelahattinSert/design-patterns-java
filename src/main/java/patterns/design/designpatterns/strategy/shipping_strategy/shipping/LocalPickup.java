package patterns.design.designpatterns.strategy.shipping_strategy.shipping;

public class LocalPickup implements ShippingStrategy {

    @Override
    public void ship() {
        System.out.println("Preparing order for local pickup");
    }

    @Override
    public double getCost() {
        return 1.00;
    }
}
