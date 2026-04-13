package sk.spse.uloha5.declarative;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller implements Initializable {

    @FXML
    private TableView<Jedlo> tabulka;

    @FXML
    private TableColumn<Jedlo, Integer> id;

    @FXML
    private TableColumn<Jedlo, String> nazovJedal;

    @FXML
    private TableColumn<Jedlo, Integer> kalorie;

    @FXML
    private TableColumn<Jedlo, Double> cena;

    private List<Jedlo> jedloList = new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // naplnenie zoznamu testovacími dátami
        jedloList.add(new Jedlo(1, "Pizza", 900, 7.5));
        jedloList.add(new Jedlo(2, "Burger", 750, 6.0));
        jedloList.add(new Jedlo(3, "Šalát", 250, 4.5));
        jedloList.add(new Jedlo(4, "Polievka", 180, 3.0));


        // nastavenie stĺpcov tabuľky
        id.setCellValueFactory(p ->
                new SimpleIntegerProperty(p.getValue().id()).asObject());

        nazovJedal.setCellValueFactory(p ->
                new SimpleStringProperty(p.getValue().nazov()));

        kalorie.setCellValueFactory(p ->
                new SimpleIntegerProperty(p.getValue().kalorie()).asObject());

        cena.setCellValueFactory(p ->
                new SimpleDoubleProperty(p.getValue().cena()).asObject());


        // vloženie dát do tabuľky
        tabulka.getItems().setAll(jedloList);


        // automatická šírka posledného stĺpca
        tabulka.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );
    }


    @FXML
    public void delete() {

        Jedlo selected = tabulka.getSelectionModel().getSelectedItem();

        if (selected != null) {
            jedloList.remove(selected);
            tabulka.getItems().remove(selected);
        }
    }


    @FXML
    public void close() {
        Platform.exit();
    }
}