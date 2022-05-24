package Wargames.frontend.ui;


import Wargames.MainApp;
import Wargames.backend.filehandler.UnitFileHandler;
import Wargames.backend.model.Army;
import Wargames.backend.model.Battle;
import Wargames.backend.model.Unit;

import Wargames.backend.model.UnitFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


public class MainController {

  private static final String DATA_FILE_NAME = "unit.dat";

  @FXML
  private TableView<Army> armyTableView;

     @FXML
     private Button startButton;
     @FXML
     private Button clearButton;

  @FXML
  private TableView<Unit> armyOneTableView;
  @FXML
  private TableView<Unit> armyTwoTableView;
  @FXML
  private TableColumn<Unit, String> nameColumnArmyOne;
  @FXML
  private TableColumn<Unit, String> nameColumnArmyTwo;
  @FXML
  private TableColumn<Unit, String> healthColumnArmyOne;
  @FXML
  private TableColumn<Unit, String> healthColumnArmyTwo;
  @FXML
  private TextField winner;


  ObservableList<Army> observableContactsList;
  // The address book to be used to store the contact details in.
  private Unit unit;

     public Battle battle = new Battle();
     public Army armyOne;
     public Army armyTwo;

    public MainController(){
    battle = new Battle();

      }

      public Battle getBattle(){
      return this.battle;
      }


  /**
   * Would start the battle between the two armees.
   */
  @FXML
  public void simulateButtonPressed(ActionEvent event){
      battle = new Battle(armyOne,armyTwo);
      System.out.println("Start button was pressed");
      battle.simulate();
    }

  /**
   * Clear the information in the tableviews
   */
  @FXML
     public void clearButtonPressed(ActionEvent event){
      System.out.println("Clear button was pressed!");
      System.out.println(armyTwo.getName());
    }

  /**
   * Updates the ObservableArray wrapper with the current content in the
   * Literature register. Call this method whenever changes are made to the
   * underlying LiteratureRegister.
   *
   * @param army the army to use for updating the observable list
   */
  public void updateObservableList(Army army) {
    this.observableContactsList.setAll((Army) armyOne.getAllUnits());
  }

    @FXML
  public void exportToCsv(ActionEvent event){
      FileChooser fileChooser = new FileChooser();

      // Set extension filter for .csv-file
      FileChooser.ExtensionFilter extFilter =
          new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
      fileChooser.getExtensionFilters().add(extFilter);

      // Show save open dialog
      File file = fileChooser.showOpenDialog(null);
      if (file != null) {
        try {
          UnitFileHandler.exportToCsv(armyOne, file);
          this.updateObservableList(this.armyOne);
        } catch (IOException ioe) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("File Import Error");
          alert.setHeaderText("Error during CSV-import.");
          alert.setContentText("Details: " + ioe.getMessage());
          alert.showAndWait();
        }
      }
    }


  /**
   * Imports Csv files into the program.
   * @param event
   */
  @FXML
  public void importFromCsv(ActionEvent event){
      FileChooser fileChooser = new FileChooser();

      // Set extension filter for .csv-file
      FileChooser.ExtensionFilter extFilter =
          new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
      fileChooser.getExtensionFilters().add(extFilter);

      // Show save open dialog
      File file = fileChooser.showOpenDialog(null);
      if (file != null) {
        try {
          UnitFileHandler.importFromCsv(armyTwo, file);
          this.updateObservableList(this.armyTwo);
        } catch (IOException ioe) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("File Import Error");
          alert.setHeaderText("Error during CSV-import.");
          alert.setContentText("Details: " + ioe.getMessage());
          alert.showAndWait();
        }
      }
    }

  /**
   * Adds an army into the game.
   * @param event
   */
  @FXML
  private void addArmy(ActionEvent event){

    }

  /**
   *
   * @param event
   */
  @FXML
  private void showAboutDialog(ActionEvent event){

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Dialog - About");
    alert.setHeaderText("Contacts Register\nv" + MainApp.VERSION);
    alert.setContentText("An application created by\n"
        + "(C)Even Johan Pereira Haslerud\n"
        + "2022-05-23");

    alert.showAndWait();
    }

  /**
   *
   * @param event
   */
  @FXML
  private void showLoginDialog(ActionEvent event){

  }

  /**
   *
   * @param event
   */
  @FXML
  private void exitApplication(ActionEvent event){

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Exit Application ?");
    alert.setContentText("Are you sure you want to exit Wargames?");

    Optional<ButtonType> result = alert.showAndWait();

    if (result.isPresent() && (result.get() == ButtonType.OK)) {
      // ... user choose OK
      Platform.exit();
    }
  }

  /**
   *
   * @param army
   */
  public void saveArmyToFile(Army army){
    try{
      File outFile = new File(DATA_FILE_NAME);
      UnitFileHandler.saveToFile(army, outFile);
    } catch (IOException ioe) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("File save Error");
      alert.setHeaderText("Error while saving the army");
      alert.setContentText("Details:  " + ioe.getMessage());
      alert.showAndWait();
    }
}

  /**
   * Loads an entire army from file using object serialization.
   *
   * @return
   */
  public Army loadFromFile(){
    File inFile = new File(DATA_FILE_NAME);
    return UnitFileHandler.loadFromFile(inFile);
}

}

