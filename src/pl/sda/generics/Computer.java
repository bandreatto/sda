package pl.sda.generics;

public class Computer extends Item implements Comparable<Computer> {

    @Override
    public int compareTo(Computer o) {
        return 0;
    }
}
