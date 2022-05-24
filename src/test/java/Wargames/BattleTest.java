package Wargames;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Wargames.backend.model.Army;
import Wargames.backend.model.Battle;
import Wargames.backend.model.CavalryUnit;
import Wargames.backend.model.CommanderUnit;
import Wargames.backend.model.InfantryUnit;
import Wargames.backend.model.RangedUnit;
import Wargames.backend.model.Unit;


import java.util.ArrayList;
import org.junit.jupiter.api.Test;


public class BattleTest {

    /**
     * The strongest army wins. test success.
     */
    @Test
    public void testThatStrongerArmWins() {
    Army army1 = new Army("Army 1");
    Army army2 = new Army("Army 2");

    army1.addUnit(new InfantryUnit("Infantry Unit 1", 100));
    army2.addUnit(new InfantryUnit("Infantry Unit 2", 100));

    Battle battle = new Battle(army1, army2);

    assertEquals(battle.simulate() ,army2);
}

    /**
     * winning army has units left. Test success.
     */
    @Test
    public void winningArmyHasUnitsLeft() {
    CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);
    InfantryUnit infantryUnit = new InfantryUnit("InfantryUnit", 100);
    RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);

    ArrayList<Unit> units = new ArrayList<Unit>();
    units.add(rangedUnit);
    units.add(infantryUnit);
    units.add(commanderUnit);

    Army army1 = new Army("army 1", units);

    army1.addAll(units);

    ArrayList<Unit> units2 = new ArrayList<Unit>();
    units2.add(rangedUnit);
    Army army2 = new Army("army 2", units2);

    army2.addAll(units2);

    Battle battle = new Battle(army1, army2);
    Army winningArmy = battle.simulate();

    assertTrue(winningArmy.hasUnits());
    if(!winningArmy.equals(army2))
        assertFalse(army2.hasUnits());
    else
        assertFalse(army1.hasUnits());
}

    /**
     * should throw IllegalArgumentException. Test success.
     */
    @Test
public void hasNotUnits() {

    RangedUnit rangedUnit = new RangedUnit("RangedUnit", 100);
    CavalryUnit cavalryUnit = new CavalryUnit("CavalryUnit", 100);
    CommanderUnit commanderUnit = new CommanderUnit("CommanderUnit", 100);

    ArrayList<Unit> units = new ArrayList<Unit>();


    Army army = new Army("army", units);



    assertEquals(false, army.hasUnits());
}
}
