package patterns.design.designpatterns.factory.factory;

import patterns.design.designpatterns.factory.cars.Car;
import patterns.design.designpatterns.factory.cars.MercedesHatchback;
import patterns.design.designpatterns.factory.cars.MercedesSUV;
import patterns.design.designpatterns.factory.cars.MercedesSedan;

public class MercedesFactory extends CarFactory {

    @Override
    public Car createCar(String bodyType) {
        return switch (bodyType.toLowerCase()) {
            case "hatchback" -> new MercedesHatchback();
            case "suv" -> new MercedesSUV();
            case "sedan" -> new MercedesSedan();
            default -> throw new IllegalArgumentException("Unknown body type: " + bodyType);
        };
    }
}
