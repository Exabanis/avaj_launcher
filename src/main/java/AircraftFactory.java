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
        } else {
            try {
                throw new OwnException("Invalid class type");
            } catch (OwnException e) {
                e.printStackTrace();
            }
        }

        return flyable;
    }
}
