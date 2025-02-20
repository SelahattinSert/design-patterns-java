package patterns.design.designpatterns.factory;

import patterns.design.designpatterns.factory.cars.Car;
import patterns.design.designpatterns.factory.factory.CarFactory;
import patterns.design.designpatterns.factory.factory.MercedesFactory;
import patterns.design.designpatterns.factory.factory.RenaultFactory;
import patterns.design.designpatterns.factory.factory.ToyotaFactory;

import java.util.Scanner;

public class CarOrderSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter brand choice (toyota, mercedes, renault):");
        String brand = scanner.nextLine();

        System.out.println("Enter a body type (sedan, hatchback, suv):");
        String bodyType = scanner.nextLine();

        CarFactory factory = switch (brand.toLowerCase()) {
            case "toyota" -> new ToyotaFactory();
            case "mercedes" -> new MercedesFactory();
            case "renault" -> new RenaultFactory();
            default -> throw new IllegalArgumentException("Unknown brand: " + brand);
        };

        Car car = factory.createCar(bodyType);
        car.displaySpecs();
    }
}
