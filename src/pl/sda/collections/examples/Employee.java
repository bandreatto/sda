package pl.sda.collections.examples;

public class Employee extends Person {

    private String card;

    public Employee(int id, String firstName, String lastName, String card) {
        super(id, firstName, lastName);
        this.card = card;
    }
}
