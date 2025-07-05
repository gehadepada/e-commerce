package model;

public class CartItem {
    Product product ;
    int productQuantity;
    CartItem(Product product , int productQuantity)
    {
        this.product=product;
        this.productQuantity=productQuantity;
    }
}
