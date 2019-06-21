public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates){
        WeatherProvider weatherProvider = WeatherProvider.getWeatherProvider();
        return weatherProvider.getCurrentWeather(coordinates);
    }

    void changeWeather(){
        this.conditionsChanged();
    }
}
