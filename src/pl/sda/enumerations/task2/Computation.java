package pl.sda.enumerations.task2;

public enum Computation {
    MULTIPLY{
        @Override
        public double perform(double x, double y) {
            return x * y;
        }
    },
    DIVIDE{
        @Override
        public double perform(double x, double y) {
            return x / y;
        }
    },
    ADD{
        @Override
        public double perform(double x, double y) {
            return x + y;
        }
    },
    SUBTRACT{
        @Override
        public double perform(double x, double y) {
            return x - y;
        }
    };

    public abstract double perform(double x, double y);

//    public double perform(double x, double y) {
//        return 0.0;
//    }
}
