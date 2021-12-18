package pl.sda.patterns.strategy;

public class SpacesModificationStrategyProvider {

    public SpacesModificationStrategy get(StrategyType strategyType) {
        switch (strategyType) {
            case DOUBLE:
                return new DoubleSpacesStrategy();
            case REMOVE:
                return new RemoveSpacesStrategy();
            default:
                return new ReplaceWithUnderscoreStrategy();
        }
    }
}
