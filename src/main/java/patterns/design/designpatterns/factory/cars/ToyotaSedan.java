package patterns.design.designpatterns.factory.cars;

public class ToyotaSedan extends Car {

    public ToyotaSedan() {
        modelName = "Corolla";
        weight = 1365.0;
        acceleration = 8.2;
        topSpeed = 225;
        price = 29500.0;
        originCountry = "Japan";
        productionTime = "1 month";
        deliveryTime = "3-4 weeks";
    }

    @Override
    public void displaySpecs() {
        System.out.println("Model Name: " + modelName);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Acceleration 0-100km: " + acceleration + " sec");
        System.out.println("Top speed: " + topSpeed + " km/h");
        System.out.println("Price: " + price + " euro");
        System.out.println("Origin Country: " + originCountry);
        System.out.println("Production Time: " + productionTime);
        System.out.println("Delivery Time: " + deliveryTime);
    }
}
