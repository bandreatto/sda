package pl.sda.exceptions.task2;

public class UzupelniaczAdresu {

    public static void main(String[] args) throws NieprawidlowyAdresException {
        Adres adres = new Adres("Iwaszkiewicza", -5, null, "Poznan");
        System.out.println(adres);
    }
}
