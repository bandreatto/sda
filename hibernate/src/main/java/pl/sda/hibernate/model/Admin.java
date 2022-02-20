package pl.sda.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Long id;

    // Wykorzystanie adnotacji @Embedded celem osadzenia
    // w obiekcie encji współdzielonych atrybutów.
    @Embedded
    private Poswiadczenia poswiadczenia;
}
