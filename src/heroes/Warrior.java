package heroes;

import java.util.Objects;

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
            case "Healer":
                return new Healer();
            default:
                throw new IllegalArgumentException("Unknown class name : " + clazz);
        }
    }

    private int health;
    protected final int INITIAL_HEALTH;
    private int attack;

    public boolean isWasInFight() {
        return wasInFight;
    }

    public void setWasInFight(boolean wasInFight) {
        this.wasInFight = wasInFight;
    }

    private boolean wasInFight = false;

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
        this.INITIAL_HEALTH = health;
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
        transmitSignal();
    }

    protected int getDamage(Attackable w) {
        setHealth(getHealth() - w.getAttack());
        return w.getAttack();
    }

    public boolean isAlive() {
        return health > 0;
    }
    public void transmitSignal(){
        if(Objects.nonNull(this.getBehind())){
            this.getBehind().handleSignalFrom(this);
        }
    }
    public void handleSignalFrom(Warrior w){
        if(Objects.nonNull(w.getBehind())){
            w.getBehind().transmitSignal();
        }
    }
}

