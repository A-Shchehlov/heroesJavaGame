package heroes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Army {

    private List<Warrior> units = new ArrayList<>();

    public Army addUnits(Class<? extends Warrior> classWarrior, int count) {
        return addUnits(classWarrior.getSimpleName(), count);
    }

    public Army addUnits(String classWarrior, int count) {
        for (int i = 0; i < count; i++) {
            Warrior warrior = Warrior.of(classWarrior);
            if (warrior instanceof Warlord) {
                if (isArmyWithoutWarlord()) {
                    units.add(warrior);
                }
            }
            else {
                units.add(warrior);
            }
        }
        setBehindUnits();
        return this;
    }

    public void moveUnits() {
        List<Warrior> extraList = new ArrayList<>();
        int[] array = new int[units.size()];
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).isAlive()) {
                array[i] = 3;
            }
            if (units.get(i) instanceof Lancer && units.get(i).isAlive()) {
                array[i] = 1;
            }
            if (units.get(i) instanceof Healer && units.get(i).isAlive()) {
                array[i] = 2;
            }
            if (units.get(i) instanceof Warlord && units.get(i).isAlive()) {
                array[i] = 8;
            }
        }
        //add who can attack besides Warlord
        int index = getFirstWarriorIndex(array);
        if (index != -1) {
            extraList.add(units.get(index));
            array[index] = -1;
        }
        //add Healers
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 2) {
                extraList.add((units.get(i)));
                array[i] = -1;
            }
        }
        //add others besides Warlord
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                extraList.add((units.get(i)));
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 3) {
                extraList.add((units.get(i)));
            }
        }
        //add Warlord
        index = indexOfIntArray(array, 8);
        extraList.add(units.get(index));

        //add units to army
        units.clear();
        for (var unit : extraList) {
            units.add(unit);
        }
        setBehindUnitsToNull();
        setBehindUnits();
    }

    private int getFirstWarriorIndex(int[] a) {
        int index = indexOfIntArray(a, 1);
        if (index < 0) {
            index = indexOfIntArray(a, 3);
        }
        return index;
    }


    private static int indexOfIntArray(int[] array, int key) {
        int returnvalue = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                returnvalue = i;
                break;
            }
        }
        return returnvalue;
    }

    public boolean isArmyWithoutWarlord() {
        for (var unit : units) {
            if (unit instanceof Warlord) {
                return false;
            }
        }
        return true;
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
        this.units.get(index).equipWeapon(w1);
    }
}


