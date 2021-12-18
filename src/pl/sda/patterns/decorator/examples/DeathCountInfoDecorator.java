package pl.sda.patterns.decorator.examples;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeathCountInfoDecorator implements FragStatistics {

    private final FragStatistics fragStatistics;

    @Override
    public int incrementFragCount() {
        return fragStatistics.incrementFragCount();
    }

    @Override
    public int incrementDeathCount() {
        System.out.println("Fragged by an enemy!!!");
        return fragStatistics.incrementDeathCount();
    }

    @Override
    public void reset() {
        fragStatistics.reset();
    }
}
