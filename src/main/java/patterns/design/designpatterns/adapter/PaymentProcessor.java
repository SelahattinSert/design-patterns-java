package patterns.design.designpatterns.adapter;

public interface PaymentProcessor {
    void processPayment(double amount, String currency);
}
