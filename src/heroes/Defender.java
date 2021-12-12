package heroes;

import weapon.Weapon;

public class Defender extends Warrior {
    private int defense = 2;

    public Defender() {
        super(60, 3);
    }

    protected int getDamage(Attackable w) {
        int attack;
        if (w.getAttack() < defense) {
            attack = 0;
        } else {
            attack = w.getAttack() - defense;
        }
        setHealth(getHealth() - attack);
        return attack;
    }

    private int getDefense() {
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        this.setDefense(Math.max(this.getDefense() + weapon.getDefense(), 0));
    }
}
