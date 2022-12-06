package Transport;

import java.util.HashSet;
import java.util.Set;

public class MechanicList {
    private Set<Mechanic>mechanics = new HashSet<>();

    public void addMechanic(Mechanic mechanic) {
        this.mechanics.add(mechanic);
    }

    @Override
    public String toString() {
        return "Механики: "+mechanics.toString();
    }
}
