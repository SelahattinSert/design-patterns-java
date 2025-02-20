package patterns.design.designpatterns.strategy.shipping_strategy.packaging;

public interface PackagingStrategy {
    void pack();
    double getCost();
}
