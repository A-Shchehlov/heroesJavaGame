package battles;

import heroes.*;
import org.junit.jupiter.api.Test;
import weapon.Sword;
import weapon.*;

import static org.junit.jupiter.api.Assertions.*;

class BattleWithWeaponTest {

    @Test
    void fightWithWeaponTest1() {
        Warrior attacker = new Warrior();
        Warrior defender = new Vampire();

        Weapon w1 = Weapon.builder()
                .withHealth(-10)
                .withAttack(5)
                .withDefense(0)
                .withVampirism(40)
                .withHealthPower(0)
                .build();
        Weapon w2 = new Sword();

        attacker.equipWeapon(w1);
        defender.equipWeapon(w2);

        var result = Battle.fight(attacker, defender);
        assertTrue(result);
    }

    @Test
    void fightWithWeaponTest2() {
        Warrior attacker = new Defender();
        Warrior defender = new Lancer();

        Weapon w1 = new Shield();
        Weapon w2 = new Sword();

        attacker.equipWeapon(w1);
        defender.equipWeapon(w2);

        var result = Battle.fight(attacker, defender);
        assertFalse(result);
    }

    @Test
    void fightWithWeaponTest3() {
        Warrior attacker = new Healer();
        Warrior defender = new Knight();

        Weapon w1 = new MagicWand();
        Weapon w2 = new Katana();

        attacker.equipWeapon(w1);
        defender.equipWeapon(w2);

        var result = Battle.fight(attacker, defender);
        assertFalse(result);
    }

    @Test
    void fightWithWeaponTest4() {
        Warrior attacker = new Defender();
        Warrior defender = new Vampire();

        Weapon w1 = new Shield();
        Weapon w2 = new MagicWand();
        Weapon w3 = new Shield();
        Weapon w4 = new Katana();

        attacker.equipWeapon(w1);
        attacker.equipWeapon(w2);
        defender.equipWeapon(w3);
        defender.equipWeapon(w4);

        var result = Battle.fight(attacker, defender);
        assertFalse(result);
    }

    @Test
    void armyFightWithWeapon1() {
        Weapon w1 = new MagicWand();
        Weapon w2 = new GreatAxe();

        Army attackers = new Army();
        attackers.addUnits(Knight.class, 1);
        attackers.addUnits(Lancer.class, 1);
        Army defenders = new Army();
        defenders.addUnits(Vampire.class, 1);
        defenders.addUnits(Healer.class, 1);

        attackers.equipWeaponByIndex(0, w1);
        attackers.equipWeaponByIndex(1, w2);
        defenders.equipWeaponByIndex(0, w1);
        defenders.equipWeaponByIndex(1, w2);

        var result = Battle.fight(attackers, defenders);
        assertTrue(result);
    }

    @Test
    void armyFightWithWeapon2() {
        Weapon w1 = new Sword();
        Weapon w2 = new GreatAxe();

        Army attackers = new Army();
        attackers.addUnits(Defender.class, 1);
        attackers.addUnits(Warrior.class, 1);
        Army defenders = new Army();
        defenders.addUnits(Knight.class, 1);
        defenders.addUnits(Healer.class, 1);

        attackers.equipWeaponByIndex(0, w2);
        attackers.equipWeaponByIndex(1, w2);
        defenders.equipWeaponByIndex(0, w1);
        defenders.equipWeaponByIndex(1, w1);

        var result = Battle.fight(attackers, defenders);
        assertTrue(result);
    }

    @Test
    void armyFightWithWeapon3() {
        Weapon w1 = new Katana();
        Weapon w2 = new Shield();

        Army attackers = new Army();
        attackers.addUnits(Defender.class, 2);
        Army defenders = new Army();
        defenders.addUnits(Knight.class, 1);
        defenders.addUnits(Vampire.class, 1);

        attackers.equipWeaponByIndex(0, w1);
        attackers.equipWeaponByIndex(1, w1);
        defenders.equipWeaponByIndex(0, w1);
        defenders.equipWeaponByIndex(1, w1);

        var result = Battle.fight(attackers, defenders);
        assertFalse(result);
    }

