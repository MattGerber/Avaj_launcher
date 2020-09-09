package simulator.aircraft;

import simulator.Simulator;
import simulator.WeatherTower;
import weather.Coordinates;

/**
 ◦ SUN - Longitude increases with 2, Height increases with 4
 ◦ RAIN - Height decreases with 5
 ◦ FOG - Height decreases with 3
 ◦ SNOW - Height decreases with 15
 **/

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather){
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() ,
                        coordinates.getHeight() + 4);
                Simulator.writer.println("Baloon#" + this.name + "(" + this.id + ") Not a cloud in sight.");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 5);
                Simulator.writer.println("Baloon#" + this.name + "(" + this.id + ") Bloody rain");
                break;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() ,
                        coordinates.getHeight() - 3);
                Simulator.writer.println("Baloon#" + this.name + "(" + this.id + ") No visibility, No flysies");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude(),
                        coordinates.getHeight() - 15);
                Simulator.writer.println("Baloon#" + this.name + "(" + this.id + ") Snow piling on Baloon");
                break;
        }
        if (this.coordinates.getHeight() == 0){
            Simulator.writer.println("Baloon#" + this.name + "(" + this.id + ") Landing");
            Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ") Unregistered from weather tower.");
        }

    }
    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ") Registered to weather tower.");
    }
}