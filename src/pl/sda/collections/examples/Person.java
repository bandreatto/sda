package pl.sda.collections.examples;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {

    private int id;

    private String firstName;

    private String lastName;

    public boolean equals(final Object o) {
        if (o == this) return true;
//        if (!(o instanceof Person)) return false;
        if (o == null || getClass() != o.getClass()) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Person;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        return result;
    }


//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//
//        return id == person.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return id;
//    }

    //    @Override
//    public boolean equals(Object obj) {
//        Person person = (Person) obj;
//        return id == person.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return 0;
////        return id;
//    }
}
