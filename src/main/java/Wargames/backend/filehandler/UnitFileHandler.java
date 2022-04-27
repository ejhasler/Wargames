package Wargames.backend.filehandler;

import Wargames.backend.model.Army;
import Wargames.backend.model.Unit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
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

  /**
   * Make the constructor private to avoid the possibility to
   * create an object from this class. Creating an object is not necessary
   * since all methods in the class are class-methods (static).
   */
  private UnitFileHandler() {
    // Intentionally left empty
  }

  /**
   * Exports the army to a .csv file. The first line holds the
   * titles of the columns: army name, unit type and health.
   *
   * @param army the army to export
   * @param file        the file to export the address book to
   * @throws IOException if the file exists but is a directory rather than a regular file,
   *                     does not exist but cannot be created,
   *                     or cannot be opened for any other reason
   */
  public static void exportToCSV(Army army, File file) throws IOException {

    FileWriter writer = new FileWriter(file);
    PrintWriter printWriter = new PrintWriter(writer);
    // Save the column titles.
    printWriter.println("Name" + CSV_DELIMITER + "Health" + CSV_DELIMITER + "Armor");

    for (Unit unit : army.getAllUnits()) {
      printWriter.print(army.getName() + CSV_DELIMITER);
      printWriter.print(unit.getName() + CSV_DELIMITER);
      printWriter.println(unit.getHealth() + CSV_DELIMITER);
    }

    printWriter.close();
  }

  /**
   * Import units from a CSV-file into en existing army given
   * by the parameter.
   * The first line is expected to hold the titles of the columns: "Army name, unit type and health.
   *
   * @param army the address book to import contacts into
   * @param file        the file to import from
   * @throws IOException if an I/O error occurs opening the file
   */
  public static void importFromCsv(Army army, File file) throws IOException {
    // NOTE: I am using a try block here with no catch-block since
    // I want the exception to be sent to the caller of the method.
    // I could have left out the try-block entirely, BUT that could result in the
    // file not being closed in case of an exception being thrown
    // Hence, always use a try-with-resource when dealing with IO and resources like files,
    // even though you cannot handle a thrown exception in this method.
    try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
      // The first line read is the column title line, and should
      // not be parsed as ContactDetails
      boolean isTitleLine = true;
      String lineOfText = reader.readLine();
      while (lineOfText != null) {
        if (!isTitleLine) {
          Unit unit = parseStringAsUnit(lineOfText);
          army.addUnit(army.getRandomUnit());
        } else {
          isTitleLine = false;
        }
        lineOfText = reader.readLine();
      }

  /**
   *
   */
  public static File getFile(){
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

  return fileChooser.showOpenDialog(null);
  }
}
