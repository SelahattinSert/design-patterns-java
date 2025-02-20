package patterns.design.designpatterns.facade;

public class TravelFacade {

    private final FlightBookingSystem flightBookingSystem;
    private final CarRentalSystem carRentalSystem;
    private final ActivityBookingSystem activityBookingSystem;
    private final HotelReservationSystem hotelReservationSystem;
    private final InsuranceSystem insuranceSystem;
    private final NotificationService notificationService;

    public TravelFacade() {
        this.flightBookingSystem = new FlightBookingSystem();
        this.hotelReservationSystem = new HotelReservationSystem();
        this.carRentalSystem = new CarRentalSystem();
        this.activityBookingSystem = new ActivityBookingSystem();
        this.insuranceSystem = new InsuranceSystem();
        this.notificationService = new NotificationService();
    }

    public void planTrip(String departureCity, String destinationCity, String departureDate,
                         String checkInDate, String checkOutDate, String carRentalCity,
                         String carRentalDate, int carRentalDays, String activityDate,
                         String insuranceStartDate, String insuranceEndDate) {
        flightBookingSystem.bookFlight(departureCity, destinationCity, departureDate);
        hotelReservationSystem.reserveHotel(destinationCity, checkInDate, checkOutDate);
        carRentalSystem.rentCar(carRentalCity, carRentalDate, carRentalDays);
        activityBookingSystem.bookActivity(destinationCity, activityDate);
        insuranceSystem.purchaseInsurance(destinationCity, insuranceStartDate, insuranceEndDate);
        notificationService.sendNotification("Your trip to " + destinationCity + " has been successfully planned");
    }
}
