package battles;

import heroes.Army;
import heroes.Warrior;

public class Battle {

    public static boolean fight(Warrior w1, Warrior w2) {
        while (w1.isAlive() && w2.isAlive()) {
            w1.attack(w2);
            if (w2.isAlive()) {
                w2.attack(w1);
            }
        }
        return w1.isAlive();
    }

    public static boolean fight(Army attackers, Army defenders) {
        while (attackers.isAlive() && defenders.isAlive()) {
            fight(attackers.getUnit(), defenders.getUnit());
        }
        return attackers.isAlive();
    }
}
