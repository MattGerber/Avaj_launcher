package simulator.aircraft;

import simulator.Simulator;
import simulator.WeatherTower;
import weather.Coordinates;

/**
 ◦ SUN - Longitude increases with 10, Height increases with 2
 ◦ RAIN - Longitude increases with 5
 ◦ FOG - Longitude increases with 1
 ◦ SNOW - Height decreases with 12
 **/

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather){
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() ,
                        coordinates.getHeight() + 2);
                Simulator.writer.println("Helicopter#" + this.name + "(" + this.id +
                        ") Good thing I bought my shades.");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5 , coordinates.getLatitude(),
                        coordinates.getHeight());
                Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + ") Rain. How cinematic");
                break;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1 , coordinates.getLatitude() ,
                        coordinates.getHeight());
                Simulator.writer.println("Helicopter#" + this.name + "(" + this.id +
                        ") a visible aerosol consisting of tiny water droplets");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude(),
                        coordinates.getHeight() - 12);
                Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + ") AVALANCHE");
                break;
        }
        if (this.coordinates.getHeight() == 0){
            Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + ") Landing");
            Simulator.writer.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") Unregistered from weather tower.");
        }

    }
    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") Registered to weather tower.");
    }
}