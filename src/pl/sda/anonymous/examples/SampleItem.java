package pl.sda.anonymous.examples;

public class SampleItem {

    public static String name = "Krzys";

    static {
        name = "Adam";
        System.out.println("In static initializing block...");
    }

    public SampleItem() {
        System.out.println("In constructor");
    }

    {
        System.out.println("In initializing block...");
    }

    public static void main(String[] args) {
        SampleItem sampleItem1 = new SampleItem();
        System.out.println("-----");
        SampleItem sampleItem2 = new SampleItem();
        System.out.println("-----");
        SampleItem sampleItem3 = new SampleItem();
    }
}
