package Wargames.backend.model;


/**
 * A class representing a model of an CommanderUnit. With different values for attack and armor.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class CommanderUnit extends CavalryUnit {

    /**
     * Create new CommanderUnit.
     *
     * @param name The name of the unit
     * @param health The current health of the unit
     * @param attack The attack of the unit
     * @param armor The current armor of the unit
     */
    public CommanderUnit(String name, int health, int attack, int armor){

        super(name, health, attack, armor);
    }

    /**
     * Create new CommanderUnit. Entered the different
     * values for attack(25) and armor(15).
     *
     * @param name The name of the unit
     * @param health The current health of the unit
     */
    public CommanderUnit(String name, int health){
        super(name, health, 25, 15);
    }

    /**
     * This method inherit from CavalryUnit's method getAttackBonus.
     *
     * @return attackBonus The current attackBonus, based on how many
     * numbers attacked.
     */
    @Override
    public int getAttackBonus(){

        return super.getAttackBonus();
    }

    /**
     * This method inherit from CavalryUnit's method getResistBonus.
     *
     * @return resistBonus Returns the resistBonus value, base
     * on how many numbers attacked.
     */
    @Override
    public int getResistBonus(){

        return super.getResistBonus();
    }
}
