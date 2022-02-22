package Wargames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InfantryUnitTest {

    InfantryUnit infantryUnit = new InfantryUnit("Even", 100);

    // Test for å sjekke at getResistBonus returnerer verdien 1.
    @Test
    public void getResistBonus() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 50);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        commanderUnit.attack(infantryUnit);

        assertEquals(1, infantryUnit.getResistBonus());
    }

    // Test for å sjekke at getAttackBonus returnerer verdien 2.
    @Test
    public void getAttackBonus1() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        commanderUnit.attack(infantryUnit);

        assertEquals(2, infantryUnit.getAttackBonus());
    }
}
