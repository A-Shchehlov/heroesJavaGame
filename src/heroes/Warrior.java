package heroes;

public class Warrior implements Attackable {
    public static Warrior of(String clazz) {
        switch (clazz) {
            case "Warrior":
                return new Warrior();
            case "Knight":
                return new Knight();
            case "Defender":
                return new Defender();
            case "Vampire":
                return new Vampire();
            case "Lancer":
                return new Lancer();
            default:
                throw new IllegalArgumentException("Unknown class name : " + clazz);
        }
    }

    protected int health;
    protected int attack;

    public void setBehind(Warrior behind) {
        this.behind = behind;
    }

    public Warrior getBehind() {
        return behind;
    }

    private Warrior behind;

    public Warrior() {
        this(50, 5);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int hp) {
        this.health = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void attack(Warrior w) {
        w.getDamage(this);
    }

    protected int getDamage(Attackable w) {
        setHealth(getHealth() - w.getAttack());
        return w.getAttack();
    }

    public boolean isAlive() {
        return health > 0;
    }
}

