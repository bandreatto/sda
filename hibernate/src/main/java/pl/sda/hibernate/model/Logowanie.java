package pl.sda.hibernate.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "logowanie")
@Data
public class Logowanie {

    // Klucz główny złożony.
    // Klucz główny skłąda się z atrybutów określonych w klasie LogowaneiId.
    // Klucz główny modelowany jest w tym przypadku w oparciu o podejście wykorzystujące
    // adnotację @Embeddable oraz @EmbeddedId.
    @EmbeddedId
    private LogowanieId id;

    @Column(name = "liczba_logowan")
    private Integer liczbaLogowan;
}
