package battles;

import heroes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancerTest {

    @Test
    void Battle1() {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Defender.class, 2);

        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 5);

        var result = Battle.fight(army1, army2);

        assertFalse(result);
    }

    @Test
    void Battle2() {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Lancer.class, 7);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Defender.class, 2);

        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 4);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }

}