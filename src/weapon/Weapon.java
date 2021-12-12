package weapon;

public class Weapon {

    private int health;
    private int attack;
    private int defense;
    private int vampirism;
    private int healPower;

    protected Weapon(){}
    protected Weapon(int health, int attack, int defense, int vampirism, int healPower) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.vampirism = vampirism;
        this.healPower = healPower;
    }

    public static Builder builder(){
        return new Builder();
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getVampirism() {
        return vampirism;
    }

    public void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }

    public int getHealPower() {
        return healPower;
    }

    public void setHealPower(int healPower) {
        this.healPower = healPower;
    }

    public static class Builder {
        Builder() {

        }

        private int health;
        private int attack;
        private int defense;
        private int vampirism;
        private int healthPower;

        public Builder withHealth(int health) {
            this.health = health;
            return this;
        }

        public Builder withAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder withDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public Builder withVampirism(int vampirism) {
            this.vampirism = vampirism;
            return this;
        }

        public Builder withHealthPower(int healthPower) {
            this.healthPower = healthPower;
            return this;
        }

        public Weapon build() {
            return new Weapon(this.health, this.attack, this.defense, this.vampirism, this.healthPower);
        }
    }
}
