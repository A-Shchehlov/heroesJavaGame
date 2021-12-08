package heroes;

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
            if (units.size() > 1)
                setBehindUnit(units.indexOf(warrior));
        }
        return this;
    }

    private void setBehindUnit(int index) {
        units.get(index - 1).setBehind(units.get(index));
    }

    public boolean isAlive() {
        for (var warrior : units) {
            if (warrior.isAlive())
                return true;

        }
        return false;
    }

    public Warrior getUnit() {
        for (var warrior : units) {
            if (warrior.isAlive())
                return warrior;
        }
        return null;
    }
}

