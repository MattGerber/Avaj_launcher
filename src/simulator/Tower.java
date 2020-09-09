package simulator;

import simulator.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();


    public void register(Flyable flyable) {
        if (!observers.contains(flyable))
            observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        if (observers.contains(flyable))
            observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (Flyable flyable : observers)
            flyable.updateConditions();
    }
}
