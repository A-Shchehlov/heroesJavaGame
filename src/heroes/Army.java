package heroes;

import weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Warrior> units = new ArrayList<>();

    public Army addUnits(Class<? extends Warrior> classWarrior, int count) {
        return addUnits(classWarrior.getSimpleName(), count);
    }

    public Army addUnits(String classWarrior, int count) {
        for (int i = 0; i < count; i++) {
            Warrior warrior = Warrior.of(classWarrior);
            units.add(warrior);
        }
        setBehindUnits();
        return this;
    }

    public void setBehindUnits() {
        for (int i = 1; i < units.size(); i++) {
            units.get(i - 1).setBehind(units.get(i));
        }
    }


    public void setBehindUnitsToNull() {
        for (var unit : units) {
            unit.setBehind(null);
        }
    }

    public boolean isAlive() {
        for (var warrior : units) {
            if (warrior.isAlive()) {
                return true;
            }

        }
        return false;
    }

    public Warrior getFirstAliveUnit() {
        for (var warrior : units) {
            if (warrior.isAlive()) {
                return warrior;
            }
        }
        return null;
    }

    public Warrior getUnit() {
        for (var w : units) {
            if (!w.isWasInFight()) {
                return w;
            }
        }
        return null;
    }

    public void removeDead() {
        for (int i = 0; i < units.size(); i++) {
            units.get(i).setWasInFight(false);
            if (units.get(i).getHealth() < 1) {
                units.remove(units.get(i));
                i--;
            }
        }
    }

    public void equipWeaponByIndex(int index, Weapon w1) {
        try{
            this.units.get(index).equipWeapon(w1);
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
}

