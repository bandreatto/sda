package pl.sda.enumerations.task2;

public class ComputationService {

    public static void main(String[] args) {
        Computation computation = Computation.MULTIPLY;
        double result = computation.perform(4, 6);
        System.out.println(result);
    }
}
