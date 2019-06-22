public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        setCoordinates(weather);

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
