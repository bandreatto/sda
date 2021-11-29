package pl.sda.inner.task1;

public class Computer {

    private final String hdd;

    private final String ram;

    private final boolean graphicsCardEnabled;

    private final boolean bluetoothEnabled;

    public String getHdd() {
        return hdd;
    }

    public String getRam() {
        return ram;
    }

    public boolean isGraphicsCardEnabled() {
        return graphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return bluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "hdd='" + hdd + '\'' +
                ", ram='" + ram + '\'' +
                ", graphicsCardEnabled=" + graphicsCardEnabled +
                ", bluetoothEnabled=" + bluetoothEnabled +
                '}';
    }

    private Computer(ComputerBuilder builder) {
        this.hdd = builder.hdd;
        this.ram = builder.ram;
        this.graphicsCardEnabled = builder.graphicsCardEnabled;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    public static class ComputerBuilder {

        private final String hdd;

        private final String ram;

        private boolean graphicsCardEnabled;

        private boolean bluetoothEnabled;

        public ComputerBuilder(String hdd, String ram) {
            this.hdd = hdd;
            this.ram = ram;
        }

        public void setGraphicsCardEnabled(boolean graphicsCardEnabled) {
            this.graphicsCardEnabled = graphicsCardEnabled;
        }

        public void setBluetoothEnabled(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
