public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {
        String pref = this.getClass().getName() + "#" + this.name + "(" + this.id;
        String weather = weatherTower.getWeather(this.coordinates);
        if (weather.equals("SUN")){
            loggerFormatter.log(pref + ") : This is hot.");
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
        } else if (weather.equals("RAIN")){
            loggerFormatter.log(pref + ") : Damn you rain! You messed up my trip.");
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        } else if (weather.equals("FOG")){
            loggerFormatter.log(pref + ") : Let's enjoy the good weather and take some pics.");
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
        } else if (weather.equals("SNOW")){
            loggerFormatter.log(pref + ") :  My rotor is going to freeze!");
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
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
