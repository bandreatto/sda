package pl.sda.patterns.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ComputerGame {

    private final String name;
    private final PegiAgeRating pegiAgeRating;
    private final Double budgetInMillionsOfDollars;
    private final Integer minimumGpuMemoryInMegabytes;
    private final Integer diskSpaceNeededInGB;
    private final Integer ramNeededInGB;
    private final Integer coresNeeded;
    private final Double coreSpeedInGhz;
}
