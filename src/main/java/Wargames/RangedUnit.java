package Wargames;


/**
 * A class representing a model of an RangedUnit. With different values for attack and armor.
 * This Unit has the ability to attack at range.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class RangedUnit extends Unit {

    int rangeDefence;

    /**
     * Create RangedUnit.
     * @param name The name of the unit
     * @param health The current health of the unit
     * @param attack The attack of the unit
     * @param armor The armor of the unit
     */
    public RangedUnit(String name, int health, int attack, int armor){

        super(name, health, attack, armor);
    }

    /**
     * Create RangedUnit. Entered the different
     * values for attack(15) and armor(8).
     *
     * @param name The name of the unit
     * @param health The current health of the unit
     */
    public RangedUnit(String name, int health){

        super(name, health, 15, 8);
    }

    /**
     * Returns the rangeBonus of the character. Since this class
     * has a longer range the rangeBonus is slightly better than
     * other units.
     *
     * @return The attackBonus
     */
    @Override
    public int getAttackBonus(){

        return 3;
    }

    /**
     * When attackNumber equals to 1, it returns 6 in rangeDefence.
     * When attackNumber equals to 2, it returns 4 in rangeDefence.
     * When attackNumber equals to 3 or more, it returns 2 as a standard number for
     * range Defence.
     *
     * @return rangeDefence Returns rangeDefence in based on numbersAttacked
     */
    @Override
    public int getResistBonus(){

        if(attackNumber == 1) {
            rangeDefence = 6;
        } else if(attackNumber == 2) {
            rangeDefence = 4;
        } else if (attackNumber >= 3) {
            rangeDefence = 2;
        }
        return rangeDefence;
    }
}
