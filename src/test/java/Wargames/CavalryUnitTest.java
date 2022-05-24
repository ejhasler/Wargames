package Wargames;






import static org.junit.jupiter.api.Assertions.assertEquals;

import Wargames.backend.model.CavalryUnit;
import Wargames.backend.model.InfantryUnit;
import org.junit.jupiter.api.Test;


public class CavalryUnitTest {
    CavalryUnit cavalryUnit = new CavalryUnit("Even", 100);

    /**
     * test to check if getResistBonus returns value 1. Test success.
     */
    // Test for å sjekke at getResistBonus returnerer verdien 1.
    @Test
    public void getResistBonus() {
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 50);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        infantryUnit.attack(cavalryUnit);

        assertEquals(1, cavalryUnit.getResistBonus());
    }

    /**
     * Test to check if getAttackBonus returns value 4. Test Success
     */
    // Test for å sjekke at getAttackBonus returnerer verdien 6.
    @Test
    public void getAttackBonus1() {
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 50);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        infantryUnit.attack(cavalryUnit);

        assertEquals(6, cavalryUnit.getAttackBonus());
    }

    /**
     * Test to check if getAttackBonus returns value 2.
     */
    @Test
    public void getAttackBonus2() {
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 50);
        InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 50);

        infantryUnit.attack(cavalryUnit);
        infantryUnit.attack(cavalryUnit);

        assertEquals(2, cavalryUnit.getAttackBonus());
    }

    /**
     * testing full creation of the Cavalry unit. Test Success.
     */
    @Test
    public void testFullCreationOfCavalryUnit() {
        String name = "Cavalry Unit";
        int health = 100;
        int attack = 5;
        int armor = 8;
        CavalryUnit unit = new CavalryUnit(name, health, attack, armor);
        assertEquals(name, unit.getName());
        assertEquals(health, unit.getHealth());
        assertEquals(attack, unit.getAttack());
        assertEquals(armor, unit.getArmor());
    }
}
