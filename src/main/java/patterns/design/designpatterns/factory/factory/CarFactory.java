package patterns.design.designpatterns.factory.factory;

import patterns.design.designpatterns.factory.cars.Car;

public abstract class CarFactory {
    public abstract Car createCar(String bodyType);
}
