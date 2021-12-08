package heroes;

public class Lancer extends Warrior {

    private static final int WEAKENING = 50;

    public Lancer() {
        super(50, 6);
    }

    public void attack(Warrior w) {
        int damage = w.getDamage(this);
        int damageForSecond = damage * WEAKENING / 100;
        attackNext(damageForSecond, w);
    }

    private void attackNext(int damage, Warrior w) {
        w.getBehind().getDamage(new Attackable() {
            @Override
            public int getAttack() {
                return damage;
            }
        });
    }
}
