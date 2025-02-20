package patterns.design.designpatterns.factory.factory;

import patterns.design.designpatterns.factory.cars.Car;
import patterns.design.designpatterns.factory.cars.RenaultHatchback;
import patterns.design.designpatterns.factory.cars.RenaultSUV;
import patterns.design.designpatterns.factory.cars.RenaultSedan;

public class RenaultFactory extends CarFactory {

    @Override
    public Car createCar(String bodyType) {
        return switch (bodyType.toLowerCase()) {
            case "hatchback" -> new RenaultHatchback();
            case "suv" -> new RenaultSUV();
            case "sedan" -> new RenaultSedan();
            default -> throw new IllegalArgumentException("Unknown body type: " + bodyType);
        };
    }
}
