package weapon;

public class Katana extends Weapon{

    public static final int HEALTH = -20;
    public static final int ATTACK = 6;
    public static final int DEFENSE = -5;
    public static final int VAMPIRISM = 50;
    public static final int HEALTH_POWER = 0;

    public Katana() {
        super(HEALTH, ATTACK, DEFENSE, VAMPIRISM, HEALTH_POWER);
    }
}
