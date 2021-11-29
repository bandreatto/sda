package pl.sda.oop.examples;

public class CSVParser extends DataParser {

    public Data parse() {
        validateData();
        String[] splitData = data.split(",");
        return new Data(splitData[0], splitData[1]);
    }
}
