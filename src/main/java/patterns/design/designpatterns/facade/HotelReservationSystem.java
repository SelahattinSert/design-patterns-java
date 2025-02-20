package patterns.design.designpatterns.facade;

public class HotelReservationSystem {

    public void reserveHotel(String city, String checkInDate, String checkOutDate) {
        System.out.println("Hotel reserved in " + city + " from " + checkInDate + " to " + checkOutDate);
    }
}
