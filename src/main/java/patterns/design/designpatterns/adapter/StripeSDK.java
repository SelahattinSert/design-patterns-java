package patterns.design.designpatterns.adapter;

public class StripeSDK {

    public void makePayment(double amount, String currency) {
        System.out.println("Stripe processing payment: " + amount + " " + currency);
    }
}
