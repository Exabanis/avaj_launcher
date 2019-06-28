package com.simulator;

import com.aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private WeatherProvider(){
        this.weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};
    }

    /**
     *
     * This creates a WeatherProvider instance and return it to the caller
     * @return
     *
     */
    public static WeatherProvider getWeatherProvider(){
        weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    /**
     *
     * This creates a random simulator string
     * Checks if the maximum possible height decrease would be below 0
     * Checks if the maximum possible height increase would be above 100
     * This returns the simulator string
     * @param coordinates
     * @return
     *
     */
    public String getCurrentWeather(Coordinates coordinates){
        Random indexer = new Random();
        int index = indexer.nextInt(4);
        if (coordinates.getHeight() < 15 && index == 3){
            index--;
        } else if (coordinates.getHeight() > 96 && index == 0){
            index++;
        }
        return this.weather[index];
    }
}
