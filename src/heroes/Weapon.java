package heroes;

public interface Weapon {
    int getHealth();

    int getAttack();

    int getDefense();

    int getVampirism();

    int getHealPower();

    static Weapon getWeapon(int health, int attack, int defense, int vampirism, int healPower) {
        return new Weapon() {
            @Override
            public int getHealth() {
                return health;
            }

            @Override
            public int getAttack() {
                return attack;
            }

            @Override
            public int getDefense() {
                return defense;
            }

            @Override
            public int getVampirism() {
                return vampirism;
            }

            @Override
            public int getHealPower() {
                return healPower;
            }
        };
    }

    enum PredefinedWeapon implements Weapon {
        GREAT_AXE {{
            health = -15;
            attack = 5;
            defense = -2;
            vampirism = 10;
        }},
        KATANA {{
            health = -20;
            attack = 6;
            defense = -5;
            vampirism = 50;
        }},
        MAGIC_WAND {{
            health = 30;
            attack = 3;
            healthPower = 3;
        }},
        SHIELD {{
            health = 20;
            attack = -1;
            defense = 2;
        }},
        SWORD {{
            health = 5;
            attack = 2;
        }};


        int health;
        int attack;
        int defense;
        int vampirism;
        int healthPower;

        @Override
        public int getHealth() {
            return health;
        }

        @Override
        public int getAttack() {
            return attack;
        }

        @Override
        public int getDefense() {
            return defense;
        }

        @Override
        public int getVampirism() {
            return vampirism;
        }

        @Override
        public int getHealPower() {
            return healthPower;
        }
    }

    ;

    static Builder builder() {
        return new Weapon.Builder();
    }

    class Builder {
        Builder() {
        }

        int health;
        int attack;
        int defense;
        int vampirism;
        int healPower;

        public Builder withAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder withHealth(int health) {
            this.health = health;
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
            this.healPower = healthPower;
            return this;
        }

        public Weapon build() {
            return new Weapon() {
                @Override
                public int getHealth() {
                    return health;
                }

                @Override
                public int getAttack() {
                    return attack;
                }

                @Override
                public int getDefense() {
                    return defense;
                }

                @Override
                public int getVampirism() {
                    return vampirism;
                }

                @Override
                public int getHealPower() {
                    return healPower;
                }
            };
        }
    }

}

