package patterns.design.designpatterns.adapter;

public class PayPalSDK {

    public void pay(double amount, String currencyCode) {
        System.out.println("PayPal processing payment: " + amount + " " + currencyCode);
    }
}
