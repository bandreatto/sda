package pl.sda.interfaces.task1;

public class MovableService {

    public static void main(String[] args) {
        Movable center = new MovablePoint(3, 4, 1, 2);
        MovableCircle circle = new MovableCircle(center, 10);
        System.out.println(circle);
        System.out.println("----------------");
        circle.moveUp();
        circle.moveRight();
        System.out.println(circle);
    }
}
