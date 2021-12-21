package battles;

import heroes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuccubusTest {

    @Test
    void Battle1() {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Succubus.class, 2);

        army2.addUnits(Rookie.class, 6);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    void Battle2() {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Succubus.class, 1);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Warrior.class, 3);


        army2.addUnits(Defender.class, 2);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Knight.class, 1);


        var result = Battle.fight(army1, army2);

        assertFalse(result);
    }

}