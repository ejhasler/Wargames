package Wargames.backend.model;


/**
 * A class representing a model of an CavalryUnit. With different values for attack and armor.
 * Cavalry Units are a bit stronger units with a charge attack at their first attack, it will
 * deal 4+2 bonus damage, and after they will have 2 bonus damage.
 *
 * And have a +1 resist bonus advantage when getting attacked.
 *
 * @author Even Johan Pereira Haslerud
 * @version 21.02.2022
 */
public class CavalryUnit extends Unit {

    /**
     * Create a new CavalryUnit.
     *
     * @param name The name of the unit
     * @param health The current health of the unit
     * @param attack The attack of the unit
     * @param armor The current armor of the unit
     */
    public CavalryUnit(String name, int health, int attack, int armor){
        super(name, health, attack, armor);
    }

    /**
     * Create a new CavalryUnit. With different values for attack(20) and armor(12).
     *
     * @param name The name of the unit
     * @param health The current health of the unit
     */
    public CavalryUnit(String name, int health){
        super(name, health, 20, 12);
    }

    /**
     * When attackNumber equals to 1, it returns the equation (charges + melee),
     * that equals 6 bonus.
     * When attackNumber equals to 2 or more, it returns (melee) that equals to 2.
     *
     * @return bonus Returns the bonus based on numbers attacked
     */
   @Override
    public int getAttackBonus(){
       int charged = 4;
       int melee = 2;
       int bonus = 0;

       if(attackNumber == 1){
           bonus = charged + melee;
       } else if(attackNumber >= 2) {
           bonus = melee;
       }
       return bonus;
    }

    /**
     * Returns the meleeBonus value that is set to 1.
     *
     * @return meleeBonus Returns the meleeBonus value
     */
    @Override
    public int getResistBonus(){
        return 1;
    }
}
