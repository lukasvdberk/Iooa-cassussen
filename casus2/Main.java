package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();

        primaryStage.setTitle("Kippen spel");
        Scene scene = new Scene(root, 300, 300);

        Pane pane = new Pane();

        Ren ren = new Ren(600, 400, 400, 80);
        // Start positie van de kip
        Kip kip = new Kip(800, 400, ren, pane);

        Label aantalEieren = new Label(String.format("Aantal eieren: %s", Kip.AANTAL_EIEREN));
        // Wanneer een ei toegevoegd word dan updaten we de de teller van het aantal gelegde eieren
        kip.addEiToegevoegdEvent((ei)-> {
            aantalEieren.setText(String.format("Aantal eieren: %s", Kip.AANTAL_EIEREN));
        });

        pane.getChildren().add(aantalEieren);
        pane.getChildren().add(ren);
        pane.getChildren().add(kip);

        root.setCenter(pane);
        root.setStyle("-fx-background-color: green;");

        scene.setOnKeyPressed(kip::beweegKip);
        scene.setOnKeyReleased(kip::legEi);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
