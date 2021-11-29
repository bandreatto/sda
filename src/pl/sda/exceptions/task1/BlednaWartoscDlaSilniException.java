package pl.sda.exceptions.task1;

public class BlednaWartoscDlaSilniException extends Exception {

    public BlednaWartoscDlaSilniException(int n) {
        super("Invalid parameter: " + n);
    }
}
