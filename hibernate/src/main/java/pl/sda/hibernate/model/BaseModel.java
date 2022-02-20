package pl.sda.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

// Wykorzystanie adnotacji @MapperSuperclass
// celem współdzielnie atrybutów na poziomie poszczególnych encji.
// W ramach współdzielenia atrybutów wykorzystujemy mechanizm dziedziczenia.
@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
