package za.exabanis.avaj_launcher.weather;

import za.exabanis.avaj_launcher.aircraft.Coordinates;

public class WeatherTower extends Tower {
    /**
     *
     * This creates a WeatherProvider and use it to get the current weather
     * This returns a weather string to the caller
     * @param coordinates
     * @return
     *
     */
    public String getWeather(Coordinates coordinates){
        WeatherProvider weatherProvider = WeatherProvider.getWeatherProvider();
        return weatherProvider.getCurrentWeather(coordinates);
    }

    /**
     *
     * This notifies the WeatherTower that the weather conditions has changed
     *
     */
    void changeWeather(){
        this.conditionsChanged();
    }
}
