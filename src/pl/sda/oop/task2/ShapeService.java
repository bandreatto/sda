package pl.sda.oop.task2;

public class ShapeService {

    public static void main(String[] args) {
        Square square = new Square(4, "blue", false);
        System.out.println(square);
        square.setLength(5);
        System.out.println(square);
    }
}
