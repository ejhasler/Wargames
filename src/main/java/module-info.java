module Wargames {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires jakarta.persistence;
    requires org.apache.derby.engine;
    requires org.apache.derby.commons;
    //opens no.ntnu.idata2001.contacts.views to javafx.graphics;
    //opens no.ntnu.idata2001.contacts.model to java.persistence;
    exports Wargames;
}
