package pl.sda.oop.task1;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setData(double radius, String color) {
        setRadius(radius);
        setColor(color);
    }

    public Object[] getData() {
        // radius: double -> Double (primitive -> Wrapper)
        return new Object[]{radius, color};
    }

    public double getArea() {
        // 3.14
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
