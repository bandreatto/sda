package pl.sda.exceptions.task2;

public class Adres {

    private String ulica;

    private int numerDomu;

    private String kodPocztowy;

    private String miasto;

    public Adres(String ulica, int numerDomu, String kodPocztowy, String miasto) throws NieprawidlowyAdresException {
        validate(ulica, numerDomu, kodPocztowy, miasto);

        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
    }

    private void validate(String ulica, int numerDomu, String kodPocztowy, String miasto)
            throws NieprawidlowyAdresException{
        String komunikatBledu = "";

        if (ulica == null) {
            // bład
            komunikatBledu += "Ulica nie moze byc nullem! ";
        }

        if (numerDomu <= 0) {
            // bład
            komunikatBledu += "Numer domu nie moze byc ujemny! ";
        }

        if (kodPocztowy == null) {
            // bład
            komunikatBledu += "Kod pocztowy nie moze byc nullem! ";
        }

        if (miasto == null) {
            // bład
            komunikatBledu += "Miasto nie moze byc nullem! ";
        }

        if (!komunikatBledu.isEmpty()) {
            throw new NieprawidlowyAdresException(komunikatBledu);
        }
    }

    @Override
    public String toString() {
        return "Adres{" +
                "ulica='" + ulica + '\'' +
                ", numerDomu=" + numerDomu +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", miasto='" + miasto + '\'' +
                '}';
    }
}
