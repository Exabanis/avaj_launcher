package com.aircraft;

import com.utilities.LoggerFormatter;


public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;
    static LoggerFormatter loggerFormatter = new LoggerFormatter();
    String pref;

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
        this.pref = String.format("%s#%s(%s)", this.getClass().getName().substring(13), this.name, this.id);
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
            logMessage = String.format("Tower says: %s registered to simulator tower.", this.pref);
        else if (msg.equals("unregister")) {
            logMessage = String.format("%s landing @ %s.\n", this.pref, coordinates.toString());
            logMessage += String.format("Tower says: %s unregistered from simulator tower.", this.pref);
        }
        return logMessage;
    }
}
