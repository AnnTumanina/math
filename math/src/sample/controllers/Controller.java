package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Controller {
    @FXML
    public Button result_itr;
    @FXML
    public Button result_dht;
    @FXML
    public Button help;
    /**
     *
     * @param event Метод для перехода на форму справки
     * @throws IOException
     */
    public void getHelp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample\\resources\\fxml\\help.fxml")));
        root.setId("pane");
        Stage stage = new Stage();
        stage.setTitle("Справка");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(this.getClass().getClassLoader().getResource("sample\\resources\\style\\style.css")));
        stage.setScene(scene);
        stage.show();
    }

    public void getDhtm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample\\resources\\fxml\\dht.fxml")));
        root.setId("pane");
        Stage stage = new Stage();
        stage.setTitle("Решение методом дихотомии");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getItr(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample\\resources\\fxml\\simpleItr.fxml")));
        root.setId("pane");
        Stage stage = new Stage();
        stage.setTitle("Решение методом итерации");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
