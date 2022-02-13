package pl.sda.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "czytelnik")
@Getter
@Setter
@ToString
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
}
