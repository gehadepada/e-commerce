package service;

import exception.CheckoutExceptions;
import exception.ErrorType;
import model.*;

import java.util.ArrayList;
import java.util.List;

import static constants.ShippingConstants.SHIPPING_RATE_PER_KG;

public class CheckoutService {

    public CheckoutSummary checkout(Customer customer) {
        List<CartItem> cart = customer.getCart();


        if (cart.isEmpty()) {
            throw new CheckoutExceptions(ErrorType.CART_IS_EMPTY);
        }

        double subTotal = 0;
        double shippingFees = 0;

        for (CartItem cartItem : cart) {
            Product product =cartItem.getProduct();

            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                throw new CheckoutExceptions(ErrorType.PRODUCT_EXPIRED);
            }

            if (cartItem.getProductQuantity() > product.getQuantity()) {
                throw new CheckoutExceptions(ErrorType.OUT_OF_STOCK);
            }

            subTotal += (product.getPrice() * cartItem.getProductQuantity());

            if (product instanceof Shippable) {
                shippingFees += (((Shippable) product).getWeight() *cartItem.getProductQuantity()* SHIPPING_RATE_PER_KG);
            }
        }

        double total = subTotal + shippingFees;

        if (customer.getBalance() < total) {
            throw new CheckoutExceptions(ErrorType.INSUFFICIENT_BALANCE);
        }


        customer.setBalance(customer.getBalance() - total);

        for (CartItem item : cart) {
            int remainingQuantity=item.getProduct().getQuantity()-item.getProductQuantity();
            item.getProduct().setQuantity(remainingQuantity);
        }

        cart.clear();

        return new CheckoutSummary(subTotal, shippingFees, total, customer.getBalance());
    }
}
