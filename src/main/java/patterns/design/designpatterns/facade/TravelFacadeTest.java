package patterns.design.designpatterns.facade;

public class TravelFacadeTest {

    public static void main(String[] args) {
        TravelFacade travelFacade = new TravelFacade();

        travelFacade.planTrip(
                "İzmir",
                "Paris",
                "2024-12-20",
                "2024-12-20",
                "2024-12-25",
                "Paris",
                "2024-12-20",
                5,
                "2024-12-22",
                "2024-12-20",
                "2024-12-25"
        );
    }
}
