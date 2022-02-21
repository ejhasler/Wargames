package Wargames;

/**
 * A class representing an Infantry Unit. With different values.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class InfantryUnit extends Unit {
    // Attack value
    private static final int ATTACK = 15;
    // Armor value
    private static final int ARMOR = 10;
    // The attackBonus after an attack attempt
    private int attackBonus;
    // The resistBonus after receive an attack
    private int resistBonus;

    /**
     * Create a new InfantryUnit.
     *
     * @param name The name of the character.
     * @param health The current health of the character
     * @param attack The attack of the character
     * @param armor The current armor of the character
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
        this.attackBonus = 2;
        this.resistBonus = 1;
    }

    /**
     * Returns the attackBonus value.
     * @return attackBonus Returns the attackBonus value
     */
    @Override
    public int getAttackBonus() {

        return attackBonus;
    }

    /**
     * Returns the resistBonus value.
     * @return resistBonus Returns the resistBonus value.
     */
    @Override
    public int getResistBonus() {

        return resistBonus;
    }

}
