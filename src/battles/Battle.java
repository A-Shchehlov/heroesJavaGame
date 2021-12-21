package battles;

import heroes.Army;
import heroes.Warrior;

import java.util.Objects;

public class Battle {

    public static boolean fight(Warrior w1, Warrior w2) {
        while (w1.isAlive() && w2.isAlive()) {
            w1.attack(w2);
            if (w2.isAlive()) {
                w2.attack(w1);
            }
        }
        w1.setWasInFight(true);
        w2.setWasInFight(true);
            return w1.isAlive();
    }

    public static boolean fight(Army attackers, Army defenders) {
        while (attackers.isAlive() && defenders.isAlive()) {
            if(!attackers.isArmyWithoutWarlord()){
                attackers.moveUnits();
            }
            if(!defenders.isArmyWithoutWarlord()){
                defenders.moveUnits();
            }
            fight(attackers.getFirstAliveUnit(), defenders.getFirstAliveUnit());
        }
        return attackers.isAlive();
    }

    public static boolean straightFight(Army attackers, Army defenders){
        attackers.setBehindUnitsToNull();
        defenders.setBehindUnitsToNull();

        while (attackers.isAlive() && defenders.isAlive()) {
            var attacker = attackers.getUnit();
            var defender = defenders.getUnit();
            if(Objects.nonNull(attacker) && Objects.nonNull(defender)){
                fight(attacker, defender);
            }
            else{
                attackers.removeDead();
                defenders.removeDead();
            }
        }
        if(attackers.isAlive()){
            attackers.setBehindUnits();
        }
        else{
            defenders.setBehindUnits();
        }
        return attackers.isAlive();
    }
}
