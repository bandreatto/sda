package pl.com.sda.wit.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "czytelnik")
@Getter
@Setter
@ToString
public class Reader {

    @Id
    @Column(name = "id_czytelnik")
    private Long id;

    private String login;

    @Column(name = "haslo")
    private String password;

    @Column(name = "imie")
    private String firstName;

    @Column(name = "nazwisko")
    private String lastName;

    private String email;

    @Column(name = "telefon")
    private String phone;
}

