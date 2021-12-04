package battles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import heroes.*;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {

    @ParameterizedTest(name = "{index} {0} vs {1}, expected result = {2}")
    @CsvSource({"Warrior,Knight,false", "Knight,Warrior,true"})
    void fight(String firstWarrior, String secondWarrior, boolean expected) {
        Warrior w1 = Warrior.of(firstWarrior);
        Warrior w2 = Warrior.of(secondWarrior);

        var result1 = Battle.fight(w1, w2);

        assertEquals(expected, result1);
    }

    @ParameterizedTest(name = "{index} {0} vs {1}, expected result = {2}")
    @CsvSource({"Warrior,Warrior,true", "Knight,Warrior,true",})
    void firstIsAlive(String firstWarrior, String secondWarrior, boolean expected) {
        Warrior w1 = Warrior.of(firstWarrior);
        Warrior w2 = Warrior.of(secondWarrior);

        Battle.fight(w1, w2);

        assertEquals(expected, w1.isAlive());
    }
    @ParameterizedTest(name = "{index} {0} vs {1}, expected result = {2}")
    @CsvSource({"Warrior,Warrior,false", "Warrior,Knight,true",})
    void secondIsAlive(String firstWarrior, String secondWarrior, boolean expected) {
        Warrior w1 = Warrior.of(firstWarrior);
        Warrior w2 = Warrior.of(secondWarrior);

        Battle.fight(w1, w2);

        assertEquals(expected, w2.isAlive());
    }

    @Test
    void fightWarriorVsKnightVsWarrior(){
        Warrior w1 = new Warrior();
        Warrior w2 = new Knight();
        Warrior w3 = new Warrior();

        Battle.fight(w1, w2);
        boolean result =  Battle.fight(w2, w3);
        assertFalse(result);
    }

    class Rookie extends Warrior{
        public Rookie(){
            super(50,1);
        }
    }

    @Test
    void fightDefenderVsRookie(){
        Warrior w1 = new Defender();
        Warrior w2 = new Rookie();

        Battle.fight(w1, w2);
        int result = w1.getHealth();
        assertEquals(60, result);
    }

    @Test
    void fightDefenderVsRookieVsWarrior(){
        Warrior w1 = new Defender();
        Warrior w2 = new Rookie();
        Warrior w3 = new Warrior();

        Battle.fight(w1, w2);
        boolean result =  Battle.fight(w1, w3);
        assertTrue(result);
    }

    @ParameterizedTest(name = "#{index} {1} {0}s vs {3} {2}s, expected result = {4}")
    @CsvSource({"Warrior,1,Warrior,2,false", "Warrior,2,Warrior,3,false",
            "Warrior,5,Warrior,7,false","Warrior,20,Warrior,21,true",
            "Warrior,10,Warrior,11,true","Warrior,11,Warrior,7,true"})
    void armyBattle(String classW1, int count1, String classW2, int count2, boolean expected ) {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(classW1, count1);
        army2.addUnits(classW2, count2);

        var result = Battle.fight(army1, army2);

        assertEquals(expected, result);
    }

    @Test
    void warriorsAndDefendersVsWarriorsBattle(){
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior.class,5);
        army1.addUnits(Defender.class,4);
        army1.addUnits(Defender.class,5);
        army2.addUnits(Warrior.class,4);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    void defendersAndWarriorsAndDefendersVsWarriorsBattle(){
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Defender.class,5);
        army1.addUnits(Warrior.class,20);
        army2.addUnits(Warrior.class,21);
        army1.addUnits(Defender.class,4);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    void warriorsAndDefendersAndDefendersVsWarriorsBattle(){
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior.class,10);
        army1.addUnits(Defender.class,5);
        army2.addUnits(Warrior.class,5);
        army1.addUnits(Defender.class,10);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    void DefendersAndWarriorAndDefenderVsWarriorsBattle(){
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Defender.class,2);
        army1.addUnits(Warrior.class,1);
        army1.addUnits(Defender.class,1);
        army2.addUnits(Warrior.class,5);

        var result = Battle.fight(army1, army2);

        assertFalse(result);
    }
}