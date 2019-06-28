package za.exabanis.avaj_launcher.weather;

import za.exabanis.avaj_launcher.aircraft.AircraftFactory;
import za.exabanis.avaj_launcher.aircraft.Flyable;
import za.exabanis.avaj_launcher.utilities.OwnException;

import java.io.*;

public class Simulator {
    public static void main(String[] args){
        WeatherTower weatherTower = new WeatherTower();
     //   AircraftFactory aircraftFactory = new AircraftFactory();


        try {
            File file = new File(args[0]);

            BufferedReader input = new BufferedReader(new FileReader(file));

            int simulations = getNumber(input.readLine(), "simulations");

            String line;
            String splitLine[];
            Flyable flyable;
            while ((line = input.readLine()) != null) {
                splitLine = line.split(" ");
                flyable = AircraftFactory.newAircraft(splitLine[0], splitLine[1], getNumber(splitLine[2], "longitude"), getNumber(splitLine[3], "latitude"), getNumber(splitLine[4], "height"));
                flyable.registerTower(weatherTower);
            }

            for(int i = 0; i <= simulations; i++){
                weatherTower.changeWeather();
            }

            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        } catch (OwnException e){
            e.printStackTrace();
        }
    }

    private static int getNumber(String line, String name) throws OwnException {
        int i;
        try{
            i = Integer.parseInt(line);
            if (i < 0){
                throw new OwnException("Invalid number provided: " + name + " should be a positive number");
            }
        } catch (NumberFormatException e){
            throw new OwnException("Invalid number provided: " + name + " should be a number");
        }
        return i;
    }
}
