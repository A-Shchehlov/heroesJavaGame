package battles;

import heroes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VampireTest {
    @Test
    public void Battle1() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Defender.class, 5);
        army1.addUnits(Vampire.class, 6);
        army1.addUnits(Warrior.class, 7);
        army2.addUnits(Warrior.class, 6);
        army2.addUnits(Defender.class, 6);
        army2.addUnits(Vampire.class, 6);

        var result = Battle.fight(army1, army2);

        assertFalse(result);
    }

    @Test
    public void Battle2() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Defender.class, 2);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 3);

        var result = Battle.fight(army1, army2);

        assertFalse(result);
    }

    @Test
    public void Battle3() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Defender.class, 11);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 13);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }


    @Test
    public void Battle4() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Defender.class, 9);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 8);
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 13);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }
}