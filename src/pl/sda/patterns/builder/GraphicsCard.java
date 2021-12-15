package pl.sda.patterns.builder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GraphicsCard {

    private int memoryInMb;
    private String producer;
    private String series;
    private String modelName;
}
