package exception;

public class CheckoutExceptions extends RuntimeException {
    ErrorType checkoutError;

    public CheckoutExceptions(ErrorType checkoutEError) {
        super(checkoutEError.getMessage());
        this.checkoutError = checkoutEError;
    }

    public ErrorType getError() {
        return checkoutError;
    }
}
