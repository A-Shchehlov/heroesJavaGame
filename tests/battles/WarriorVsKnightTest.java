package battles;

import heroes.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WarriorVsKnightTest {

    @ParameterizedTest(name = "{index} {0} vs {1}, expected result = {2}")
    @CsvSource({"Warrior,Warrior,true", "Warrior,Knight,false"})
    void fight(String firstWarrior, String secondWarrior, boolean expected) {
        Warrior w1 = Warrior.of(firstWarrior);
        Warrior w2 = Warrior.of(secondWarrior);

        var result1 = Battle.fight(w1, w2);

        assertEquals(expected, result1);
    }

    @Test
    void fightChuckIsAlive() {
        Warrior chuck = new Warrior();
        Warrior bruce = new Warrior();

        var result1 = Battle.fight(chuck, bruce);

        assertTrue(chuck.isAlive());
    }

    @Test
    void fightBruceIsDead() {
        Warrior chuck = new Warrior();
        Warrior bruce = new Warrior();

        var result1 = Battle.fight(chuck, bruce);

        assertFalse(bruce.isAlive());
    }

    @Test
    void fightCarlIsAlive() {
        Warrior carl = new Knight();
        Warrior dave = new Warrior();

        var result2 = Battle.fight(dave, carl);

        assertTrue(carl.isAlive());
    }

    @Test
    void fightDaveIsDead() {
        Warrior carl = new Knight();
        Warrior dave = new Warrior();

        var result2 = Battle.fight(dave, carl);

        assertFalse(dave.isAlive());
    }
}