package Wargames;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RangedUnitTest {

    RangedUnit rangedUnit = new RangedUnit("Even", 100);

    /**
     * Test to check if getAttackBonus changes after first attack to 6. Test success.
     */
    @Test
    public void getResistBonus() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 50);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 50);

        commanderUnit.attack(rangedUnit);

        assertEquals(6, rangedUnit.getResistBonus());
    }

    /**
     * Test to check if getAttackBonus changes second attack to 4. Test success.
     */
    @Test
    public void getResistBonus2() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        commanderUnit.attack(rangedUnit);
        commanderUnit.attack(rangedUnit);

        assertEquals(4, rangedUnit.getResistBonus());
    }

    /**
     * Test to check if getAttackBonus changes after third attack to 2. Test success.
     */
    @Test
    public void getResistBonus3() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        commanderUnit.attack(rangedUnit);
        commanderUnit.attack(rangedUnit);
        commanderUnit.attack(rangedUnit);

        assertEquals(2, rangedUnit.getResistBonus());
    }

    /**
     * test to check that getAttackbonus returns value 3. Test success.
     */
    @Test
    public void getAttackBonus1() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        rangedUnit.attack(rangedUnit);

        assertEquals(3, rangedUnit.getAttackBonus());
    }

    /**
     * testing full creation of the Ranged Unit. Test Success.
     */
    @Test
    public void testFullCreationOfRangedUnit() {
        String name = "Ranged Unit";
        int health = 100;
        int attack = 5;
        int armor = 8;
        RangedUnit unit = new RangedUnit(name, health, attack, armor);
        assertEquals(name, unit.getName());
        assertEquals(health, unit.getHealth());
        assertEquals(attack, unit.getAttack());
        assertEquals(armor, unit.getArmor());
    }
}
