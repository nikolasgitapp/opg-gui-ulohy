package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Random;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

static Random rand = new Random();

public VBox vbox1;
public VBox vbox2;
public VBox vbox3;
public VBox vbox4;

   public static String getRandomColor()
    {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return String.format("#%02X%02X%02X", r, g, b);
    }

@FXML
private void randomize() {
    vbox1.setStyle("-fx-background-color: " + getRandomColor());
    vbox2.setStyle("-fx-background-color: " + getRandomColor());
    vbox3.setStyle("-fx-background-color: " + getRandomColor());
    vbox4.setStyle("-fx-background-color: " + getRandomColor());
}
    @FXML
    private void close() {
        Platform.exit();}
}
