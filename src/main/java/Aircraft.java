public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;
    static LoggerFormatter loggerFormatter = new LoggerFormatter();

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++this.idCounter;
    }

    public String getLogMsg(String msg){
        String logMessage = null;
        if (msg.equals("register"))
            logMessage = "Tower says: "+this.getClass().getName()+"#"+this.name+"("+this.id+") registered to weather tower.";
        else if (msg.equals("unregister")) {
            logMessage = this.getClass().getName() + "#" + this.name + "(" + this.id + ") landing @ " +coordinates.toString()+ ".\n";
            logMessage += "Tower says: " + this.getClass().getName() + "#" + this.name + "(" + this.id + ") unregistered from weather tower.";
        }
        return logMessage;
    }

    public void setCoordinates(String weather){
        String pref = this.getClass().getName() + "#" + this.name + "(" + this.id;
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
