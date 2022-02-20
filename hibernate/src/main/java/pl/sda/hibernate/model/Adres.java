package pl.sda.hibernate.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "adres")
@Data
// W ramach implementacji metody toString pomijamy atrybut "czytelnik".
// Szczególnie istotne w przypadku dwutronnych relacji 1:1 lub 1:wiele
// (celem uniknięcie wyjątku StackOverflowException wynikającego z zapętlenia).
@ToString(exclude = "czytelnik")
public class Adres {

    @Id
    // Definicja klucza głównego tabeli.
    // Kluczem głównym tabeli jest kolumna "id_czytelnik".
    @Column(name = "id_czytelnik")
    private Long id;

    private String adres;

    private String miasto;

    private String wojewodztwo;

    // Zmienna "kodPocztowy" mapuje się w bazie danych na kolumnę "kod_pocztowy"
    @Column(name = "kod_pocztowy")
    private String kodPocztowy;

    // Modelowanie relacji 1:1
    // Wykorzystujemy w tym celu kolumnę (klucz obcy) o nazwie "id_czytelnik"
    // w tabeli "adres".
    @OneToOne
    @JoinColumn(name = "id_czytelnik")
    private Czytelnik czytelnik;
}
