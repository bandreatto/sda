package pl.sda.oop.task1;

public class Cylinder extends Circle {

    private double height = 1.0;

    public Cylinder() {

    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getVolume() {
        // area x height
        double area = getArea();
        return area * height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        String superString = super.toString();
        return superString + "Cylinder{" +
                "height=" + height +
                '}';
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3, 5);
        double volume = cylinder.getVolume();
        System.out.println("Volume: " + volume);
        System.out.println(cylinder.toString());
    }
}
