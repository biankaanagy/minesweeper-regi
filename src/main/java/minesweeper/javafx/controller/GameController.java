package minesweeper.javafx.controller;

import com.google.inject.Inject;
import javafx.animation.Animation;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.time.Instant;

import org.tinylog.Logger;
import util.javafx.ControllerHelper;
import util.javafx.Stopwatch;

public class GameController {

    @FXML
    private Label messageLabel;

    @FXML
    private GridPane gameBoard;

    @FXML
    private Label stepsLabel;

    @FXML
    private  Label stopwatchLabel;

    @FXML
    private Button resetButton;

    @FXML
    private Button giveUpFinishButton;

    @Inject
    private FXMLLoader fxmlLoader;

    private Stopwatch stopwatch = new Stopwatch();

    private String playerName;

    private IntegerProperty steps = new SimpleIntegerProperty();

    private Instant startTime;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    @FXML
    private void initialize() {
        for (int i = 0; i < gameBoard.getRowCount(); i++) {
            for (int j = 0; j < gameBoard.getColumnCount(); j++) {
                var square = createSquare(i, j);
                gameBoard.add(square, j, i);
            }
        }
    }

    private StackPane createSquare(int i, int j) {
        var square = new StackPane();
        square.getStyleClass().add("square");

        square.getChildren();
        square.setOnMouseClicked(this::handleMouseClick);
        return square;

    }

    private void handleMouseClick(javafx.scene.input.MouseEvent mouseEvent) {
    }

    /*
    private void resetGame() {
        gameState = new MinesweeperState();
        bindGameStateToUI();
        steps.set(0);
        startTime = Instant.now();
        if (stopwatch.getStatus() == Animation.Status.PAUSED) {
            stopwatch.reset();
        }
        stopwatch.start();
    }

    private void bindGameStateToUI() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                var imageView = (ImageView) gameBoard.getChildren().get(i * 3 + j);
                var p = gameState.cubeProperty(i, j);
                imageView.imageProperty().bind(
                        new ObjectBinding<Image>() {
                            {
                                super.bind(p);
                            }
                            @Override
                            protected Image computeValue() {
                                return cubeImages.get(p.get().getValue());
                            }
                        }
                );
            }
        }
        gameState.solvedProperty().addListener(this::handleSolved);
    }

*/
    @FXML
    private void handleMouseClick(MouseEvent event) {
        var square = (StackPane) event.getSource();
        var row = GridPane.getRowIndex(square);
        var col = GridPane.getColumnIndex(square);
        System.out.printf("Click on square (%d,%d)\n", row, col);
        //model.move(row, col);
    }
/*
    public void handleResetButton(ActionEvent actionEvent)  {
        Logger.debug("{} is pressed", ((Button) actionEvent.getSource()).getText());
        Logger.info("Resetting game");
        stopwatch.stop();
        resetGame();
    }*/

}
