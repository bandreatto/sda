package pl.sda.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SuperBox<T extends Item & Comparable<T>> {

    private T value;
}
