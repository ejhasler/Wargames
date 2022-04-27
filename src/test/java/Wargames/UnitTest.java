package Wargames.model;


import Wargames.backend.model.CavalryUnit;
import Wargames.backend.model.CommanderUnit;
import Wargames.backend.model.InfantryUnit;
import Wargames.backend.model.RangedUnit;
import Wargames.backend.model.Unit;
import Wargames.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {

    /**
     * Checks if the units is not blank. test Success.
     */
    @Test
    public void testMethodOfUnitIsNotBlank() {
    Unit unit = new InfantryUnit("Unit", 100);
    assertTrue(!unit.toString().isBlank());
}

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

