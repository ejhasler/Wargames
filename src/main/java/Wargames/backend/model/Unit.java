package Wargames.backend.model;

/**
 * Represents a unit. A unit that has a name, health(0 ->), attack(0 ->),
 * armor(0->) and attackNumber which tell how many times a unit has got attacked.
 *
 * @author Even Johan Pereira Haslerud
 * @version 20.02.2022
 */
public abstract class Unit {
    // Name of the unit.
    private String name;
    // Health of the unit.
    private int health;
    // Attacking of the unit.
    private int attack;
    // The armor of the unit.
    private int armor;
    // How many times it's been unit.
    int attackNumber;

    /**
     * Create an instance of a Unit with a given name, health, attack
     * and armor. The name can't be empty or blank, health can't be less than 0,
     * attack can't be less than 0 and armor can't be less than 0. If it happens
     * it will be thrown exceptions.
     *
     * @param name Name of the unit.
     * @param health The health value, can't be less than 0
     * @param attack The attacking of the unit
     * @param armor The armor of the unit
     * @throws IllegalArgumentException Throws arguments if values are entered that is not in the right range
     */
    public Unit(String name, int health, int attack, int armor) {
        // A good recommended practice is to always use set-methods in the
        // constructors, and to make sure that the set-methods performs the
        // necessary validity-checks on the parameter.
        // This puts the checks in one place, and one place only, which is
        // important especially if multiple constructors are being implemented.
        this.setName(name);
        this.setHealth(health);
        this.setAttack(attack);
        this.setArmor(armor);
    }

    /**
     * Attack that follows a certain form: Health = Health - (attack + attackBonus) + (armor + resistBonus).
     *
     * @param opponentUnit The unit that is getting attacked
     */
    public void attack(Unit opponentUnit) {
        // The attackDamage
        int attackDamage = this.getAttack() + this.getAttackBonus();
        // The resist
        int resistance = opponentUnit.getArmor() + opponentUnit.getResistBonus();
        // Finds the Health after opponentUnit got attacked
        opponentUnit.setHealth(
                opponentUnit.getHealth()
                        - (this.attack
                        + this.getAttackBonus() + (opponentUnit.getArmor())
                        + opponentUnit.getResistBonus()));
        opponentUnit.attackNumber++;
    }

    /**
     * Return the name of the unit.
     * @return The name of the unit
     */
    public String getName() {

        return name;
    }

    /**
     * Sets the name of the unit.
     * If the name <code>null</code>, or is empty (length is 0), a
     * {@link java.lang.IllegalArgumentException} will be thrown.
     * 
     * @param name the new name of the unit
     * @throws IllegalArgumentException if the name is <code>null</code> or empty.
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        
        if(name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    /**
     * Return health of the unit.
     * @return The health of the unit
     */
    public int getHealth() {

        return health;
    }

    /**
     * Indicate the health of the unit.
     *
     * @param health The health can't be less den 0, if the value
     *               is less than 0, it will be printed a String,
     *               shown in the Unit constructor.
     */
    public void setHealth(int health) {
        if(health <= 0) {
            throw new IllegalArgumentException("ERROR: The Health can't be entered as less than or equal 0.");
        }

        this.health = health;
    }

    /**
     * Return attacking of the unit.
     * @return The attacking of the unit
     */
    public int getAttack() {

        return attack;
    }

    /**
     * Sets the attack of the unit.
     * If the attack is <code>null</code> or if attack < 0, a
     * {@link IllegalArgumentException} will be thrown.
     * 
     * @param attack the attack of the unit
     * @throws IllegalArgumentException if the name is <code>null</code> or attack < 0.
     */
    public void setAttack(int attack) {
        if (attack == 0) {
            throw new IllegalArgumentException("Attack number should not be null!!");
        }

        if(attack < 0) {
            throw new IllegalArgumentException("Attack can't be negative!");
        }
        
        this.attack = attack;
    }

    /**
     * Return the armor of the unit.
     * @return The armor of the unit
     */
    public int getArmor () {

        return armor;
    }

    /**
     * Sets the armor of the unit.
     * If the armor is <code>negative</code>, a
     * {@link IllegalArgumentException} will be thrown.
     *
     * @param armor the armor of the unit
     * @throws IllegalArgumentException if the name is <code>null</code>.
     */
    public void setArmor(int armor) {

        if(armor < 0) {
            throw new IllegalArgumentException("Armor can't be negative!");
        }

        this.armor = armor;
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
     * Returns the current attack bonus of the Unit.
     * @return attack bonus
     */
    abstract protected int getAttackBonus();

    /**
     * Returns the current resist bonus of the Unit.
     * @return resist bonus.
     */
    abstract protected int getResistBonus();

}
