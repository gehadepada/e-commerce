package exception;

public class CartOperationException extends RuntimeException{
     ErrorType cartError;
    public CartOperationException(ErrorType cartError)
    {
        super(cartError.getMessage());
        this.cartError=cartError;
    }
    public ErrorType getError() {
        return cartError;
    }

}
