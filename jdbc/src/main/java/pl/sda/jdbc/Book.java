package pl.sda.jdbc;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    private String isbn;

    private String title;

    public Date publicationDate;

    private String format;

    private Double price;
}
