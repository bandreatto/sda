package pl.sda.wit.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date createAt;

//    public Customer(Long id, String firstName, String lastName, String email, String phone, Date createAt) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phone = phone;
//        this.createAt = createAt;
//    }
}
