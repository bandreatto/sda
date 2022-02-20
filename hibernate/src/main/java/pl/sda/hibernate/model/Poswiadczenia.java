package pl.sda.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

// Definicja klasy, której obiekty będą wbudowywane w poszczególne
// obiekty encyjne (dzięki wykorzystaniu adnotacji @Embeddable).
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Poswiadczenia implements Serializable {

    private String login;

    private String haslo;
}
