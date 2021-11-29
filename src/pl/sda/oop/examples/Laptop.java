package pl.sda.oop.examples;

public class Laptop extends Computer {

    private int battery;

    public Laptop(String cpu, String ram, String gpu, int battery) {
        super(cpu, ram, gpu);
        this.battery = battery;
    }

    public void configure() {
        System.out.println("Configure battery: " + battery);
        super.configure();
    }

    public static void main(String[] args) {
        Laptop laptop = new Laptop("1cpu", "2ram", "3gpu", 11);
        laptop.configure();
    }
}
