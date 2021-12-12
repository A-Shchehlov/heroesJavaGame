package weapon;

public class MagicWand extends Weapon{

    public static final int HEALTH = 30;
    public static final int ATTACK = 3;
    public static final int DEFENSE = 0;
    public static final int VAMPIRISM = 0;
    public static final int HEALTH_POWER = 3;

    public MagicWand() {
        super(HEALTH, ATTACK, DEFENSE, VAMPIRISM, HEALTH_POWER);
    }
}
