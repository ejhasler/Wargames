package Wargames;

/**
 * A class representing a model of an Infantry Unit. With different values for attack and armor.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class InfantryUnit extends Unit {

    /**
     * Create a new InfantryUnit.
     *
     * @param name The name of the unit
     * @param health The current health of the unit
     * @param attack The attack of the unit
     * @param armor The current armor of the unit
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Create a new InfantryUnit. With different values for attack(2) and armor(1).
     *
     * @param name The name of the unit
     * @param health The current health of the unit
     */
    public InfantryUnit(String name, int health) {
        super(name, health, 2, 1);
    }

    /**
     * Returns the meleeBonus that's value is set to 2.
     *
     * @return meleeBonus Returns the meleeBonus value
     */
    @Override
    public int getAttackBonus() {
        return 2;
    }

    /**
     * Returns the defenceBonus that's value is set to 1.
     *
     * @return defenceBonus Returns the defenceBonus value.
     */
    @Override
    public int getResistBonus() {
        return 1;
    }

}
