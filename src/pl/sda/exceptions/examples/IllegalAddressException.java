package pl.sda.exceptions.examples;

public class IllegalAddressException extends Exception {

    public IllegalAddressException(String address) {
        super("Illegal address: " + address);
    }
}
