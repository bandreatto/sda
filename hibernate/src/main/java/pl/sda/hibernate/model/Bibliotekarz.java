package pl.sda.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bibliotekarz")
@Data
public class Bibliotekarz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bibliotekarz")
    private Long id;

    private String login;

    private String haslo;
}
