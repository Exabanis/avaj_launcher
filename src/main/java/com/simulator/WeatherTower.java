package com.simulator;

import com.aircraft.Coordinates;

public class WeatherTower extends Tower {
    /**
     *
     * This creates a WeatherProvider and use it to get the current simulator
     * This returns a simulator string to the caller
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
     * This notifies the WeatherTower that the simulator conditions has changed
     *
     */
    void changeWeather(){
        this.conditionsChanged();
    }
}
