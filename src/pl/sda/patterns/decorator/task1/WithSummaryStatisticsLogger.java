package pl.sda.patterns.decorator.task1;

import lombok.AllArgsConstructor;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@AllArgsConstructor
public class WithSummaryStatisticsLogger implements StatisticsLogger {

    private final StatisticsLogger statisticsLogger;

    @Override
    public void displayStatistics() {
        // wyznaczenie statystyk
        List<Double> executionTimes = getExecutionTimes();
        // 1
//        Double min = executionTimes.stream().reduce(Double.MAX_VALUE,
//                (minValue, time) -> minValue > time ? time : minValue);

        // 2
//        Double min = Double.MAX_VALUE;
//        for (Double time : executionTimes) {
//            if (min > time) {
//                min = time;
//            }
//        }
//
//        System.out.println("Min value = " + min);

        // 3
        DoubleSummaryStatistics summaryStatistics = executionTimes.stream().mapToDouble(x -> x)
                .summaryStatistics();
        System.out.println("Liczba rekordów: " + summaryStatistics.getCount());
        System.out.println("Suma: " + summaryStatistics.getSum());
        System.out.println("Minimum: " + summaryStatistics.getMin());
        System.out.println("Maximum: " + summaryStatistics.getMax());

        statisticsLogger.displayStatistics();
    }

    @Override
    public List<Double> getExecutionTimes() {
        return statisticsLogger.getExecutionTimes();
    }
}
