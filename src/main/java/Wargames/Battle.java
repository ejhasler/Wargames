package Wargames;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class representing a Battle between to armies.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class Battle {
    // The first Army of the units
    private Army armyOne;
    // The second Army of the units
    private Army armyTwo;

    private Army winner;

    private String attackingArmy;

    private String defendingArmy;

    /**
     * Create a new battle between armyOne and armyTwo
     *
     * @param armyOne The first army with units
     * @param armyTwo The second army with units
     */
    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    /**
     *Simulates a battle between two armies. A random unit from an army1
     * attacks a random unit army2. When a unit reach health 0, it will get defeated
     * and when all units in the army has reached 0 in health the army has been
     * defeated.
     * U can't engage a battle if not entered units.
     */
    public Army simulate() {

        if (winner != null) throw new UnsupportedOperationException("The simulation has run!");


        while (armyOne.hasUnits() && armyTwo.hasUnits()) {

            Army attackingArmy;
            Army defendingArmy;

            int index = new Random().nextInt(2);
            if (index == 0) {
                attackingArmy = armyOne;
                defendingArmy = armyTwo;
            } else {
                attackingArmy = armyTwo;
                defendingArmy = armyOne;
            }

            Unit attacker = attackingArmy.getRandomUnit();
            Unit defender = defendingArmy.getRandomUnit();

            attacker.attack(defender);


            if (defender.getHealth() <= 0) {
                defendingArmy.removeUnit(defender);
            }

        }
        winner = (armyOne.hasUnits()) ? armyOne : armyTwo;
        return winner;

    }

    public Army getWinner(){
        return winner;
    }

    /**
     * Returns a String with Battle, armyOne and armyTwo
     *
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
