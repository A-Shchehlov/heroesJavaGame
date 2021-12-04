package heroes;

public class Defender extends Warrior {
    private static int defense = 2;

    private void setHealth(int hp) {
        health = hp;
    }
    public Defender() {
        super(60, 3);
    }

    protected int getDamage(Warrior w) {
        int attack;
        if(w.getAttack()<defense)
            attack = 0;
        else
            attack = w.getAttack()-defense;
        setHealth(getHealth() - attack);
        return attack;
    }
}
