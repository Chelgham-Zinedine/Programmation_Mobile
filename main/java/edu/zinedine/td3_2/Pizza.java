package edu.zinedine.td3_2;

public class Pizza {
    private String name;
    private double price;
    private int pictureNumber;

    public Pizza(String name, double price, int pictureNumber){
        this.name = name;
        this.price = price;
        this.pictureNumber = pictureNumber;

    }

    public String getName() {
        return name;
    }

    public int getPictureNumber() {
        return pictureNumber;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", pictureNumber=" + pictureNumber +
                '}';
    }
}
