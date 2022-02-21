package Wargames;


/**
 * A class representing a model of an CavalryUnit. With different values.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class CavalryUnit extends Unit{
    // Attack value
    private static final int ATTACK = 20;
    // Armor value
    private static final int ARMOR = 12;
    // The attackBonus after an attack attempt
    private int attackBonus;
    // The resistBonus after receive an attack
    private int resistBonus;

    /**
     * Create a new CavalryUnit.
     *
     * @param name The name of the character
     * @param health The current health of the character.
     * @param attack The attack of the character
     * @param armor The current armor of the character
     */
    public CavalryUnit(String name, int health, int attack, int armor){
        super(name, health, attack, armor);
        this.attackBonus = getAttackBonus();
        this.resistBonus = 1;
    }

    /**
     * First attack attempt will give an attackBonus(4) + 2 points. After the first attempt
     * it will return to the given value which is 2.
     * @return The current attackBonus.
     */
   @Override
    public int getAttackBonus(){

        int counterAttack = 0;
        if(counterAttack == 0) {
           int firstAttack = attackBonus + 2;
       } else {
            attackBonus = 4;
        }

        return attackBonus;
    }

    /**
     * Returns the resistBonus value.
     * @return resistBonus Returns the resistBonus value.
     */
    @Override
    public int getResistBonus(){

        return resistBonus;
    }
}
