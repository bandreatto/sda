package pl.sda.patterns.decorator.examples;

public class DecoratorUsage {

    public static void main(String[] args) {
        FragStatistics fragStatistics = new FirstPersonShooterFragStatistics();
        fragStatistics.incrementFragCount();
        fragStatistics.incrementDeathCount();

        fragStatistics = new DeathCountInfoDecorator(new DisplayCounterDecorator(fragStatistics));

        fragStatistics.incrementDeathCount();
        fragStatistics.incrementFragCount();
        fragStatistics.reset();
    }
}
