package pl.sda.functional.examples;

public class ExecutorService {

    static void testExecutor(Executor executor) {
        executor.executor(5);
        System.out.println("-------------");
        executor.executor(2, 3);
    }

    static void sampleExecutor(int x) {
        System.out.println("In sample executor.... ;-) : x = " + x);
    }

    public static void main(String[] args) {
        // 1.
        ExecutorImpl executor = new ExecutorImpl();
        testExecutor(executor);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        // 2.
        testExecutor(new Executor() {
            @Override
            public void executor(int x) {
                System.out.println("In anonymous class....: x = " + x);
            }
        });

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        // 3
        testExecutor(x -> System.out.println("In lambda expression...: x = " + x));

        // 4
//        testExecutor(p -> {
//            throw new IllegalArgumentException();
//        });

        // 5
        Executor lambdaExecutor = p -> System.out.println("In lambda expression... local variable");

        // 6
//        Executor testExecutor = p -> ExecutorService.sampleExecutor(p);
        Executor testExecutor = ExecutorService::sampleExecutor;
        testExecutor(testExecutor);
//        testExecutor(ExecutorService::sampleExecutor);

        // 7
        ExecutorProvider executorProvider = new ExecutorProvider();
        Executor extraExecutor = executorProvider::provide;


    }
}
