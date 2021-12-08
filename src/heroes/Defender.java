package heroes;

public class Defender extends Warrior {
    private static final int DEFENSE = 2;

    public Defender() {
        super(60, 3);
    }

    protected int getDamage(Attackable w) {
        int attack;
        if (w.getAttack() < DEFENSE)
            attack = 0;
        else
            attack = w.getAttack() - DEFENSE;
        setHealth(getHealth() - attack);
        return attack;
    }
}
