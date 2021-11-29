package pl.sda.exceptions.task3;

public class Stack {

    private final int[] values;
    private int currentSize;

    public Stack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Illegal size: " + size);
        }

        values = new int[size];
    }

    public void push(int value) {
        if (values.length == currentSize) {
            throw new StackFullException();
        }

        values[currentSize++] = value;
    }

    public int pop() {
        if (currentSize == 0) {
            throw new StackEmptyException();
        }

        return values[--currentSize];
    }

    public void clear() {
        currentSize = 0;
    }

    public int top() {
        if (currentSize == 0) {
            throw new StackEmptyException();
        }

        return values[currentSize - 1];
    }
}
