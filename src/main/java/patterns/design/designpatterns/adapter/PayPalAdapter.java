package patterns.design.designpatterns.adapter;

public class PayPalAdapter implements PaymentProcessor{

    private final PayPalSDK payPalSDK;

    public PayPalAdapter(PayPalSDK payPalSDK) {
        this.payPalSDK = payPalSDK;
    }

    @Override
    public void processPayment(double amount, String currency) {
        payPalSDK.pay(amount, currency);
    }
}
