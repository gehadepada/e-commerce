import model.*;
import service.CheckoutService;
import service.ShippingService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = createCustomerWithCart();

        CheckoutService checkoutService = new CheckoutService();

        try {

            printShippingNotice(customer);
            CheckoutSummary summary = checkoutService.checkout(customer);
            printCheckoutReceipt(customer, summary);

        } catch (Exception e) {
            System.out.println("❌ Checkout Error: " + e.getMessage());
        }
    }

    private static Customer createCustomerWithCart() {
        Product cheese = new ShippableProduct("Cheese", 50.0, 10, 2.0);
        Product milk = new ShippableProduct("milk", 1000.0, 3, 15.0);
        Product scratchCard = new Product("Mobile Scratch Card", 10.0, 20);
        List<Shippable> shippableItems=new ArrayList<>();
        shippableItems.add((Shippable)cheese);
        shippableItems.add((Shippable)milk);
       new ShippingService().send(shippableItems);

        Customer customer = new Customer();
        customer.setName("Gehad");
        customer.setBalance(5000.0);
        customer.setCart(new ArrayList<>());

        try {
            customer.addToCart(cheese, 2);
            customer.addToCart(milk, 1);
            customer.addToCart(scratchCard, 3);
        } catch (Exception e) {
            System.out.println("🛒 Error while adding to cart: " + e.getMessage());
        }

        return customer;
    }

    private static void printShippingNotice(Customer customer) {
        System.out.println("\n** 📦 Shipment Notice **");
        double totalWeight = 0;

        for (CartItem item : customer.getCart()) {
            Product product = item.getProduct();
            int quantity = item.getProductQuantity();

            System.out.print(quantity + "x " + product.getName());

            if (product instanceof Shippable) {
                double weight = ((Shippable) product).getWeight() * quantity;
                totalWeight += weight;
                System.out.print(" - " + weight + "kg");
            }

            System.out.println();
        }

        System.out.println("Total shipping weight: " + totalWeight + "kg");
    }


    private static void printCheckoutReceipt(Customer customer, CheckoutSummary summary) {
        System.out.println("\n** 🧾 Checkout Receipt **");

        for (CartItem item : customer.getCart()) {
            Product product = item.getProduct();
            int qty = item.getProductQuantity();
            double total = product.getPrice() * qty;
            System.out.println(qty + "x " + product.getName() + " = $" + total);
        }

        System.out.println("---");
        System.out.println("Subtotal: $" + summary.getSubtotal());
        System.out.println("Shipping: $" + summary.getShippingFee());
        System.out.println("Total Paid: $" + summary.getTotalPaid());
        System.out.println("Remaining Balance: $" + summary.getRemainingBalance());
    }
}
