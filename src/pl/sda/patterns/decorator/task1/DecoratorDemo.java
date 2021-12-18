package pl.sda.patterns.decorator.task1;

import java.util.List;

public class DecoratorDemo {

    public static void main(String[] args) {
        ExecutionTimesBaseStatistics baseStatistics
                = new ExecutionTimesBaseStatistics(List.of(1.2, 2.2, 3.4));
        WithMeanStatisticsLogger statisticsLogger = new WithMeanStatisticsLogger(new WithSummaryStatisticsLogger(baseStatistics));
        statisticsLogger.displayStatistics();
    }
}
