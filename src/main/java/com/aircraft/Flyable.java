package com.aircraft;

import com.simulator.WeatherTower;

/**
 *
 * classes implementing this interface needs to implements the 2 methods
 * void updateConditions()
 * void registerTower(WeatherTower weatherTower)
 *
 */
public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
