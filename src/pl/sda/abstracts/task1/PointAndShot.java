package pl.sda.abstracts.task1;

public class PointAndShot extends DigitalCamera {

    public PointAndShot(String make, String model, double megapixels, double price) {
        super(make, model, megapixels, price);
    }

    @Override
    void describe() {
        System.out.println("make -> " + getMake());
        System.out.println("model -> " + getModel());
        System.out.println("megapixels -> " + getMegapixels());
        System.out.println("price -> " + getPrice());
    }

    public static void main(String[] args) {
        DigitalCamera camera = new PointAndShot("olympus", "FE-170", 6.0, 119.50);
        camera.describe();
    }
}
