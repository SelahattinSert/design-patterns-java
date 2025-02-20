package patterns.design.designpatterns.facade;

public class CarRentalSystem {

    public void rentCar(String city, String startDate, int days) {
        System.out.println("Car rented in " + city + " starting on " + startDate + " for " + days + " days");
    }
}
