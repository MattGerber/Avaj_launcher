package simulator.aircraft;

import weather.Coordinates;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude,latitude,height);
        switch (type) {
            case "JetPlane":
                return (new JetPlane(name, coordinates));
            case "Helicopter":
                return (new Helicopter(name, coordinates));
            case "Baloon":
                return (new Baloon(name, coordinates));
        }
        return null;
    }
}
