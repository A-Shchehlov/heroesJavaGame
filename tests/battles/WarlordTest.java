package battles;

import heroes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarlordTest {

    @Test
    void Battle1() {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warlord.class, 1);
        army1.addUnits(Warrior.class, 2);
        army1.addUnits(Lancer.class, 2);
        army1.addUnits(Healer.class, 2);

        army2.addUnits(Warlord.class, 1);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Healer.class, 2);
        army2.addUnits(Knight.class, 2);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    void Battle2() {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior.class, 2);
        army1.addUnits(Lancer.class, 2);
        army1.addUnits(Defender.class, 1);
        army1.addUnits(Warlord.class, 3);

        army2.addUnits(Warlord.class, 2);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Healer.class, 5);
        army2.addUnits(Knight.class, 2);

        var result = Battle.fight(army1, army2);

        assertFalse(result);
    }

    @Test
    void Battle3() {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior.class, 2);
        army1.addUnits(Lancer.class, 3);
        army1.addUnits(Defender.class, 1);
        army1.addUnits(Warlord.class, 4);

        army2.addUnits(Warlord.class, 1);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Rookie.class, 1);
        army2.addUnits(Knight.class, 1);

        army1.equipWeaponByIndex(0, Weapon.PredefinedWeapon.SWORD);
        army2.equipWeaponByIndex(0, Weapon.PredefinedWeapon.SHIELD);

        var result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    void Battle4() {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior.class, 2);
        army1.addUnits(Lancer.class, 3);
        army1.addUnits(Defender.class, 1);
        army1.addUnits(Warlord.class, 1);

        army2.addUnits(Warlord.class, 5);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Rookie.class, 1);
        army2.addUnits(Knight.class, 1);

        army1.equipWeaponByIndex(0, Weapon.PredefinedWeapon.SWORD);
        army2.equipWeaponByIndex(0, Weapon.PredefinedWeapon.SHIELD);

        army1.moveUnits();
        army2.moveUnits();

        var result = Battle.straightFight(army1, army2);

        assertFalse(result);
    }
}