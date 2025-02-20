package patterns.design.designpatterns.facade;

public class FlightBookingSystem {

    public void bookFlight(String departureCity, String destinationCity, String departureDate) {
        System.out.println("Flight booked from " + departureCity + " to " + destinationCity + " on " + departureDate);
    }
}
