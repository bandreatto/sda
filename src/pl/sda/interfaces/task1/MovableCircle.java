package pl.sda.interfaces.task1;

public class MovableCircle implements Movable {

    private int radius;

    private Movable center;

    public MovableCircle(Movable center, int radius) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
