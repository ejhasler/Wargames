package Wargames.backend.filehandler;

import Wargames.backend.model.Army;
import Wargames.backend.model.Unit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

/**
 * Responsible for all file-activities related to the Unit, like saving and reading
 * from binary file (serializing), and import/export CSV-files.
 * Contains only static methods, where all methods either take an Unit
 * instance as parameter, or returns an Unit instance.
 */

public class UnitFileHandler {
  // Use ';' as delimiter for CSV-files to avoid problems with the address field using ','
  private static final String CSV_DELIMITER = ";";

  // Logger used for debugging
  private static final Logger logger = Logger.getLogger(UnitFileHandler.class.getName());

  public enum CSV_ARMY {
    ARMY_NAME, UNIT_ARMY, UNIT_NAME, UNIT_HEALTH
  }

  public static final HashMap<String, CSV_ARMY> CSV_FIELD_HEADER = new HashMap<>();
  static {
    CSV_FIELD_HEADER.put("Army Name", CSV_ARMY.ARMY_NAME);
    CSV_FIELD_HEADER.put("Army Unit", CSV_ARMY.UNIT_ARMY);
    CSV_FIELD_HEADER.put("Unit Name", CSV_ARMY.UNIT_NAME);
    CSV_FIELD_HEADER.put("Unit Health", CSV_ARMY.UNIT_HEALTH);
  }

  /**
   * Make the constructor private to avoid the possibility to
   * create an object from this class. Creating an object is not necessary
   * since all methods in the class are class-methods (static).
   */
  private UnitFileHandler() {
    // Intentionally left empty
  }

  /**
   * Exports the address book to a .csv file. The first line holds the
   * titles of the columns: Name, Phone and Address
   *
   * @param army the address book to export
   * @param file        the file to export the address book to
   * @throws IOException if the file exists but is a directory rather than a regular file,
   *                     does not exist but cannot be created,
   *                     or cannot be opened for any other reason
   */
  public static void exportToCsv(Army army, File file) throws IOException {

    FileWriter writer = new FileWriter(file);
    PrintWriter printWriter = new PrintWriter(writer);
    // Save the column titles.
    printWriter.println("Name" + CSV_DELIMITER + "Phone" + CSV_DELIMITER + "Address");

    for (Unit unit : army.getAllUnits()) {
      printWriter.print(army.getName() + CSV_DELIMITER);
      printWriter.print(unit.getName() + CSV_DELIMITER);
      printWriter.println(unit.getHealth() + CSV_DELIMITER);
    }

    printWriter.close();
  }

  /**
   * Import contacts from a CSV-file into en existing address book given
   * by the parameter.
   * The first line is expected to hold the titles of the columns: "Name, Phone and Address
   *
   * @param army the address book to import contacts into
   * @param file        the file to import from
   * @throws IOException if an I/O error occurs opening the file
   */
  public static void importArmyFromCsv(Army army, File file) throws IOException {
    // NOTE: I am using a try block here with no catch-block since
    // I want the exception to be sent to the caller of the method.
    // I could have left out the try-block entirely, BUT that could result in the
    // file not being closed in case of an exception being thrown
    // Hence, always use a try-with-resource when dealing with IO and resources like files,
    // even though you cannot handle a thrown exception in this method.
    try(BufferedReader reader = Files.newBufferedReader((file.toPath()))) {
      // The first line read is the column title line, and should
      // not be parsed as ContactDetails
      boolean isTitleLine = true;
      String lineOfText = reader.readLine();
      while (lineOfText != null) {
        if (!isTitleLine) {
          Army army = parseStringAsArmy(lineOfText);
          army.addUnit(unit);
        } else {
          isTitleLine = false;
        }
        lineOfText = reader.readLine();
      }
    }
  }

  /**
   * Parses a string to convert the string to an instance of ContactDetails.
   *
   * @param line the line of text holding the CSV-separated fields making up a contact
   * @return an instance of ContactDetails created from the line provided
   * @throws UnitFormatException if the string cannot be parsed as ContactDetails
   */
  private static Army parseStringAsArmy(String line) {
    Army army;
    String[] subStrings = line.split(CSV_DELIMITER);
    if (subStrings.length == 3){
      army = new Army(subStrings[0], subStrings[1], subStrings[2]);
    } else {
      throw new UnitFormatException();
    }
    return unit;
  }

  /**
   * Saves an entire address book to the given file using object serialization.
   *
   * @param army the address book to save
   * @param file        the file to save the address book to
   * @throws IOException if an I/O error occurs while writing to file
   */
  public static void saveToFile(Army army, File file) throws IOException {
    // NOTE: I am using a try block here with no catch-block since
    // I want the exception to be sent to the caller of the method.
    // I could have left out the try-block entirely, BUT that could result in the
    // file not being closed in case of an exception being thrown
    // Hence, always use a try-with-resource when dealing with IO and resources like files,
    // even though you cannot handle a thrown exception in this method.
    try (OutputStream outputStream = Files.newOutputStream(file.toPath())) {
      ObjectOutputStream objectOutStream = new ObjectOutputStream(outputStream);
      objectOutStream.writeObject(army);
    }
  }

  /**
   * Loads an entire address book from a given file using object serialization.
   * If the file cannot bbe read for some reason, an empty address book
   * is returned.
   *
   * @param inFile the file from which the address book will be loaded
   * @return an instance of AddressBook holding all contacts loaded from the file
   */
  public static Army loadFromFile(File inFile) {
    // NOTE: I am using a try block here with no catch-block since
    // I want the exception to be sent to the caller of the method.
    // I could have left out the try-block entirely, BUT that could result in the
    // file not being closed in case of an exception being thrown
    // Hence, always use a try-with-resource when dealing with IO and resources like files,
    // even though you cannot handle a thrown exception in this method.
    try (InputStream inputStream = Files.newInputStream(inFile.toPath())) {
      ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
      return (Army) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      logger.log(Level.INFO, () -> "Could not open file "
          + inFile.getName() + ". An empty AddressBook was returned.");
      return new ArmyPlain();
    }
  }
}