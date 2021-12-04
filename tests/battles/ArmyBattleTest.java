package battles;

import heroes.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArmyBattleTest {


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
    void armyBattle7() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 20)
                .addUnits(Knight.class, 5);

        Army army2 = new Army();
        army2.addUnits(Warrior.class, 30);

        var result = Battle.fight(army1, army2);

        assertFalse(result);
    }

    @Test
    void armyBattle8() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 20)
                .addUnits(Knight.class, 5);

        Army army2 = new Army();
        army2.addUnits(Warrior.class, 25);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }

}