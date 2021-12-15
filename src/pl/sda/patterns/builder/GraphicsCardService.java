package pl.sda.patterns.builder;

public class GraphicsCardService {

    public static void main(String[] args) {
        GraphicsCard.GraphicsCardBuilder builder = GraphicsCard.builder();
        GraphicsCard graphicsCard = builder.series("series1").memoryInMb(100).modelName("model1").build();

    }
}
