public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 2, coordinates.getHeight() + 4);
        } else if (weather.equals("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
        } else if (weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
        } else if (weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
        }

        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this);
            loggerFormatter.log(this.getLogMsg("unregister"));
            System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        //log registered message
        loggerFormatter.log(this.getLogMsg("register"));
        System.out.println(this.getClass().getName()+"#"+this.name+"("+this.id+") registered to weather tower.");
    }
}
