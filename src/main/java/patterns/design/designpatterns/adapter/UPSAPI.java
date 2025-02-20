package patterns.design.designpatterns.adapter;

public class UPSAPI {

    public double calculateCost(String source, String destination, double packageWeight) {
        System.out.println("UPS calculating cost from " + source + " to " + destination + " for weight: " + packageWeight);
        return packageWeight * 1.2;
    }
}
