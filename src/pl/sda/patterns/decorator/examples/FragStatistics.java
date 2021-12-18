package pl.sda.patterns.decorator.examples;

public interface FragStatistics {

    int incrementFragCount();

    int incrementDeathCount();

    void reset();
}
