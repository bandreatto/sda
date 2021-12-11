package pl.sda.generics;

public class SuperBoxService {

    public static void main(String[] args) {
        SuperBox<Computer> computerBox = new SuperBox<>(new Computer());
//        SuperBox<Ball> ballBox = new SuperBox<>(new Ball());

        System.out.println(computerBox.getValue());
//        System.out.println(ballBox.getValue());
    }
}
