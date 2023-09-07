package pl.com.sda.wit.hibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bibliotekarz")
@Getter
@Setter
@ToString
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bibliotekarz")
    private Long id;

    private String login;

    @Column(name = "haslo")
    private String password;
}
