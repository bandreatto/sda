package pl.sda.functional.examples;

import lombok.Getter;
import lombok.Setter;

public class ExecutorImpl implements Executor, Drawable {

    @Setter
    @Getter
    private String name;

    @Override
    public void executor(int x) {
        System.out.println("In executor(int x) ... (ExecutorImpl): "
                + "x = " + x);
    }

    @Override
    public void executor(int x, int y) {
        Executor.super.executor(x, y);
        System.out.println(".... In executor(int x, int y) of ExecutorImpl");
    }
}
