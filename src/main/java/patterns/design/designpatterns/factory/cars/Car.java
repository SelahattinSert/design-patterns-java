package patterns.design.designpatterns.factory.cars;

public abstract class Car {

    protected String modelName;
    protected double weight;
    protected double acceleration;
    protected int topSpeed;
    protected double price;
    protected String originCountry;
    protected String productionTime;
    protected String deliveryTime;

    public abstract void displaySpecs();
}
