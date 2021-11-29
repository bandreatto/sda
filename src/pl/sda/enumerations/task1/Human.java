package pl.sda.enumerations.task1;

public class Human {

    private final String name;
    private final int age;
    private final Color eyesColor;
    private final Color hairColor;

    public Human(String name, int age, Color eyesColor, Color hairColor) {
        this.name = name;
        this.age = age;
        this.eyesColor = eyesColor;
        this.hairColor = hairColor;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Color getEyesColor() {
        return eyesColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eyesColor=" + eyesColor +
                ", hairColor=" + hairColor +
                '}';
    }
}
