package weapon;

public class Shield extends Weapon{

    public static final int HEALTH = 20;
    public static final int ATTACK = -1;
    public static final int DEFENSE = 2;
    public static final int VAMPIRISM = 0;
    public static final int HEALTH_POWER = 0;

    public Shield() {
        super(HEALTH, ATTACK, DEFENSE, VAMPIRISM, HEALTH_POWER);
    }
}
