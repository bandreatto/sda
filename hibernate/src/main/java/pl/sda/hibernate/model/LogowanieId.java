package pl.sda.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

// Definicja złożonego klucza głównego.
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogowanieId implements Serializable {

    @Column(name = "id_uczen")
    private Long uczenId;

    @Column(name = "id_system")
    private Long systemId;
}
