package patterns.design.designpatterns.strategy.shipping_strategy.packaging;

public class BulkPackaging implements PackagingStrategy {

    @Override
    public void pack() {
        System.out.println("Packing in bulk for efficient shipping");
    }

    @Override
    public double getCost() {
        return 3.00;
    }
}
