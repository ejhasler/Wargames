package Wargames;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class ArmyTest {

    /**
     * test if i can add units to the army. test success.
     */
    @Test
   public void testAdd() {
        InfantryUnit unit = new InfantryUnit("Test Unit", 100);
        Army army = new Army("Test Army");
        army.addUnit(unit);

        assertTrue(army.hasUnits());
    }


    /**
     * test to add all Units. Test success.
     */
    @Test
    public void testAddAll() {
        ArrayList<Unit> units = new ArrayList<Unit>();
        InfantryUnit unit1 = new InfantryUnit("Test Unit 1", 100);
        InfantryUnit unit2 = new InfantryUnit("Test Unit 2", 100);

        units.add(unit1);
        units.add(unit2);

        Army army = new Army("Test Army");

        army.addAll(units);

        assertEquals(units, army.getAllUnits());
    }

    /**
     * Test to remove a unit. test success.
     */
    @Test
    public void removeUnit() {
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> unitsWithCommanderUnit = new ArrayList<Unit>();
        unitsWithCommanderUnit.add(rangedUnit);
        unitsWithCommanderUnit.add(cavalryUnit);
        unitsWithCommanderUnit.add(commanderUnit);

        ArrayList<Unit> unitsWithoutCommanderUnit = new ArrayList<Unit>();
        unitsWithoutCommanderUnit.add(rangedUnit);
        unitsWithoutCommanderUnit.add(cavalryUnit);

        Army army1 = new Army("army", unitsWithCommanderUnit);
        Army army2 = new Army("army", unitsWithoutCommanderUnit);

        army1.removeUnit(commanderUnit);

        assertEquals(army1, army2);
    }


    /**
     * test if hasUnits shows to the list and returns true. Test success.
     */
    @Test
     public void hasUnits1() {

        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(rangedUnit);
        units.add(cavalryUnit);
        units.add(commanderUnit);

        Army army = new Army("army", units);

        army.addAll(units);

        assertEquals(true, army.hasUnits());
    }

    /**
     * Creates an empty list at should return false. test success.
     */
    @Test
            public void hasUnits2() {


        ArrayList<Unit> units = new ArrayList<Unit>();
        Army army = new Army("army", units);

        assertFalse(army.hasUnits());
    }

    /**
     * check of random gives right values. Test success.
     */
    @Test
    public void randomUnit(){
        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(rangedUnit);
        units.add(cavalryUnit);
        units.add(commanderUnit);

        Army army1 = new Army("army", units);

        System.out.println(army1.getRandomUnit());
    }

    /**
     * return all units listed. Test success.
     */
    @Test
    public void getAllUnits() {

        RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
        CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 100);
        CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(rangedUnit);
        units.add(cavalryUnit);
        units.add(commanderUnit);

        Army army1 = new Army("army", units);

        army1.addAll(units);

        assertEquals(units, army1.getAllUnits());
    }
    
}
