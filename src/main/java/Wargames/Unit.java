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
    private int attack;
    // The armor of the character
    private int armor;

    /**
     * Create a new Unit.
     *
     * @param name The name of the character.
     * @param health The health status of the character.
     * @param attack The attacking of the character.
     * @param armor The armor of the character.
     */
    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Attack that follows a certain form: Health = Health - (attack + attackBonus) + (armor + resistBonus)
     */
    protected void attack() {
        this.health = this.health - (attack + getAttackBonus()) + (getArmor() + getResistBonus());
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
    protected int getAttack() {

        return attack;
    }

    /**
     * Return the armor of the character.
     * @return The armor of the character.
     */
    protected int getArmor () {

        return armor;
    }

    /**
     * Indicate the health of the character.
     * Health >=0
     */
    protected void setHealth() {
        if(health >= 0) {
            System.exit(0);
        }
    }

    /**
     * Returns class and fields in text.
     * @return  class and fields in text.
     */
    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                '}';
    }

    /**
     * Return attack bonus.
     * @return attack bonus
     */
    abstract protected int getAttackBonus();

    /**
     * Return resist bonus.
     * @return resist bonus.
     */
    abstract protected int getResistBonus();


}
