package heroes;

public class Vampire extends Warrior {

    private int vampirism = 50;

    public Vampire() {
        super(40, 4);
    }

    private int getVampirism() {
        return vampirism;
    }

    private void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }

    @Override
    public void attack(Warrior w) {
        int damage = w.getDamage(this);
        restoreHealth(damage);
        super.transmitSignal();
    }

    private void restoreHealth(int damage) {
        setHealth(getHealth() + damage * vampirism / 100);
        if (getHealth() > 40) {
            setHealth(40);
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        this.setVampirism(Math.max(this.getVampirism()+ weapon.getVampirism(), 0));
    }
}

