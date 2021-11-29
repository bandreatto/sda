package pl.sda.oop.examples;

public class Car {

    protected void turnOnEngine() {
        System.out.println("Turn on engine!!!");
    }

    public static void main(String[] args) {
        SportCar sportCar = new SportCar();
        sportCar.turnOnEngine();
        System.out.println("-----");
        sportCar.drive();
        System.out.println("-----");
        Truck truck = new Truck();
        truck.drive(sportCar);
    }
}
