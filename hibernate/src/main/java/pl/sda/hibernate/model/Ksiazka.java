package pl.sda.hibernate.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ksiazka")
@Data
@ToString(exclude = "kategoria")
public class Ksiazka {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ksiazka")
    private Long id;

    // Kolumna o takiej samej nazwie (w tym przypadku "id_kategoria")
    // nie powinna być wykorzystywana / mapowana wielokrotnie w ramach tej samej encji
    // Ze względu na to, iż kolumnę "id_kategoria" wykorzystujemy podczas
    // modelownia relacji - adnotacja @ManyToOne - musieliśmy zakomentować / usunąć
    // mapowanie tej kolumn to postaci prostego atrybutu / pola o nazwie "kategoriaId.
//    @Column(name = "id_kategoria")
//    private Long kategoriaId;

    private String isbn;

    private String tytul;

    private String autor;

    @Column(name = "stron")
    private Integer liczbaStron;

    private String wydawnictwo;

    @Column(name = "rok_wydania")
    private Integer rokWydania;

    private String opis;

    // Modelowanie relacji 1:wiele od strony wiele.
    // Wskazujemy jawnie nazwę klucza obcego występującegow tabeli "ksiazka".
    // Klucz obcy określany jest przy pomocy adnotacji @JoinColumn i posiada
    // w tym przypadku nazwę: "id_kategoria".
    @ManyToOne
    @JoinColumn(name = "id_kategoria")
    private Kategoria kategoria;
}
