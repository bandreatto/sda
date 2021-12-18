package pl.sda.patterns.decorator.task1;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class WithMeanStatisticsLogger implements StatisticsLogger {

    private final StatisticsLogger statisticsLogger;

    @Override
    public void displayStatistics() {
        // wyznaczenie sredniej
        List<Double> executionTimes = getExecutionTimes();
        int size = executionTimes.size();
//        Double sum = statisticsLogger.getExecutionTimes().stream()
//                .reduce(0., Double::sum);

        double sum = executionTimes.stream().mapToDouble(x -> x)
                .sum();
        System.out.println("Mean = " + sum / size);

        statisticsLogger.displayStatistics();
    }

    @Override
    public List<Double> getExecutionTimes() {
        return statisticsLogger.getExecutionTimes();
    }
}
