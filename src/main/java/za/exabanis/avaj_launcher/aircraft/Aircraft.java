package za.exabanis.avaj_launcher.aircraft;

import za.exabanis.avaj_launcher.utilities.LoggerFormatter;
import za.exabanis.avaj_launcher.utilities.WeatherQuotes;


public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;
    static LoggerFormatter loggerFormatter = new LoggerFormatter();

    /**
     *
     * This constructs an Aircraft with specified name and coordinates
     * This also assigns unique id to the aircraft
     * @param name
     * @param coordinates
     *
     */

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++this.idCounter;
    }

    /**
     *
     * This creates and return a message to be logged simulation.txt using LoggerFormatter.class depending on whether
     * the aircraft need to be registered or unregistered from the tower
     * @param msg
     * @return
     *
     */

    public String getLogMsg(String msg){
        String logMessage = null;
        if (msg.equals("register"))
            logMessage = "Tower says: "+this.getClass().getName().substring(35)+"#"+this.name+"("+this.id+") registered to weather tower.";
        else if (msg.equals("unregister")) {
            logMessage = this.getClass().getName().substring(35) + "#" + this.name + "(" + this.id + ") landing @ " +coordinates.toString()+ ".\n";
            logMessage += "Tower says: " + this.getClass().getName().substring(35) + "#" + this.name + "(" + this.id + ") unregistered from weather tower.";
        }
        return logMessage;
    }

    /**
     *
     * This checks the current weather passed as parameter against the available weather (SUN,RAIN,FOG,SNOW)
     * This log the flyable's comments to the simulation.txt using LoggerFormatter.class
     * This then change coordinates of flyable according to the weather
     * @param weather this is the current weather received from the Tower
     *
     */

    public void setCoordinates(String weather){
        String pref = this.getClass().getName().substring(35) + "#" + this.name + "(" + this.id;
        WeatherQuotes weatherQuotes = new WeatherQuotes();
        if (weather.equals("SUN")){
            loggerFormatter.log(pref + weatherQuotes.getQuote(weather));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
        } else if (weather.equals("RAIN")){
            loggerFormatter.log(pref + weatherQuotes.getQuote(weather));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        } else if (weather.equals("FOG")){
            loggerFormatter.log(pref + weatherQuotes.getQuote(weather));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
        } else if (weather.equals("SNOW")){
            loggerFormatter.log(pref + weatherQuotes.getQuote(weather));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
        }
    }
}
