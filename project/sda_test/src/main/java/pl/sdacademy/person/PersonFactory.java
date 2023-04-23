package pl.sdacademy.person;

class PersonFactory {

    public Person createPerson(String firstName, String lastName) {
        String prefix = firstName.endsWith("a") ? "Ms" : "Mr";
        return new Person(prefix, firstName, lastName);
    }
}
