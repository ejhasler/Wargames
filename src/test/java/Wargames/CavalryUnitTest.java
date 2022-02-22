package Wargames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CavalryUnitTest {
    CavalryUnit cavalryUnit = new CavalryUnit("Even", 100);

    // Test for å sjekke at getResistBonus returnerer verdien 1.
    @Test
    public void getResistBonus() {
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 50);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        infantryUnit.attack(cavalryUnit);

        assertEquals(1, cavalryUnit.getResistBonus());
    }

    // Test for å sjekke at getAttackBonus returnerer verdien 6.
    @Test
    public void getAttackBonus1() {
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 50);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        infantryUnit.attack(cavalryUnit);

        assertEquals(6, cavalryUnit.getAttackBonus());
    }

    // Test for å sjekke at getAttackBonus returnerer verdien 2.
    @Test
    public void getAttackBonus2() {
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 50);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        infantryUnit.attack(cavalryUnit);
        infantryUnit.attack(cavalryUnit);

        assertEquals(2, cavalryUnit.getAttackBonus());
    }
}
