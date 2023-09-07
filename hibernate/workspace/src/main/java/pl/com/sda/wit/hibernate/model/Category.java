package pl.com.sda.wit.hibernate.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "kategoria")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kategoria")
    private Long id;

    @Column(name = "nazwa")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Book> books;
}
