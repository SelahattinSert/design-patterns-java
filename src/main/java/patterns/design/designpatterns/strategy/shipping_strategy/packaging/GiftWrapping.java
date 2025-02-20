package patterns.design.designpatterns.strategy.shipping_strategy.packaging;

public class GiftWrapping implements PackagingStrategy {

    @Override
    public void pack() {
        System.out.println("Wrapping the order as a gift");
    }

    @Override
    public double getCost() {
        return 4.99;
    }
}
