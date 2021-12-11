package heroes;

public class Vampire extends Warrior {
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40, 4);
    }

    public void attack(Warrior w) {
        int damage = w.getDamage(this);
        restoreHealth(damage);
    }

    private void restoreHealth(int damage) {
        setHealth(getHealth() + damage * VAMPIRISM / 100);
        if (getHealth() > 40) {
            setHealth(40);
        }
    }
}

