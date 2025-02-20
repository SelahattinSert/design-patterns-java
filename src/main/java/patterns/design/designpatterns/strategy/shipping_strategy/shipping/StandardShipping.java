package patterns.design.designpatterns.strategy.shipping_strategy.shipping;

public class StandardShipping implements ShippingStrategy {

    @Override
    public void ship() {
        System.out.println("Shipping via standard ground delivery");
    }

    @Override
    public double getCost() {
        return 5.99;
    }
}
