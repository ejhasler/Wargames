package Wargames;

import Wargames.backend.model.CommanderUnit;
import Wargames.backend.model.InfantryUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InfantryUnitTest {

    InfantryUnit infantryUnit = new InfantryUnit("Even", 100);


    /**
     * Test to check if getResistBonus returns the value 1. Test success.
     */
    // Test for å sjekke at getResistBonus returnerer verdien 1.
    @Test
    public void getResistBonus() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 50);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        commanderUnit.attack(infantryUnit);

        assertEquals(1, infantryUnit.getResistBonus());
    }

    /**
     * test to check if getAttackBonus returns the value 2. Test success.
     */
    @Test
    public void getAttackBonus1() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        commanderUnit.attack(infantryUnit);

        assertEquals(2, infantryUnit.getAttackBonus());
    }

    /**
     * testing full creation of the Infantry unit. Test Success.
     */
    @Test
    public void testFullCreationOfInfantryUnit() {
        String name = "Infantry Unit";
        int health = 100;
        int attack = 5;
        int armor = 8;
        InfantryUnit unit = new InfantryUnit(name, health, attack, armor);
        assertEquals(name, unit.getName());
        assertEquals(health, unit.getHealth());
        assertEquals(attack, unit.getAttack());
        assertEquals(armor, unit.getArmor());
    }
}
