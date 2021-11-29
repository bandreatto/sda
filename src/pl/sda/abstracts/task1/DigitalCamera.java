package pl.sda.abstracts.task1;

public abstract class DigitalCamera {

    private String make;
    private String model;
    private double megapixels;
    private double price;

    public DigitalCamera(String make, String model, double megapixels, double price) {
        this.make = make;
        this.model = model;
        this.megapixels = megapixels;
        this.price = price;
    }

    abstract void describe();

    protected String getMake() {
        return make;
    }

    protected String getModel() {
        return model;
    }

    protected double getMegapixels() {
        return megapixels;
    }

    protected double getPrice() {
        return price;
    }
}
