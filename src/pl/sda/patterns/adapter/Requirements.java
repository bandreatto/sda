package pl.sda.patterns.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Requirements {

    private final Integer gpuGb;
    private final Integer HDDGb;
    private final Integer RAMGb;
    private final Double cpuGhz;
    private final Integer coresNum;
}
