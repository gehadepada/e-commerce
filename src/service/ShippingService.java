package service;

import model.Shippable;

import java.util.List;

public class ShippingService {

    public void send(List<Shippable> items) {

        System.out.println("All Shipping items:");

        for (Shippable item : items) {
            System.out.println("- " + item.getName() + " (" + item.getWeight() + "kg)");
        }

        System.out.println(" All shippable items sent to ShippingService.");
    }
}
