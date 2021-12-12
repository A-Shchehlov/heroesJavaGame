package battles;

import heroes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightFightTest {
    @Test
    void straightFight1() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Lancer.class, 5);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Defender.class, 2);

        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 5);

        var result = Battle.straightFight(army1, army2);

        assertFalse(result);
    }

    @Test
    void straightFight2() {
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

        var result = Battle.straightFight(army1, army2);

        assertTrue(result);
    }
    @Test
    void straightFight3() {
        Army army1 = new Army();
        Army army2 = new Army();
        Army army3 = new Army();

        army1.addUnits(Lancer.class, 7);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Defender.class, 2);

        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 4);

        army3.addUnits(Lancer.class, 1);

        Battle.straightFight(army1, army2);
        var result = Battle.fight(army1, army3);


        assertFalse(result);
    }

    @Test
    void straightFight4() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Lancer.class, 7);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Defender.class, 2);

        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Healer.class, 1);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 4);

        var result = Battle.straightFight(army1, army2);

        assertFalse(result);
    }

    @Test
    void straightFight5() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Lancer.class, 4);
        army1.addUnits(Warrior.class, 3);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Knight.class, 2);

        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Healer.class, 1);
        army2.addUnits(Vampire.class, 2);
        army2.addUnits(Lancer.class, 4);

        var result = Battle.straightFight(army1, army2);

        assertTrue(result);
    }
}