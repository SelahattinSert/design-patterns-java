package patterns.design.designpatterns.factory.factory;

import patterns.design.designpatterns.factory.cars.Car;
import patterns.design.designpatterns.factory.cars.ToyotaHatchback;
import patterns.design.designpatterns.factory.cars.ToyotaSUV;
import patterns.design.designpatterns.factory.cars.ToyotaSedan;

public class ToyotaFactory extends CarFactory {

    @Override
    public Car createCar(String bodyType) {
        return switch (bodyType.toLowerCase()) {
            case "hatchback" -> new ToyotaHatchback();
            case "suv" -> new ToyotaSUV();
            case "sedan" -> new ToyotaSedan();
            default -> throw new IllegalArgumentException("Unknown body type: " + bodyType);
        };
    }
}
