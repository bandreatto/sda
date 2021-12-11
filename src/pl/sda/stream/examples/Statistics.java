package pl.sda.stream.examples;

import java.util.List;

public class Statistics {

    private double average;

    private List<Integer> values;

    public Statistics(double average, List<Integer> values) {
        this.average = average;
        this.values = values;
    }

    public double getAverage() {
        return average;
    }

    public List<Integer> getValues() {
        return values;
    }
}
