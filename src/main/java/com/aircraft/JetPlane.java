package com.aircraft;

import com.utilities.WeatherQuotes;
import com.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    /**
     *
     * This constructs an JetPlane with specified name and coordinates
     * @param name
     * @param coordinates
     *
     */
    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    /**
     *
     * This request the simulator from the weatherTower and modify the coordinates
     * according to the simulator condition(SUN,RAIN,FOG,SNOW)
     * Then log the flyable's comments to the simulation.txt using LoggerFormatter.class
     * If the height is 0 meaning the flyable has landed, it request the weatherTower
     * to unregister it and logs the de-registration to the simulation log
     *
     */

    public void updateConditions(){
        WeatherQuotes weatherQuotes = new WeatherQuotes();
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")){
            loggerFormatter.log(pref + weatherQuotes.getQuote(weather));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
        } else if (weather.equals("RAIN")){
            loggerFormatter.log(pref + weatherQuotes.getQuote(weather));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
        } else if (weather.equals("FOG")){
            loggerFormatter.log(pref + weatherQuotes.getQuote(weather));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
        } else if (weather.equals("SNOW")){
            loggerFormatter.log(pref + weatherQuotes.getQuote(weather));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
        }

        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this);
            loggerFormatter.log(this.getLogMsg("unregister"));
        }
    }

    /**
     *
     * This accept and assign a weatherTower passed as a parameter to its weatherTower
     * This weatherTower to register itself to the WeatherTower and log its registration
     * to the simulation log file
     * @param weatherTower
     *
     */
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        loggerFormatter.log(this.getLogMsg("register"));
    }
}
