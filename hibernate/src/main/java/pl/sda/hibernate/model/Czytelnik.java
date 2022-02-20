package pl.sda.hibernate.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "czytelnik")
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
// Zastąpienie poszczególnych adnotacji z biblioteki Lombok jedną adnotacją: "@Data".
@Data
public class Czytelnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_czytelnik")
    private Long id;

    private String login;

    private String haslo;

    private String imie;

    private String nazwisko;

    private String email;

    private String telefon;

    // Mapowanie relacji 1:1.
    // Relacja łącząca encję Czytelnik z encją Adres jest relacją dwustronną.
    // W przypadku relacji dwustronnej, musimy wskazać pole po drugiej stronie Encji
    // mapującej te pole (w tym przypadku pole ma nazwę: "czytelnik").
    // W zdecydowanej większości przypadków jest to pole, przy którym
    // umiejscowiona jest adnotacja @JoinColumn.
    // Uwaga!!!
    // To jest nazwa pola w klasie. To nie jest nazwa kolumny w tabli bazy danych!!!
    @OneToOne(mappedBy = "czytelnik")
    private Adres adres;
}
