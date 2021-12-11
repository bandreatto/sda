package pl.sda.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NumberBox<T extends Number> {

    private T value;
}
