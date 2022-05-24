package Wargames;






import static org.junit.jupiter.api.Assertions.assertEquals;

import Wargames.backend.model.CommanderUnit;
import Wargames.backend.model.InfantryUnit;
import org.junit.jupiter.api.Test;


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

    /**
     * testing full creation of the Commander unit. Test Success.
     */
    @Test
    public void testFullCreationOfCommanderUnit() {
        String name = "Commander Unit";
        int health = 100;
        int attack = 5;
        int armor = 8;
        CommanderUnit unit = new CommanderUnit(name, health, attack, armor);
        assertEquals(name, unit.getName());
        assertEquals(health, unit.getHealth());
        assertEquals(attack, unit.getAttack());
        assertEquals(armor, unit.getArmor());
    }
}
