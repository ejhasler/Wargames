module Wargames {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.graphics;
  requires java.logging;

  opens Wargames.frontend.ui to javafx.fxml;
  opens Wargames.backend.model to javafx.graphics, javafx.fxml, java.base;

  exports Wargames;
}
