package simulator;

import simulator.aircraft.AircraftFactory;
import simulator.aircraft.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();
    public static PrintWriter writer = null;


    public static void main(String[] arg) throws InterruptedException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            String line = reader.readLine();
            writer = new PrintWriter(new File("./simulation.txt"));

            if (line != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ") [0]);
                if (simulations < 0) {
                    System.out.println("Invalid simulations count" + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    if (flyable != null) {
                        flyables.add(flyable);
                    }
                }

                for (Flyable flyable: flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++){
                    weatherTower.changeWeather();
                }

            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't get file-->" + arg[0]);
        } catch (IOException e) {
            System.out.println("There was an error reading file-->" + arg[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide Simulation file");
        }
    }
}
