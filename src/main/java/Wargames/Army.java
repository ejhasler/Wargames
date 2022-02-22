package Wargames;

import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;


/**
 * A class representing an Army.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class Army {
    // Name of the army
    private final String name;
    // List with Units
    private ArrayList<Unit> units;

    /**
     * Create a new Army.
     *
     * @param name The name of the Army
     */
    public Army(String name) {
        // Name can't be blank. Need to enter a name!
        if(name.isBlank()) {
            System.out.println("You need to give the Army a name!");
        }

        this.name = name;
    }

    /**
     * Create a new Army with list.
     *
     * @param name  The name of the Army. The name of the army can't be blank
     * @param units Created new ArrayList
     */
    public Army(String name, ArrayList<Unit> units) {
        // Name can't be blank. Need to enter a name!
        if(name.isBlank()) {
            System.out.println("You need to give the Unit a name!");
        }

        this.name = name;
        this.units = new ArrayList<>();
    }

    /**
     * Returns the name of Army
     *
     * @return name The name of the Army
     */
    protected String getName() {
        return name;
    }

    /**
     * Adds a unit to the list with units
     *
     * @param unit the Units to add
     */
    public void addUnit(Unit unit) {
        units.add(unit);
    }

    /**
     * Adds all units from the input-list "units" to the list
     * with units.
     *
     * @param units Adds all units
     */
    public void addAll(ArrayList<Unit> units) {
        for(Unit unit : units) {
            this.units.addAll(units);
        }
    }

    /**
     * Removes a unit from the list with units
     *
     * @param unit Removes a unit from the list
     */
    public void removeUnit(Unit unit){
        units.remove(unit);
    }

    /**
     * Returns true if the list with units has
     * elements, and false if it's empty.
     *
     * @return units Returns true if it contains any units
     */
    public boolean hasUnits() {
        return !units.isEmpty();
    }

    /**
     * Returns a list of all the units.
     *
     * @return units Returns a list of all the units
     */
    public ArrayList<Unit> getAllUnits(){
        if(units.isEmpty()){
            System.out.println("There is no units in the list.");
        }
       return this.units;
    }

    /**
     * Returns a String with Army, name and units.
     *
     * @return Army, name and units
     */
    @Override
    public String toString() {
        return "Army{" +
                "name='" + name + '\'' +
                ", units=" + units +
                '}';
    }

    /**
     * Returns army name and army units.
     *
     * @param o equals a object
     * @return name and army units
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return name.equals(army.name) && units.equals(army.units);
    }

    /**
     * Returns name and units.
     *
     * @return name The name of the army
     */
    @Override
    public int hashCode() {

        return Objects.hash(name, units);
    }

    /**
     * Returns a random unit from the list of units.
     *
     * @return unit Returns a random unit from the list of units
     */
    public Unit getRandomUnit(){
        Random random = new Random();
        return this.units.get(random.nextInt(this.units.size()));
    }
}
