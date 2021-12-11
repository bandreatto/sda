package pl.sda.generics;

import java.util.ArrayList;
import java.util.List;

public class BoxService {

    public static void main(String[] args) {
//        var name = "Bartosz";
//        var age = 21;
//        var list;
//        list = new ArrayList<String>();

        Box<String> stringBox = new Box<>();
        var stringBox2 = new Box<String>();

        stringBox.setItem("ball");
//        stringBox.setItem(12);
        System.out.println(stringBox.getItem());

//        Box<Number> box = new Box<Integer>();
//        List<Number> list = new ArrayList<Integer>();
    }
}
