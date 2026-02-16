package sk.spse.uloha1.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    private int counter = 0;

    @FXML
    private TextField counterField;
    @FXML
    private TextField cfield;
    @FXML
    private TextField ffield;

    @FXML
    private void incrementCounter() {
        counter++;
        counterField.setText(String.valueOf(counter));
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
