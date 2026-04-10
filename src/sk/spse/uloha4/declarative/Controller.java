package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Locale;
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
public ImageView img1;
public ImageView img2;
public ImageView img3;
public ImageView img4;

   public static String getRandomColor()
    {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return String.format("#%02X%02X%02X", r, g, b);
    }

    public static String getRandomOpaque () {
        double x = rand.nextDouble();
        String s = String.format(Locale. ROOT, "%.2f", x); //System.out.println(s);
        return s;}

    public static String getRandomScale () {
       double x = rand.nextDouble() * 2.0;
       String s = String.format(Locale. ROOT, "%.2f", x); //System.out.println(s);
        return s;}

    public static String getRandomRotate () {
        double x = rand.nextDouble() * 360.0;
        String s = String.format(Locale. ROOT, "%.2f", x); //System.out.println(s);
        return s;}

@FXML
private void randomize() {
    vbox1.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpaque());
    vbox2.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: " + getRandomOpaque());
    vbox3.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity:" + getRandomOpaque());
    vbox4.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity: "+ getRandomOpaque());

    img4.setStyle(" -fx-rotate: " + getRandomRotate());
    img2.setStyle("-fx-scale-x: " + getRandomScale());
    img3.setStyle(" -fx-scale-y: " + getRandomScale());
    img1.setStyle(" -fx-scale-x: " + getRandomScale() + "; -fx-scale-y: "+ getRandomScale() + "; -fx-rotate: " + getRandomRotate());
}
    @FXML
    private void close() { Platform.exit(); }
}
