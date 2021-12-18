package pl.sda.patterns.adapter;

public interface PCGame {

    String getTitle();
    Integer getPegiAllowedAge();
    boolean isTrippleAGame();
    Requirements getRequirements();
}
