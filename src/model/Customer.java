package model;

import exception.CartOperationException;
import exception.ErrorType;

import java.util.List;

public class Customer {
    private String name;
    private double balance;
    private List<CartItem> cart;

    public void addToCart(Product product, int productQuantity) {
        if (productQuantity <= 0) {
            throw new CartOperationException(ErrorType.QUANTITY_MUST_BE_POSITIVE);
        }

        if (product instanceof Expirable && (((Expirable) product).isExpired())) {
            throw new CartOperationException(ErrorType.PRODUCT_EXPIRED);

        }
        if (product.getQuantity() < productQuantity) {
            throw new CartOperationException(ErrorType.OUT_OF_STOCK);
        }

        cart.add(new CartItem(product, productQuantity));

    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }
}
