package patterns.design.designpatterns.strategy.shipping_strategy;



import patterns.design.designpatterns.strategy.shipping_strategy.packaging.BulkPackaging;
import patterns.design.designpatterns.strategy.shipping_strategy.packaging.GiftWrapping;
import patterns.design.designpatterns.strategy.shipping_strategy.packaging.MinimalPackaging;
import patterns.design.designpatterns.strategy.shipping_strategy.shipping.ExpressShipping;
import patterns.design.designpatterns.strategy.shipping_strategy.shipping.LocalPickup;
import patterns.design.designpatterns.strategy.shipping_strategy.shipping.StandardShipping;

import java.util.Scanner;

public class EcommerceOrderFulfillment {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter order ID: ");
        String orderId = scanner.nextLine();
        Order order = new Order(orderId);

        System.out.println("Choose shipping method:");
        System.out.println("1. Standard Shipping");
        System.out.println("2. Express Shipping");
        System.out.println("3. Local Pickup");

        int shippingChoice = scanner.nextInt();

        switch (shippingChoice) {
            case 1:
                order.setShippingStrategy(new StandardShipping());
                break;
            case 2:
                order.setShippingStrategy(new ExpressShipping());
                break;
            case 3:
                order.setShippingStrategy(new LocalPickup());
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Choose packaging method:");
        System.out.println("1. Minimal Packaging");
        System.out.println("2. Gift Wrapping");
        System.out.println("3. Bull Packaging");
        int packagingChoice = scanner.nextInt();

        switch (packagingChoice) {
            case 1:
                order.setPackagingStrategy(new MinimalPackaging());
                break;
            case 2:
                order.setPackagingStrategy(new GiftWrapping());
                break;
            case 3:
                order.setPackagingStrategy(new BulkPackaging());
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        order.fulfillOrder();

        System.out.println("Would you like to change shipping method? (y/n)");
        char changeShipping = scanner.next().charAt(0);

        if (changeShipping == 'y') {
            System.out.println("Choose new shipping method:");
            System.out.println("1. Standard Shipping");
            System.out.println("2. Express Shipping");
            System.out.println("3. Local Pickup");
            shippingChoice = scanner.nextInt();

            switch (shippingChoice) {
                case 1:
                    order.setShippingStrategy(new StandardShipping());
                    break;
                case 2:
                    order.setShippingStrategy(new ExpressShipping());
                    break;
                case 3:
                    order.setShippingStrategy(new LocalPickup());
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }

            order.fulfillOrder();
        }

        System.out.println("Order process completed");
        scanner.close();
    }
}
