package Wargames.backend.model;

import java.util.*;
import java.util.stream.Collectors;


/**
 * A class representing an Army of units.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class Army{
    private List<Unit> units;
    // Name of the army
    private final String name;
    // List with Units

    /**
     * Create a new Army.
     *
     * @param name The name of the Army
     */
    public Army(String name) {
        // Name can't be blank. Need to enter a name!
        if(name.isBlank()) {
            throw new IllegalArgumentException("No army!");
        }

        this.name = name;
       this.units = new ArrayList<>();
    }

    /**
     * Creates an instance of the Army.
     *
     * @param name  The name of the Army. The name of the army can't be blank
     * @param units Created new ArrayList
     */
    public Army(String name, ArrayList<Unit> units) {
        // Name can't be blank. Need to enter a name!
        if(name.isBlank()) {
            throw new IllegalArgumentException("No army!");
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
        return this.name;
    }

    /**
     * Adds a unit to the list with units
     *
     * @param unit the Units to add
     */
    public boolean addUnit(Unit unit) {
        if(unit == null){
            throw new IllegalArgumentException("Unit cannot be null");
        }
        return this.units.add(unit);
    }

    /**
     * Adds all units from the input-list "units" to the list
     * with units.
     *
     * @param allUnits Adds all units
     */
    public void addAll(List<Unit> allUnits) {
        if(allUnits == null){
            throw new IllegalArgumentException("allUnits cannot be null");
        }
        this.units.addAll(allUnits);
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
    public List<Unit> getAllUnits(){

       return units;
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
     * Returns a random unit from the list of units. If it's
     * no units it will get thrown an Exception.
     *
     * @return unit Returns a random unit from the list of units
     */
    public Unit getRandomUnit(){
        if(!hasUnits()) {
            throw new NoSuchElementException("Army has no units!");
        } else if(hasUnits())
            return units.get(new Random().nextInt(units.size()));
        return null;
    }

    /**
     * Returns all the values of the given unit, which here is
     * InfantryUnit
     *
     */
    public List<Unit> getInfantryUnit(){
        return getAllUnits().stream()
                .filter(unit -> unit instanceof InfantryUnit)
                .collect(Collectors.toList());
    }

    /**
     * Returns all the values of the given unit, which here is
     * CavalryUnit.
     *
     * @return all the values of the given unit.
     */
    public List<Unit> getCavalryUnit(){
        return getAllUnits().stream()
                .filter(unit -> unit instanceof CavalryUnit)
                .collect(Collectors.toList());
    }

    /**
     * Returns all the values of the given unit, which here is
     * RangedUnit
     *
     * @return all the values of the given unit.
     */
    public List<Unit> getRangedUnit(){
        return getAllUnits().stream()
                .filter(unit -> unit instanceof RangedUnit)
                .collect(Collectors.toList());
    }

    /**
     * Returns all the values of the given unit, which here is
     * CommanderUnit
     *
     * @return all the values of the given unit.
     */
    public List<Unit> getCommanderUnit(){
        return getAllUnits().stream()
                .filter(unit -> unit instanceof CommanderUnit)
                .collect(Collectors.toList());
    }

}
