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
        else if (msg.equals("unregister"))
            logMessage = "Tower says: "+this.getClass().getName()+"#"+this.name+"("+this.id+") unregistered from weather tower.";
        return logMessage;
    }
}
