package sk.spse.uloha1.procedural;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {
    private TextField cfield;
    private TextField ffield;
    @Override
    public void start(Stage primaryStage) {

        Label lblC = new Label("Stupne Celsia:");
        cfield = new TextField("0");
        Label lblCUnit = new Label("°C:");

        HBox rowC = new HBox( 5, lblC, cfield, lblCUnit);
        rowC.setAlignment(Pos.CENTER_RIGHT);
        rowC.setPadding(new Insets(10));

        Label lblF = new Label("Stupne Farenheita:");
        ffield = new TextField("0");
        Label lblFUnit = new Label("°F:");

        HBox rowF = new HBox( 5, lblF, ffield, lblFUnit);
        rowF.setAlignment(Pos.CENTER_RIGHT);
        rowF.setPadding(new Insets(10));

        //Hlavný kontajner
        VBox root = new VBox( 0, rowC, rowF);

        Scene scene = new Scene(root, 420, 120);

        cfield.setOnKeyTyped(  e -> convertc());
        ffield.setOnKeyTyped(  e -> convertt());

        primaryStage.setTitle("Procedural Application 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void convertc() {
        try{
            double c = Double.parseDouble(cfield.getText());
            double f = (1.8 * c) + 32;
            ffield.setText(Double.toString(f)); }
        catch (NumberFormatException e) {

        }
    }
    @FXML
    public void convertt() {
        try {
            double f = Double.parseDouble(ffield.getText());
            double c = (f - 32) / 1.8;
            cfield.setText(Double.toString(c)); }
        catch (NumberFormatException e) {

        }
    }
}