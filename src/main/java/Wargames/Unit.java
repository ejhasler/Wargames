package Wargames;

/**
 * A class representing different types of units and
 * varying defending and attacking abilities.
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
     * Create a new Unit.
     *
     * @param name Name of the unit
     * @param health The health value, can't be less than 0
     * @param attack The attacking of the unit
     * @param armor The armor of the unit
     */
    public Unit(String name, int health, int attack, int armor) {
        // Name can't be blank. Need to enter a name!
        if(name.isBlank()) {
            System.out.println("You need to give the Unit a name!");
        }
        // The health can't be less than 0.
        if(health < 0) {
            System.out.println("ERROR: The Health can't be less than 0.");
        }
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Attack that follows a certain form: Health = Health - (attack + attackBonus) + (armor + resistBonus).
     *
     * @param opponentUnit The unit that is getting attacked
     */
    protected void attack(Unit opponentUnit) {
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
    protected String getName() {

        return name;
    }

    /**
     * Return health of the unit.
     * @return The health of the unit
     */
    protected int getHealth() {

        return health;
    }

    /**
     * Return attacking of the unit.
     * @return The attacking of the unit
     */
    protected int getAttack() {

        return attack;
    }

    /**
     * Return the armor of the unit.
     * @return The armor of the unit
     */
    protected int getArmor () {

        return armor;
    }

    /**
     * Indicate the health of the unit.
     *
     * @param health The health can't be less den 0, if the value
     *               is less than 0, it will be printed a String,
     *               shown in the Unit constructor.
     */
    protected void setHealth(int health) {

        this.health = health;
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
