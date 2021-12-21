package heroes;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warrior implements Attackable {

    public static Warrior of(String clazz) {
        return switch (clazz) {
            case "Warrior" -> new Warrior();
            case "Knight" -> new Knight();
            case "Defender" -> new Defender();
            case "Vampire" -> new Vampire();
            case "Lancer" -> new Lancer();
            case "Healer" -> new Healer();
            case "Rookie" -> new Rookie();
            case "Warlord" -> new Warlord();
            default -> throw new IllegalArgumentException("Unknown class name : " + clazz);
        };
    }

    private List<Weapon> weaponList = new ArrayList<>();
    private int health;
    protected final int INITIAL_HEALTH;
    private int attack;
    private Warrior behind;
    private boolean wasInFight = false;

    public Warrior() {
        this(50, 5);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.INITIAL_HEALTH = health;
        this.attack = attack;
    }

    public boolean isWasInFight() {
        return wasInFight;
    }

    public void setWasInFight(boolean wasInFight) {
        this.wasInFight = wasInFight;
    }

    public void setBehind(Warrior behind) {
        this.behind = behind;
    }

    public Warrior getBehind() {
        return behind;
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
        transmitSignal();
    }

    protected int getDamage(Attackable w) {
        setHealth(getHealth() - w.getAttack());
        return w.getAttack();
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void transmitSignal() {
        if (Objects.nonNull(this.getBehind())) {
            this.getBehind().handleSignalFrom(this);
        }
    }

    public void handleSignalFrom(Warrior w) {
        if (Objects.nonNull(w.getBehind())) {
            w.getBehind().transmitSignal();
        }
    }

    private void setAttack(int attack) {
        this.attack = attack;
    }

    public void equipWeapon(Weapon weapon) {
        weaponList.add(weapon);
        this.setHealth(Math.max(this.getHealth() + weapon.getHealth(), 0));
        this.setAttack(Math.max(this.getAttack() + weapon.getAttack(), 0));
    }
}

