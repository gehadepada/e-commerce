import java.util.Date;

public class ExpirableProduct extends Product implements Expirable {
    Date expiryDate;

    ExpirableProduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;

    }

    @Override
    public boolean isExpired() {
        return new Date().after(expiryDate);
    }
}
