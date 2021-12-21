package heroes;

import java.util.Objects;

public class Succubus extends Warrior {
    Succubus() {
        super(30, 3);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
    }

    @Override
    public void attack(Warrior w) {
        int damage = w.getDamage(this);
        attackNext(damage, w.getBehind());
        super.transmitSignal();
    }

    private void attackNext(int damage, Warrior w) {
        Warrior next;
        if (Objects.nonNull(w) && Objects.nonNull(w.getBehind())) {
            next = w.getBehind();

            if (Objects.nonNull(next)) {
                next.getDamage(new Attackable() {
                    @Override
                    public int getAttack() {
                        return damage;
                    }
                });
                attackNext(damage, next.getBehind());
            }
        }
    }
}
