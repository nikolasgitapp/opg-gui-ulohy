package sk.spse.uloha2.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private ToggleGroup pohlavieGroup;

    @FXML
    private void userInput() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registrácia používateľa");
        alert.setHeaderText("Registrácia prebehla úspešne");

        String pohlavie = ((RadioButton) pohlavieGroup.getSelectedToggle()).getText();

        String message =
                "Užívateľ " + name.getText() +
                        " (" + pohlavie + ")" +
                        " s heslom " + password.getText() +
                        " bol pridaný do systému";

        alert.setContentText(message);

        alert.showAndWait();
    }
}