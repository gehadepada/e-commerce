package model;

import java.util.List;

public class CheckoutSummary {
    private final double subtotal;
    private final double shippingFee;
    private final double totalPaid;
    private final double remainingBalance;

    public CheckoutSummary(double subtotal, double shippingFee, double totalPaid,
                           double remainingBalance) {
        this.subtotal = subtotal;
        this.shippingFee = shippingFee;
        this.totalPaid = totalPaid;
        this.remainingBalance = remainingBalance;
    }

    public double getSubtotal() { return subtotal; }
    public double getShippingFee() { return shippingFee; }
    public double getTotalPaid() { return totalPaid; }
    public double getRemainingBalance() { return remainingBalance; }

}
