package patterns.design.designpatterns.strategy.shipping_strategy.packaging;

public class MinimalPackaging implements PackagingStrategy {

    @Override
    public void pack() {
        System.out.println("Packing with minimal, eco-friendly materials");
    }

    @Override
    public double getCost() {
        return 1.50;
    }
}
