package heroes;

import weapon.Weapon;

public class Rookie extends Warrior{
    public Rookie() {
        super(50, 1);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
    }
}
