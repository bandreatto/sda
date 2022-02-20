package pl.sda.hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kategoria")
@Data
public class Kategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kategoria")
    private Long id;

    private String nazwa;

    // Mapowanie relacji 1:wiele.
    // W ramach adnotacji @OneToMany wskazujemy pole po przeciwnej stronie relacji
    // (w encji Ksiazka), które referuje do bieżącej encji
    // (w zdecydowanej większości przypadków pole, przy którym znajduje się adnotacja @JoinColumn)
    @OneToMany(mappedBy = "kategoria")
    private List<Ksiazka> ksiazki;
}
