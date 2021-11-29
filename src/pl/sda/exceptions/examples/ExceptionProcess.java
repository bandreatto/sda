package pl.sda.exceptions.examples;

public class ExceptionProcess {

    public void validate(String address) throws IllegalAddressException {
        if (address == null || address.isBlank()) {
            throw new IllegalAddressException(address);
        }
    }

    public static void main(String[] args) {
        ExceptionProcess exceptionProcess = new ExceptionProcess();
        String address = "   ";
        try {
            exceptionProcess.validate(address);
        } catch (IllegalAddressException e) {
            System.out.println("Caught IllegalAddressException!!!");
        } catch (Exception e) {
            System.out.println("Caught Exception!!!");
        } finally {
            System.out.println("In section finally!");
        }


//        try {
//            exceptionProcess.validate(address);
//        } catch (IllegalAddressException e) {
//            System.out.println("Caught exception!!!");
//        }
    }
}
