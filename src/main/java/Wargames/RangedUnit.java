package Wargames;


/**
 * A class representing an RangedUnit. With different values.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class RangedUnit extends Unit {
    // Attack value
    private static final int ATTACK = 15;
    // Armor value
    private static final int ARMOR = 8;
    // The attackBonus after an attack attempt
    private int attackBonus;
    // The resistBonus after receive an attack
    private int resistBonus;

    /**
     * Create RangedUnit.
     * @param name The name of the character
     * @param health The current health of the character
     * @param attack The attack of the character
     * @param armor The armor of the character
     */
    public RangedUnit(String name, int health, int attack, int armor){
        super(name, health, attack, armor);
        this.attackBonus = 3;
    }

    /**
     * Returns the attackBonus of the character. Since this class
     * has a longer range the attackBonus is better.
     * @return The attackBonus
     */
    @Override
    public int getAttackBonus(){
        return attackBonus;
    }

    /**
     * Returns 6 resistBonus with a long range. Then returns
     * 4 resistBonus with a mid-range. Then returns 2 resistBonus as standard.
     */
    @Override
    public int getResistBonus(){

        int defendCounter = 0;

        if(defendCounter == 0) {
            resistBonus = 6;
        }

        if(defendCounter == 1){
            resistBonus = 4;
        }

        if(defendCounter > 1){
            resistBonus = 2;
        }
        defendCounter++;
        return resistBonus;

    }
}
