package pl.sda.patterns.builder;

import java.util.List;

public class WeaponService {

    public static void main(String[] args) {
        Weapon.Builder builder = new Weapon.Builder("x", "nameX");
        Weapon weapon1 = builder
                .withType("type1")
                .withName("name1")
                .build();

        Weapon weapon2 = builder
                .withType("type2")
                .withDamage(100)
                .withDurability(1L)
                .build();

        Weapon weapon3 = builder
                .withDurability(2L)
                .withName("name3")
                .withType("type3")
                .withDamage(50)
                .withPerks(List.of("1", "2", "3"))
                .build();


    }
}
