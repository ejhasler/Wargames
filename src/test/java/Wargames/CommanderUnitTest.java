package Wargames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommanderUnitTest {
    CommanderUnit commmanderUnit = new CommanderUnit("Even", 100);

    // Test for å sjekke at getResistBonus returnerer verdien 1.
    @Test
    public void getResistBonus() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 50);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        infantryUnit.attack(commanderUnit);

        assertEquals(1, commanderUnit.getResistBonus());
    }

    // Test for å sjekke at getAttackBonus returnerer verdien 6.
    @Test
    public void getAttackBonus1() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        infantryUnit.attack(commanderUnit);

        assertEquals(6, commanderUnit.getAttackBonus());
    }

    // Test for å sjekke at getAttackBonus returnerer verdien 2.
    @Test
    public void getAttackBonus2() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        infantryUnit.attack(commanderUnit);
        infantryUnit.attack(commanderUnit);

        assertEquals(2, commanderUnit.getAttackBonus());
    }
}
