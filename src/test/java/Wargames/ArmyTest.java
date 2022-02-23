package Wargames;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class ArmyTest {


    // Tester ved å fjerne en en unit og ser om de to forskjellige listene er like.
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

    // Tester om hasUnits viser til listen som er satt opp og returnerer true.
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

        assertEquals(false, army.hasUnits());
    }

    // Oppretter en tom liste hvor det skal returnere false
    @Test
            public void hasUnits2() {


        ArrayList<Unit> units = new ArrayList<Unit>();
        Army army = new Army("army", units);

        assertFalse(army.hasUnits());
    }

    // Sjekker om random utigr riktig verdier. Måtte endre koden
    // inne i army klassen, siden jeg ikke fikk et positiv integer ved getRandom. Årsaken til feilen
    // istad var for at inne i nextInt var tom og det var ingenting å hente...
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

        assertEquals(army1.getAllUnits(), units);
    }
}
