package weather;

import java.util.Random;

public class WeatherProvider{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN","RAIN","FOG","SNOW"};

    private WeatherProvider(){

    }
    public static WeatherProvider getProvider(){
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates){
        return this.weather[new Random().nextInt(weather.length)];
    }
}
