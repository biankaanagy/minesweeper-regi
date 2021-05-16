package minesweeper.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.io.IOException;

import org.tinylog.Logger;

public class OpeningController {

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private TextField playerNameTextField;

    @FXML
    private Label errorLabel;

    @FXML
    public void startAction(ActionEvent actionEvent) throws IOException {
        if (playerNameTextField.getText().isEmpty()) {
            errorLabel.setText("Please enter your name!");
        } else {
            //fxmlLoader.setLocation(getClass().getResource("/fxml/game.fxml"));
            //Parent root = fxmlLoader.load();
            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/game.fxml"));
            fxmlLoader.<GameController>getController().setPlayerName(playerNameTextField.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
            //Logger.info("The user's name is set to {}, loading game scene", playerNameTextField.getText()); // TODO
            /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/opening.fxml"));
            stage.setTitle("Minesweeper");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();*/
        }
    }

}

