package za.exabanis.avaj_launcher.aircraft;

import za.exabanis.avaj_launcher.weather.WeatherTower;

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
     * This request the weather from the weatherTower and modify the coordinates
     * according to the weather condition
     * If the height is 0 meaning the flyable has landed, it request the weatherTower
     * to unregister it and logs the de-registration to the simulation log
     *
     */
    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        setCoordinates(weather);

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
