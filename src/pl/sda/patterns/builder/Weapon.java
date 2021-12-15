package pl.sda.patterns.builder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Weapon {

    private String type;
    private String name;
    private Integer damage;
    private Long durability;
    private List<String> perks;

    public static class Builder {
        private String type;
        private String name;
        private Integer damage;
        private Long durability;
        private List<String> perks;

        public Builder(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDamage(Integer damage) {
            this.damage = damage;
            return this;
        }

        public Builder withDurability(Long durability) {
            this.durability = durability;
            return this;
        }

        public Builder withPerks(List<String> perks) {
            this.perks = perks;
            return this;
        }

        public Weapon build() {
            return new Weapon(type, name, damage, durability, perks);
        }
    }
}
