package simulator;

import simulator.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;


public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> landed = new ArrayList<Flyable>();


    public void register(Flyable flyable) {
        if (!observers.contains(flyable))
            observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
            landed.add(flyable);
    }

    protected void conditionsChanged(){
        for (Flyable flyable : observers)
            flyable.updateConditions();

        for (Flyable land : landed)
            observers.remove(land);
    }
}
