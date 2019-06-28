package za.exabanis.avaj_launcher.weather;

import za.exabanis.avaj_launcher.aircraft.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    /**
     *
     * This adds the supplied flyable to the list of flyables
     * @param flyable
     *
     */
    public void register(Flyable flyable){
        observers.add(flyable);
    }

    /**
     *
     * This removes the supplied flyable to the list of flyables
     * @param flyable
     *
     */
    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    /**
     * This iterate through a list of flyables and calls for update of each
     * flyable's condition
     */
    protected void conditionsChanged(){
        for (int i = 0; i < observers.size(); i++){
            observers.get(i).updateConditions();
        }
    }
}
