import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers;

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for(Flyable flyable : observers){
            flyable.updateConditions();
        }
    }
}
