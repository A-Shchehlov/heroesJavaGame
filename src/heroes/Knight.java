package heroes;

import weapon.Weapon;

public class Knight extends Warrior {

    public Knight() {

        super(50, 7);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
    }
}
