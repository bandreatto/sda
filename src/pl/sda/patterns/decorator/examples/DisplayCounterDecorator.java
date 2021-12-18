package pl.sda.patterns.decorator.examples;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DisplayCounterDecorator implements FragStatistics {

    private final FragStatistics fragStatistics;

    @Override
    public int incrementFragCount() {
        int fragCount = fragStatistics.incrementFragCount();
        System.out.println("Your frag count is now: " + fragCount);
        return fragCount;
    }

    @Override
    public int incrementDeathCount() {
        int deathCount = fragStatistics.incrementDeathCount();
        System.out.println("Yout death count is now: " + deathCount);
        return deathCount;
    }

    @Override
    public void reset() {
        fragStatistics.reset();
        System.out.println("Stats reset - KDR is equal to 0");
    }
}
