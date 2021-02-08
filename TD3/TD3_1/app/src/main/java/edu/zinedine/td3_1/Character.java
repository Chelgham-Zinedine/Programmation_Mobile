package edu.zinedine.td3_1;

public class Character {
    private String name;
    private String description;
    private int pictureNumber;

    public Character(String name, String description,int pictureNumber){
        this.name=name;
        this.description=description;
        this.pictureNumber=pictureNumber;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPictureNumber() {
        return pictureNumber;
    }

    public String toString(){
        return "Nom= " + name + "\ndescription : " + description;
    }
}
