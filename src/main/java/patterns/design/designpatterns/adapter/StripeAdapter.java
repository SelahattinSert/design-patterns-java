package patterns.design.designpatterns.adapter;

public class StripeAdapter implements PaymentProcessor{

    private final StripeSDK stripeSDK;

    public StripeAdapter(StripeSDK stripeSDK) {
        this.stripeSDK = stripeSDK;
    }

    @Override
    public void processPayment(double amount, String currency) {
        stripeSDK.makePayment(amount, currency);
    }
}
