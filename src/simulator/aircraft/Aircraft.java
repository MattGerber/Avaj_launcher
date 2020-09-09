package simulator.aircraft;

import weather.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        idCounter = nextId();
        this.id = idCounter;
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        idCounter++;
        return (idCounter);
    }
}
