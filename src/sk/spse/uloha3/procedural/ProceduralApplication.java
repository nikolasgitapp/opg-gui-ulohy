package sk.spse.uloha3.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProceduralApplication extends javafx.application.Application {

    @Override
    public void start(Stage stage) {

        // obrázok
        ImageView obrazok = new ImageView(new Image(getClass().getResourceAsStream("spse.png")));
        obrazok.setFitWidth(200);
        obrazok.setFitHeight(150);
        obrazok.setPreserveRatio(true);

        BorderPane.setMargin(obrazok, new Insets(10));

        // horný text
        Label title = new Label("Stredná priemyselná škola elektrotechnická, Prešov");
        title.setFont(new Font("Arial", 24));
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(10));

        // text v strede
        TextArea text = new TextArea(
                "Vážení rodičia a milí žiaci základných škôl,\n\n"
                        + "radi by sme Vás privítali v priestoroch našej školy dňa "
                        + "10.2.2026 (utorok) od 13:00 do 17:00 h na Dni otvorených dverí, "
                        + "kde by sme Vám chceli predstaviť naše študijné odbory"
        );
        text.setEditable(false);
        text.setWrapText(true);
        text.setFont(new Font(20));

        Hyperlink link = new Hyperlink("https://spse-po.sk/");
        link.setFont(new Font(16));

        VBox centerBox = new VBox(10, text, link);
        centerBox.setPadding(new Insets(10));

        // slider
        Slider slider = new Slider();

        slider.setOnMouseDragged(e -> {
            obrazok.setRotate(slider.getValue());
        });

        // tlačidlo
        Button button = new Button("Beriem na vedomie");
        button.setFont(new Font("Arial", 15));

        button.setOnMouseClicked(e -> Platform.exit());

        HBox bottomBox = new HBox(10, slider, button);
        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        bottomBox.setPadding(new Insets(25));

        // layout
        BorderPane root = new BorderPane();
        root.setTop(title);
        root.setLeft(obrazok);
        root.setCenter(centerBox);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 700, 350);

        stage.setTitle("Procedural Application 3");
        stage.setScene(scene);
        stage.show();
    }
}