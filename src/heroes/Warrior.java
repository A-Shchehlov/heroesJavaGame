package heroes;

public class Warrior {
    public static Warrior of(String clazz) {
        switch (clazz) {
            case "Warrior":
                return new Warrior();
            case "Knight":
                return new Knight();
            default:
                throw new IllegalArgumentException("Unknown class name : " + clazz);
        }
    }

    protected int health;
    protected int attack;

    public Warrior() {
        this(50, 5);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    protected int getHealth() {
        return health;
    }

    private void setHealth(int hp) {
        this.health = hp;
    }

    protected int getAttack() {
        return attack;
    }

    public void attack(Warrior w) {
        w.getDamage(this);
    }

    protected int getDamage(Warrior w) {
        setHealth(getHealth() - w.getAttack());
        return w.getAttack();
    }

    public boolean isAlive() {
        return health > 0;
    }
}

