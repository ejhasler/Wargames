package Wargames;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RangedUnitTest {

    RangedUnit rangedUnit = new RangedUnit("Even", 100);

    // Test for å sjekke at getAttackBonus endres etter 1 attack til 6.
    @Test
    public void getResistBonus() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 50);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 50);

        commanderUnit.attack(rangedUnit);

        assertEquals(6, rangedUnit.getResistBonus());
    }

    // Test for å sjekke at getAttackBonus endres etter 2 attack til 4.
    @Test
    public void getResistBonus2() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        commanderUnit.attack(rangedUnit);
        commanderUnit.attack(rangedUnit);

        assertEquals(4, rangedUnit.getResistBonus());
    }

    // Test for å sjekke at getAttackBonus endres etter 3 attack til 2.
    @Test
    public void getResistBonus3() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        commanderUnit.attack(rangedUnit);
        commanderUnit.attack(rangedUnit);
        commanderUnit.attack(rangedUnit);

        assertEquals(2, rangedUnit.getResistBonus());
    }

    // Test for å sjekke at getAttackBonus returnerer verdien 3.
    @Test
    public void getAttackBonus1() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

        rangedUnit.attack(rangedUnit);

        assertEquals(3, rangedUnit.getAttackBonus());
    }
}
