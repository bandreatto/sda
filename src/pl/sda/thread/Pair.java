package pl.sda.thread;

public class Pair {

    private Integer left;

    private Integer right;

    public Pair(Integer left, Integer right) {
        this.left = left;
        this.right = right;
    }

    public void incrementLeft() {
        System.out.println("Out of synchronized block (increment left) - 1");
        synchronized (this) {
            left++;
        }
        System.out.println("Out of synchronized block (increment left) - 2");
    }

    public void incrementRight() {
        System.out.println("Out of synchronized block (increment right) - 1");
        synchronized (this) {
            right++;
        }
        System.out.println("Out of synchronized block (increment right) - 2");
    }

    public Integer getLeft() {
        return left;
    }

    public Integer getRight() {
        return right;
    }
}
