package pl.sda.patterns.decorator.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class ExecutionTimesBaseStatistics implements StatisticsLogger {

    @Getter
    private final List<Double> executionTimes;

    @Override
    public void displayStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        executionTimes.forEach(time -> {
            stringBuilder.append("Execution time: ")
                    .append(time).append("\n");
        });
        System.out.println(stringBuilder.toString());
    }

//    @Override
//    public List<Double> getExecutionTimes() {
//        return executionTimes;
//    }
}
