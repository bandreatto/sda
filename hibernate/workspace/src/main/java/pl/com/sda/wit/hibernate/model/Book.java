package pl.com.sda.wit.hibernate.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ksiazka")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ksiazka")
    private Long id;

    private String isbn;

    @Column(name = "tytul")
    private String title;

    @Column(name = "autor")
    private String author;

    @Column(name = "stron")
    private int pages;

    @Column(name = "opis")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_kategoria")
    private Category category;
}
