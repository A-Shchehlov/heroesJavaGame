package battles;

import heroes.Warrior;

public class Battle {
    public static boolean fight(Warrior w1, Warrior w2) {
        while (w1.isAlive() && w2.isAlive()) {
            w1.attack(w2);
            if (w2.isAlive())
                w2.attack(w1);
        }
        return w1.isAlive();
    }
}
