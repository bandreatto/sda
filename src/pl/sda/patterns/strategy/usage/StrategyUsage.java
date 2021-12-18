package pl.sda.patterns.strategy.usage;

import pl.sda.patterns.strategy.SpacesModificationStrategy;
import pl.sda.patterns.strategy.SpacesModificationStrategyProvider;
import pl.sda.patterns.strategy.StrategyType;

public class StrategyUsage {

    private static final String TEST_VALUE = "t e ststs  ";

    public static void main(String[] args) {
        SpacesModificationStrategyProvider provider = new SpacesModificationStrategyProvider();
        SpacesModificationStrategy strategy = provider.get(StrategyType.DOUBLE);
        System.out.println(strategy.modify(TEST_VALUE));

        strategy = provider.get(StrategyType.REMOVE);
        System.out.println(strategy.modify(TEST_VALUE));

        strategy = provider.get(StrategyType.REPLACE);
        System.out.println(strategy.modify(TEST_VALUE));
    }
}
