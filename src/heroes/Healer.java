package heroes;

import weapon.Weapon;

public class Healer extends Warrior {

    public int heal = 2;

    public Healer() {
        super(60, 0);
    }

    private int getHeal() {
        return heal;
    }

    private void setHeal(int heal) {
        this.heal = heal;
    }

    @Override
    public void handleSignalFrom(Warrior w) {
        heal(w);
        super.transmitSignal();
    }

    public void heal(Warrior w) {
        w.setHealth(Math.min(w.getHealth() + heal, w.INITIAL_HEALTH));
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        this.setHealth(Math.max(this.getHealth() + weapon.getHealth(),0));
        this.setHeal(Math.max(this.getHeal() + weapon.getHealPower(), 0));
    }
}
