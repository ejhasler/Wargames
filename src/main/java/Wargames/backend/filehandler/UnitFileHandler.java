package Wargames.backend.filehandler;


import Wargames.backend.model.Army;
import Wargames.backend.model.Unit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

/**
 * Responsible for all file-activities related to the Unit, like saving and reading
 * from binary file (serializing), and import/export CSV-files.
 * Contains only static methods, where all methods either take a Unit
 * instance as parameter, or returns a Unit instance.
 */

public class UnitFileHandler {
  // Use ';' as delimiter for CSV-files to avoid problems with the address field using ','
  private static final String CSV_DELIMITER = ";";


  private static final Logger logger = Logger.getLogger(UnitFileHandler.class.getName());

  /**
   * Create a UnitFileHandler
   */
  public UnitFileHandler() {
    // Intentionally left empty
  }

  /**
   * Import armies from a CSV-file into en existing unit given
   * by the parameter.
   * The first line is expected to hold the titles of the columns: ?
   *
   * @param army the army to import contacts into
   * @param file the file to import from
   * @throws IOException if an I/O error occurs if the file was not found
   */
  public static void importFromCsv(Army army, File file) throws IOException {

    Charset charset = Charset.forName("US-ASCII");
    Path path = Path.of("ExportFile.csv");

    try{
      BufferedReader reader = Files.newBufferedReader(path, charset);
      String lineOfText;

      while ((lineOfText = reader.readLine()) != null){
        System.out.println(lineOfText);
      }
      reader.close();
    } catch (FileNotFoundException e){
      System.out.println("File was not found...");
    }

  }



  /**
   * Exports the Army to a .csv file. The first line holds the
   * titles of the columns: Army Name, Unit Type, Unit Name and Unit Health
   *
   * @param army the address book to export
   * @param file the file to export the Army to
   * @throws IOException if the file exists but is a directory rather than a regular file,
   *                     does not exist but cannot be created,
   *                     or cannot be opened for any other reason
   */
  public static void exportToCsv(Army army, File file) throws IOException {

    FileWriter writer = new FileWriter(file);
    PrintWriter printWriter = new PrintWriter(writer);

    printWriter.println("Army Name" + CSV_DELIMITER
        + "Unit Type" + CSV_DELIMITER
        + "Units" + CSV_DELIMITER
        + "Health" + CSV_DELIMITER);

    for (Unit unit : army.getAllUnits()) {
      printWriter.print(army.getName());
      printWriter.print(unit.getUnitType() + CSV_DELIMITER);
      printWriter.print(unit.getName() + CSV_DELIMITER);
      printWriter.print(unit.getHealth() + CSV_DELIMITER);
    }

    printWriter.close();

  }


  /**
   * Saves an entire army to the given file using object serialization.
   *
   * @param army the army to save
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
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
      objectOutputStream.writeObject(army);
    }
  }

  /**
   * Used this constructor to test with File Placing.
   * @param args Creates a new file
   * @throws IOException doesn't throw any Exception.
   */
  public static void main(String[] args) throws IOException {
    String path = System.getProperty("IntelliJ");
    File file = new File(path + "\\SkoleArbeid" + "\\Wargames"+ "\\Text.csv");
    file.createNewFile();
    file.mkdir();
  }

  /**
   * Opens a window to open the file.
   * Prompts the user to select a csv file.
   * Only "csv" files!!
   *
   * @return returns a file object from the file chooser window
   */
  public static File getFile(){
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*csv"));
    return fileChooser.showOpenDialog(null);
  }

  public static Army loadFromFile(File inFile){
    try(InputStream inputStream = Files.newInputStream(inFile.toPath())){
      ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
      return (Army) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      logger.log(Level.INFO, () -> "Could not open file "
          + inFile.getName() + ". An empty AddressBook was returned.");
      return new Army();
    }
  }



}