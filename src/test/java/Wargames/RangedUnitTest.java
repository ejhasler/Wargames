package Wargames;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RangedUnitTest {

    // Test for å sjekke at getAttackBonus endres etter 1, 2 og 3 attacks.
    @Test
    public void getResistBonusSuccess1() {
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 50);
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 50);

        commanderUnit.attack(rangedUnit);

        assertEquals(6, rangedUnit.getResistBonus());
    }
}
