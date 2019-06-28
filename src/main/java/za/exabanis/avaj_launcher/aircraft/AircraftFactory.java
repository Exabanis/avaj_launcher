package za.exabanis.avaj_launcher.aircraft;

import za.exabanis.avaj_launcher.utilities.OwnException;

public abstract class AircraftFactory {

    /**
     *
     * This creates an object of coordinates to be used in creating a new flyable
     * This creates a new flyable based on the type passed on the parameter
     * This returns an object of a flyable
     * If a wrong type is passed the method throws and exception and return null
     * @param type
     * @param name
     * @param longitude
     * @param latitude
     * @param height
     * @return
     *
     */
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
