package patterns.design.designpatterns.strategy.shipping_strategy.shipping;

public class ExpressShipping implements ShippingStrategy {

    @Override
    public void ship() {
        System.out.println("Shipping via express air delivery");
    }

    @Override
    public double getCost() {
        return 15.99;
    }
}
