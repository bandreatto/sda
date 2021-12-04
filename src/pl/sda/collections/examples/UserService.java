package pl.sda.collections.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserService {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Piotr", 20));
        users.add(new User("Kazimierz", 67));
        users.add(new User("Jan", 23));

//        Collections.sort(users);
        Collections.sort(users, Comparator.reverseOrder());

//        Collections.sort(users, new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        for (User user : users) {
            System.out.println(user);
        }
    }
}
