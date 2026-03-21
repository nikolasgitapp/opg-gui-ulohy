package sk.spse.uloha4.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sk.spse.uloha4.declarative.Application;

import java.util.Random;

public class ProceduralApplication extends Application {

    private VBox vbox1, vbox2, vbox3, vbox4;
    private static final Random rand = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // VBOX 1
        vbox1 = createVBox("-fx-background-color: blue;", 229);

        // VBOX 2
        vbox2 = createVBox("-fx-background-color: green;", 244);

        // VBOX 3
        vbox3 = createVBox("-fx-background-color: yellow;", 202);

        // VBOX 4
        vbox4 = createVBox("-fx-background-color: red;", 236);

        // Image (spoločný pre všetky)
        Image image = new Image(getClass().getResourceAsStream("soup2.png"));

        vbox1.getChildren().add(createImageView(image, 229));
        vbox2.getChildren().add(createImageView(image, 244));
        vbox3.getChildren().add(createImageView(image, 202));
        vbox4.getChildren().add(createImageView(image, 236));

        // TilePane
        TilePane tilePane = new TilePane(vbox1, vbox2, vbox3, vbox4);

        // Label
        Label label = new Label("\"In the future, everyone will be world-famous for 15 minutes\" - Andy Warhol");
        label.setFont(new Font(15));
        label.setWrapText(true);
        label.setPadding(new Insets(0, 0, 0, 20));

        // Buttons
        Button randomBtn = new Button("Randomize");
        randomBtn.setFont(new Font(15));
        randomBtn.setOnMousePressed(e -> randomize());

        Button closeBtn = new Button("Close");
        closeBtn.setFont(new Font(15));
        closeBtn.setOnMousePressed(e -> Platform.exit());

        // HBox
        HBox hBox = new HBox(label, randomBtn, closeBtn);
        HBox.setMargin(randomBtn, new Insets(30, 0, 0, 100));
        HBox.setMargin(closeBtn, new Insets(30, 0, 0, 10));

        // Layout (BorderPane)
        BorderPane root = new BorderPane();
        root.setCenter(tilePane);
        root.setBottom(hBox);

        Scene scene = new Scene(root, 813, 400);

        stage.setTitle("Procedural Application 4");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createVBox(String style, int imageHeight) {
        VBox vbox = new VBox();
        vbox.setPrefWidth(202);
        vbox.setPrefHeight(275);
        vbox.setStyle(style);
        return vbox;
    }

    private ImageView createImageView(Image image, int height) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(202);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        VBox.setMargin(imageView, new Insets(40, 0, 0, 0));
        return imageView;
    }

    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor());
        vbox2.setStyle("-fx-background-color: " + getRandomColor());
        vbox3.setStyle("-fx-background-color: " + getRandomColor());
        vbox4.setStyle("-fx-background-color: " + getRandomColor());
    }

    public static String getRandomColor() {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return String.format("#%02X%02X%02X", r, g, b);
    }
}