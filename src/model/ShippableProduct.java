package model;

public class ShippableProduct extends Product implements Shippable{
    double weightInKg;
    ShippableProduct(String name , double balance , int quantity ,double weightInKg)
    {
        super(name , balance ,  quantity);
        this.weightInKg=weightInKg;
    }

    @Override
    public double getWeight() {
        return weightInKg;
    }

    @Override
    public String getName() {
        return name;
    }



}
