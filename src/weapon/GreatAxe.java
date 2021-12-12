package weapon;

public class GreatAxe extends Weapon{

    public static final int HEALTH = -15;
    public static final int ATTACK = 5;
    public static final int DEFENSE = -2;
    public static final int VAMPIRISM = 10;
    public static final int HEALTH_POWER = 0;

    public GreatAxe() {
        super(HEALTH, ATTACK, DEFENSE, VAMPIRISM, HEALTH_POWER);
    }
}
