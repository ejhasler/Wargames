package Wargames;

import java.util.ArrayList;

/**
 * A class representing a Battle.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class Battle {
    // The first Army of the units
    private Army armyOne;
    // The second Army of the units
    private Army armyTwo;

    /**
     * Create a new battle between armyOne and armyTwo
     * @param armyOne The first army with units
     * @param armyTwo The second army with units
     */
    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    /**
     *Simulates a battle between two armies. A random unit from an army1
     * attacks a random army2. The first army to have health = 0,
     * will be defeated.
     */
    public void Battles(ArrayList<Unit> armyOne, ArrayList<Unit> armyTwo ) {

    }

    /**
     * Returns a String with Battle, armyOne and armyTwo
     * @return String The string contains Battle, armyOne and armyTwo
     */
    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }
}
