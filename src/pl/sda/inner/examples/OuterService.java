package pl.sda.inner.examples;

public class OuterService {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        Outer.NestedStatic nestedStatic = new Outer.NestedStatic();
    }
}
