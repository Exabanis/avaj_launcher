public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private WeatherProvider(){
        this.weatherProvider = new WeatherProvider();
        this.weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};
    }

    public static WeatherProvider getWeatherProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return this.weather[0];
    }
}
