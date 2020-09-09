package simulator;

import simulator.aircraft.Flyable;
import weather.Coordinates;
import weather.WeatherProvider;

import java.util.*;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates) {
        String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
        return weather;
    }

    public void changeWeather() {
        this.conditionsChanged();
    }

}
