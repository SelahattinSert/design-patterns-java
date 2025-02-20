package patterns.design.designpatterns.adapter;

public class Client {

    public static void main(String[] args) {

        PayPalSDK payPalSDK = new PayPalSDK();
        StripeSDK stripeSDK = new StripeSDK();
        FedExAPI fedExAPI = new FedExAPI();
        UPSAPI upsAPI = new UPSAPI();

        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalSDK);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeSDK);
        ShippingService fedExAdapter = new FedExAdapter(fedExAPI);
        ShippingService upsAdapter = new UPSAdapter(upsAPI);

        payPalAdapter.processPayment(100.0, "USD");
        stripeAdapter.processPayment(200.0, "EUR");

        double fedExCost = fedExAdapter.calculateShippingCost("NYC", "LA", 10.0);
        System.out.println("FedEx Shipping Cost: " + fedExCost);

        double upsCost = upsAdapter.calculateShippingCost("NYC", "LA", 10.0);
        System.out.println("UPS Shipping Cost: " + upsCost);
    }
}
