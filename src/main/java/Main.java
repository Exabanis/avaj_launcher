import java.io.*;

public class Main {
    public static void main(String[] args){
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = new AircraftFactory();

        File file = new File(args[0]);

        try {

            BufferedReader input = new BufferedReader(new FileReader(file));

            int simulations = Integer.parseInt(input.readLine());
            System.out.println(simulations);
            String line;
            String splitLine[];
            Flyable flyable = null;
            while ((line = input.readLine()) != null) {
                splitLine = line.split(" ");
                flyable = aircraftFactory.newAircraft(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]));
                flyable.registerTower(weatherTower);
            }

            for(int i = 0; i < simulations; i++){
                weatherTower.changeWeather();
            }
            throw new OwnException("This is shit");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        } catch (OwnException e) {
            System.out.println(e);
        }
    }
}
