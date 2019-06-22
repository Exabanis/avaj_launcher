import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private WeatherProvider(){
//        this.weatherProvider = new WeatherProvider();
        this.weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};
    }

    public static WeatherProvider getWeatherProvider(){
        weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random indexer = new Random();
        int index = indexer.nextInt(4);
        return this.weather[index];
    }
}
