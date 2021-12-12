package weapon;

public class Sword extends Weapon {

    public static final int HEALTH = 5;
    public static final int ATTACK = 2;
    public static final int DEFENSE = 0;
    public static final int VAMPIRISM = 0;
    public static final int HEALTH_POWER = 0;

    public Sword() {
        super(HEALTH, ATTACK, DEFENSE, VAMPIRISM, HEALTH_POWER);
    }
}
