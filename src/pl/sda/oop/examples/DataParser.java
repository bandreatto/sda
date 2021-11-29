package pl.sda.oop.examples;

public abstract class DataParser {

    protected String data;

    public abstract Data parse();

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void validateData() {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data are not valid!");
        }
    }
}
