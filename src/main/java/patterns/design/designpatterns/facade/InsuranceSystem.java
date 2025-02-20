package patterns.design.designpatterns.facade;

public class InsuranceSystem {

    public void purchaseInsurance(String destinationCity, String startDate, String endDate) {
        System.out.println("Travel insurance purchased for " + destinationCity + " from " + startDate + " to " + endDate);
    }
}
