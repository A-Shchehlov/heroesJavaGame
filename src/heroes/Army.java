package heroes;
import java.util.ArrayList;
import java.util.Collection;

public class Army {

    private Collection<Warrior> units = new ArrayList<>();

    public Army addUnits(Class<? extends  Warrior> classWarrior, int count){
        return addUnits(classWarrior.getSimpleName(),count);
    }

    public Army addUnits(String classWarrior, int count) {
        for (int i = 0; i < count; i++) {
            units.add(Warrior.of(classWarrior));
        }
        return this;
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

