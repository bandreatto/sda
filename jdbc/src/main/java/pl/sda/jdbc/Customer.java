package pl.sda.jdbc;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Date createdAt;
}
