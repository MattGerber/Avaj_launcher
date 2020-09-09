package simulator.aircraft;

import simulator.Simulator;
import simulator.WeatherTower;
import weather.Coordinates;

/**
 * ◦ SUN - Latitude increases with 10, Height increases with 2
 * ◦ RAIN - Latitude increases with 5
 * ◦ FOG - Latitude increases with 1
 * ◦ SNOW - Height decreases with 7
 **/

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather){
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10,
                        coordinates.getHeight() + 2);
                Simulator.writer.println("JetPlane#" + this.name + "(" + this.id + ") Praise the Sun.");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude() + 5,
                        coordinates.getHeight());
                Simulator.writer.println("JetPlane#" + this.name + "(" + this.id + ") I'm going to get my Hair wet!");
                break;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude() + 1,
                        coordinates.getHeight());
                Simulator.writer.println("JetPlane#" + this.name + "(" + this.id + ") I can barely see!");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude(),
                        coordinates.getHeight() - 7);
                Simulator.writer.println("JetPlane#" + this.name + "(" + this.id + ") Baby it's cold outside..");
                break;
        }
        if (this.coordinates.getHeight() == 0){
            Simulator.writer.println("JetPlane#" + this.name + "(" + this.id + ") Landing");
            Simulator.writer.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") Unregistered from weather tower.");
        }

    }
    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") Registered to weather tower.");
    }
}
