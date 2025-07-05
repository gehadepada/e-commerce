package exception;

public enum ErrorType {
    CART_IS_EMPTY("Cart is empty"),
    INSUFFICIENT_BALANCE("Customer's balance is insufficient"),
    PRODUCT_EXPIRED("Product is expired"),
    OUT_OF_STOCK("Requested quantity exceeds available stock"),
    QUANTITY_MUST_BE_POSITIVE("Quantity must be greater than 0");

  public String message;

    ErrorType(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
