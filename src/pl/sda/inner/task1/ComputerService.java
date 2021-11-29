package pl.sda.inner.task1;

public class ComputerService {

    public static void main(String[] args) {
        Computer.ComputerBuilder builder = new Computer.ComputerBuilder("hdd1", "ram128");
        builder.setBluetoothEnabled(true);

        Computer computer = builder.build();
        System.out.println(computer);
    }
}
