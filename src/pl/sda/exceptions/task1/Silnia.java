package pl.sda.exceptions.task1;

public class Silnia {

    public static int oblicz(int n) throws BlednaWartoscDlaSilniException {
        if (n < 0) {
            throw new BlednaWartoscDlaSilniException(n);
        }

        if (n == 0) {
            return 1;
        }

        return n * oblicz(n - 1);
    }

    public static void main(String[] args) {
        try {
            int wynik = oblicz(-1);
            System.out.println("wynik = " + wynik);
        } catch (BlednaWartoscDlaSilniException e) {
            e.printStackTrace();
        } finally {
            System.out.println("In finally...");
        }
    }
}
