public class Baloon extends Aircraft implements Flyable {
   Baloon(String name, Coordinates coordinates){
       super(name, coordinates);
   }

    public void updateConditions(){

    }
    public void registerTower(WeatherTower weatherTower){
        weatherTower.register(this);
        //log registered message
    }
}
