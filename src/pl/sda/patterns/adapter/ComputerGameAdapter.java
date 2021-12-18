package pl.sda.patterns.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComputerGameAdapter implements PCGame {

    private final ComputerGame computerGame;

    @Override
    public String getTitle() {
        return computerGame.getName();
    }

    @Override
    public Integer getPegiAllowedAge() {
        switch (computerGame.getPegiAgeRating()) {
            case P3:
                return 3;
            case P7:
                return 7;
            case P12:
                return 12;
            case P16:
                return 16;
            default:
                return 18;
        }
    }

    @Override
    public boolean isTrippleAGame() {
        return computerGame.getBudgetInMillionsOfDollars() > 50.0;
    }

    @Override
    public Requirements getRequirements() {
        return new Requirements(computerGame.getMinimumGpuMemoryInMegabytes() / 1024,
                computerGame.getDiskSpaceNeededInGB(), computerGame.getRamNeededInGB(),
                computerGame.getCoreSpeedInGhz(), computerGame.getCoresNeeded());
    }
}
