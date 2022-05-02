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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
   * @param file        the file to import from
   * @throws IOException if an I/O error occurs if the file was not found
   */
  public static void importArmyFromCSV(Army army, File file) throws IOException {
    // NOTE: I am using a try block here with no catch-block since
    // I want the exception to be sent to the caller of the method.
    // I could have left out the try-block entirely, BUT that could result in the
    // file not being closed in case of an exception being thrown
    // Hence, always use a try-with-resource when dealing with IO and resources like files,
    // even though you cannot handle a thrown exception in this method.
    Charset charset = Charset.forName("US-ASCII");
    Path path = Path.of(CSV_DELIMITER);

    try {
      BufferedReader reader =
          Files.newBufferedReader(path, charset);

      String lineOfText;

      while ((lineOfText = reader.readLine()) != null) {
        System.out.println(lineOfText);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      // File does not exist.
      System.err.println("File was not found...");
    }

    catch (IOException e){
      System.err.println("A problem was encountered reading " + CSV_DELIMITER);
    }

  }

  /**
   * Exports the Army to a .csv file. The first line holds the
   * titles of the columns: Army Name, Unit Type, Unit Name and Unit Health
   *
   * @param army the address book to export
   * @param file        the file to export the Army to
   * @throws IOException if the file exists but is a directory rather than a regular file,
   *                     does not exist but cannot be created,
   *                     or cannot be opened for any other reason
   */
  public static void exportArmyToCSV(Army army, File file) throws IOException {

    // Here I'm using PrintWriter's methods because PrintWriter's
    // print and println methods can accept parameters of any type,
    // while the write method of BufferedWriter can only accept characters,
    // array of characters, and strings. And PrintWriter's println method
    // automatically adds line wrapping, BufferedWriter needs to display
    // the calling newline method. And the PrintWriter is more widely constructed.
    try {
      FileWriter filewriter = new FileWriter(file);
      PrintWriter writer = new PrintWriter(filewriter);

      writer.println("Army Name" + CSV_DELIMITER +
                     "Unit Type" + CSV_DELIMITER +
                     "Unit Name" + CSV_DELIMITER +
                     "Unit Health" + CSV_DELIMITER);

      for (Unit unit : army.getAllUnits()) {
        writer.print(unit.getName() + CSV_DELIMITER);
        writer.print(unit.getHealth() + CSV_DELIMITER);
      }

      writer.close();
    } catch (IOException e) {
      System.err.println("File could not be created...");
    }
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

  public static void main(String[] args) throws IOException {
    String path = System.getProperty("IntelliJ");
    File file = new File(path + "\\SkoleArbeid" + "\\Wargames"+ "\\Text.csv");
    file.createNewFile();
    file.mkdir();
  }

}