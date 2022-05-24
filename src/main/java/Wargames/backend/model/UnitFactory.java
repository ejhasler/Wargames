package Wargames.backend.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represent unit type, with the different units and values.
 *
 * @author Even Johan Pereira Haslerud
 * @version 16-05-2022
 */
public class UnitFactory {

  // Unit types.
  private static final List<String> UNIT_TYPE = List.of("Cavalry", "Commander", "Infantry", "Ranged");

  /**
   * Creates an instance of UnitFactory
   */
  private UnitFactory(){
    // Empty
  }

  /**
   * Creates a unit with the values needed.
   *
   * @param unitType The unit type
   * @param unitName Name of the unit
   * @param unitHealth The health of the unit
   * @return return the unit.
   */
  public static Unit createUnit(String unitType, String unitName, int unitHealth) {
    if (unitHealth <= 0 || unitName.isEmpty()) {
      return null;
    }

    return switch (unitType) {
      case "Cavalry" -> new CavalryUnit(unitName, unitHealth);
      case "Commander" -> new CommanderUnit(unitName, unitHealth);
      case "Infantry" -> new InfantryUnit(unitName, unitHealth);
      case "Ranged" -> new RangedUnit(unitName, unitHealth);
      default -> null;
    };
  }

  /**
   * Creates an arraylist of the Units created.
   *
   * @param amount Amount of units
   * @param unitType The unitType
   * @param unitName Name of the unit
   * @param unitHealth The health of the unit
   * @return Returns the unit list
   * @throws IllegalArgumentException Throws exception for the different value amount<=0,
   *                                  unitHealth <= 0 and if unitNameIsEmpty.
   */
  public static List<Unit> createListOfUnit(int amount, String unitType, String unitName, int unitHealth) throws IllegalArgumentException {
    List<Unit> unitList = new ArrayList<>();

    if(!(UNIT_TYPE.contains(unitType))) {
      throw new IllegalArgumentException("Unknown unit type given");
    }
    if (amount <= 0){
      throw new IllegalArgumentException("Amount was negative");
    }
    if( unitHealth <= 0){
      throw new IllegalArgumentException("Unit health was negative");
    }
    if(unitName.isEmpty()){
      throw new IllegalArgumentException("No name given");
    }

    for (int i = 0; i<amount; i++){
      unitList.add(createUnit(unitType, unitName, unitHealth));
    }
    return unitList;
  }
}
