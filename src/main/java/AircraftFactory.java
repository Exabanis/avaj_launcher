public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Flyable flyable = null;

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equals("Helicopter")){
            flyable = new Helicopter(name, coordinates);
        } else if (type.equals("JetPlane")){
            flyable = new JetPlane(name, coordinates);
        } else if (type.equals("Baloon")){
            flyable = new Baloon(name, coordinates);
        }

        return flyable;
    }
}
