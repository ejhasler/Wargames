package Wargames;


import static javafx.application.Application.launch;

import java.io.IOException;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * The main starting point for the application.
 */
public class MainApp extends Application {

  public static final String VERSION = "1.0-SNAPSHOT";

  @Override
  public void start(Stage primaryStage) throws Exception{

    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("main.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      primaryStage.setScene(scene);
      primaryStage.setOnCloseRequest(event -> {
        exit();
        event.consume();
      });
      primaryStage.show();
      primaryStage.setTitle("Wargames av Even Johan");
      primaryStage.sizeToScene();




    } catch (IOException e){
      System.out.println("ERROR: " + e.getMessage());
    }
  }



  public static void exit(){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Exit confirmation");
    alert.setHeaderText("Are u sure?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK){
      System.exit(1);
    }
  }

}

