package tech.bts;

public class Suspect {

    private String name;
    private int age;
    private double height;
    private double weight;
    private String hairColor;
    private String eyeColor;
    private boolean male;

    public Suspect(String name, int age, double height, double weight, String hairColor, String eyeColor, boolean male) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isMale() {
        return male;
    }
}
