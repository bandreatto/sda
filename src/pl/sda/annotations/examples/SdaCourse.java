package pl.sda.annotations.examples;

public class SdaCourse {

    private String name;

    @SdaAnnotation("110")
    private int duration;

    @SdaAnnotation("110")
    public SdaCourse(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

//    @Override
//    @SdaAnnotation("110")
    public String getDescription() {
        return "name -> " + name + ", duration -> " + duration;
    }
}
