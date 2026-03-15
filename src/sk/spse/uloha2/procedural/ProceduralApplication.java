package sk.spse.uloha2.procedural;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ProceduralApplication extends Application {

    @Override
    public void start(Stage stage) {

        Label nameLabel = new Label("Užívateľské meno:");
        TextField nameField = new TextField("zadaj meno");

        Label passwordLabel = new Label("Heslo:");
        PasswordField passwordField = new PasswordField();

        Label genderLabel = new Label("Pohlavie:");

        ToggleGroup genderGroup = new ToggleGroup();

        RadioButton male = new RadioButton("MUŽ");
        male.setToggleGroup(genderGroup);

        RadioButton female = new RadioButton("ŽENA");
        female.setToggleGroup(genderGroup);

        HBox genderBox = new HBox(20, male, female);

        Button registerButton = new Button("Registrovať");
        Button closeButton = new Button("Zavrieť");

        registerButton.setOnAction(e -> {

            RadioButton selected = (RadioButton) genderGroup.getSelectedToggle();
            String gender = selected != null ? selected.getText() : "nezadané";

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registrácia používateľa");
            alert.setHeaderText("Registrácia prebehla úspešne");

            String message = "Užívateľ " + nameField.getText()
                    + " (" + gender + ") s heslom "
                    + passwordField.getText()
                    + " bol pridaný do systému";

            alert.setContentText(message);
            alert.showAndWait();
        });

        closeButton.setOnAction(e -> stage.close());

        HBox buttons = new HBox(20, registerButton, closeButton);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(20);
        root.setVgap(20);

        root.add(nameLabel, 0, 0);
        root.add(nameField, 1, 0);

        root.add(passwordLabel, 0, 1);
        root.add(passwordField, 1, 1);

        root.add(genderLabel, 0, 2);
        root.add(genderBox, 1, 2);

        root.add(buttons, 1, 3);

        Scene scene = new Scene(root, 420, 250);

        stage.setTitle("Procedural Application 2");
        stage.setScene(scene);
        stage.show();
    }
}