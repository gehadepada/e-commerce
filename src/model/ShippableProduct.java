package model;

public class ShippableProduct extends Product implements Shippable{
    private double weightInKg;
   public ShippableProduct(String name , double price , int quantity ,double weightInKg)
    {
        super(name , price ,  quantity);
        this.weightInKg=weightInKg;
    }

    @Override
    public double getWeight() {
        return weightInKg;
    }

    @Override
    public String getName() {
        return super.getName();
    }



}
