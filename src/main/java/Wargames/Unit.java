package Wargames;
import java.util.List;

/**
 * A class representing different types of units and
 * varying defending and attacking abilities.
 *
 * @author Even Johan Pereira Haslerud
 * @version 20.02.20022
 */
public abstract class Unit {
    // Name of the character
    private String name;
    // Health of the character
    private int health;
    // Attacking of the character
    private int attacking;
    // The armor of the character
    private int armor;
    //Whether the animal is alive or not.
    private boolean alive;
    // The character's position in the field.
    private Field field;
    // The character's position in the field.
    private Location location;

    /**
     * Create a new Unit.
     *
     * @param name The name of the character.
     * @param health The health status of the character.
     * @param attacking The attacking of the character.
     * @param armor The armor of the character.
     */
    public Unit(String name, int health, int attacking, int armor, Field field, Location location) {
        alive = true;
        this.name = name;
        this.health = health;
        this.attacking = attacking;
        this.armor = armor;
        setLocation(location);
    }

    /**
     * Check whether the character is alive or not.
     * @return true if the character is still alive.
     */
    protected boolean isAlive() {
        return alive;
    }

    /**
     * Return the name of the character.
     * @return The name of the character.
     */
    protected String getName() {
        return name;
    }

    /**
     * Return health of the character.
     * @return The health of the character.
     */
    protected int getHealth() {
        return health;
    }

    /**
     * Return attacking of the character.
     * @return The attacking of the character.
     */
    protected int getAttacking() {
        return attacking;
    }

    /**
     * Return the armor of the character.
     * @return The armor of the character.
     */
    protected int getArmor () {
        return armor;
    }

    /**
     * Return the character's location.
     * @return The character's location.
     */
    protected Location location() {
        return location;
    }

    /**
     * Indicate that the character is no longer alive.
     * It is removed form the field
     */
    protected void setDead() {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Place the character at the new location in the given field.
     * @param newLocation The character's new location.
     */
    protected void setlocation(Location newLocation) {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

}
