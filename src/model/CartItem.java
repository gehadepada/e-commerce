package model;

public class CartItem {
    private Product product ;
    private int productQuantity;
    CartItem(Product product , int productQuantity)
    {
        this.product=product;
        this.productQuantity=productQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