    @Test
    void armyFightWithWeapon4() {
        Weapon w1 = Weapon.builder()
                .withHealth(-20)
                .withAttack(6)
                .withDefense(1)
                .withVampirism(40)
                .withHealthPower(-2)
                .build();
        Weapon w2 = Weapon.builder()
                .withHealth(20)
                .withAttack(-2)
                .withDefense(2)
                .withVampirism(-55)
                .withHealthPower(3)
                .build();

        Army attackers = new Army();
        attackers.addUnits(Knight.class, 3);
        Army defenders = new Army();
        defenders.addUnits(Warrior.class, 1);
        defenders.addUnits(Defender.class, 2);

        attackers.equipWeaponByIndex(0, w1);
        attackers.equipWeaponByIndex(1, w1);
        attackers.equipWeaponByIndex(2, w2);
        defenders.equipWeaponByIndex(0, w1);
        defenders.equipWeaponByIndex(1, w2);
        defenders.equipWeaponByIndex(2, w2);

        var result = Battle.fight(attackers, defenders);
        assertTrue(result);
    }

    @Test
    void armyFightWithWeapon5() {
        Weapon w1 = Weapon.builder()
                .withHealth(-20)
                .withAttack(1)
                .withDefense(1)
                .withVampirism(40)
                .withHealthPower(-2)
                .build();
        Weapon w2 = Weapon.builder()
                .withHealth(20)
                .withAttack(2)
                .withDefense(2)
                .withVampirism(-55)
                .withHealthPower(3)
                .build();

        Army attackers = new Army();
        attackers.addUnits(Vampire.class, 3);
        Army defenders = new Army();
        defenders.addUnits(Warrior.class, 1);
        defenders.addUnits(Defender.class, 2);

        attackers.equipWeaponByIndex(0, w1);
        attackers.equipWeaponByIndex(1, w1);
        attackers.equipWeaponByIndex(2, w2);
        defenders.equipWeaponByIndex(0, w1);
        defenders.equipWeaponByIndex(1, w2);
        defenders.equipWeaponByIndex(2, w2);

        var result = Battle.straightFight(attackers, defenders);
        assertFalse(result);
    }

    @Test
    void armyFightWithWeapon6() {
        Weapon w1 = new Katana();
        Weapon w2 = new Shield();

        Army attackers = new Army();
        attackers.addUnits(Vampire.class, 2);
        attackers.addUnits(Rookie.class, 2);
        Army defenders = new Army();
        defenders.addUnits(Warrior.class, 1);
        defenders.addUnits(Defender.class, 2);

        attackers.equipWeaponByIndex(0, w1);
        attackers.equipWeaponByIndex(1, w1);
        attackers.equipWeaponByIndex(2, w2);
        defenders.equipWeaponByIndex(0, w1);
        defenders.equipWeaponByIndex(1, w2);
        defenders.equipWeaponByIndex(2, w2);

        var result = Battle.straightFight(attackers, defenders);
        assertTrue(result);
    }

    @Test
    void armyFightWithWeapon7() {
        Weapon w1 = new Sword();
        Weapon w2 = new GreatAxe();

        Army attackers = new Army();
        attackers.addUnits(Vampire.class, 3);
        Army defenders = new Army();
        defenders.addUnits(Warrior.class, 1);
        defenders.addUnits(Defender.class, 1);

        attackers.equipWeaponByIndex(0, w2);
        attackers.equipWeaponByIndex(1, w2);
        attackers.equipWeaponByIndex(2, w2);
        defenders.equipWeaponByIndex(0, w1);
        defenders.equipWeaponByIndex(1, w2);

        var result = Battle.straightFight(attackers, defenders);
        assertTrue(result);
    }

    @Test
    void armyFightWithWeapon8() {
        Weapon w1 = new Katana();
        Weapon w2 = new MagicWand();

        Army attackers = new Army();
        attackers.addUnits(Rookie.class, 3);
        Army defenders = new Army();
        defenders.addUnits(Defender.class, 1);
        defenders.addUnits(Healer.class, 1);

        attackers.equipWeaponByIndex(0, w1);
        attackers.equipWeaponByIndex(1, w1);
        attackers.equipWeaponByIndex(2, w1);
        defenders.equipWeaponByIndex(0, w2);
        defenders.equipWeaponByIndex(1, w2);

        var result = Battle.straightFight(attackers, defenders);
        assertFalse(result);
    }

}
