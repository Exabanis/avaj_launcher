public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
        this.weatherTower = new WeatherTower();
        registerTower(weatherTower);
    }

    public void updateConditions(){
        weatherTower.unregister(this);
    }

    public void registerTower(WeatherTower weatherTower){
        weatherTower.register(this);
        //log registered message
        System.out.println(this.getClass().getName()+"#("+this.name+")registered to weather tower.");
    }
}
