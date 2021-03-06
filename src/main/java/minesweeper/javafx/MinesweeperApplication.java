package minesweeper.javafx;

import java.util.List;

import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;

import javax.inject.Inject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.tinylog.Logger;

/*
* import minesweeper.results.GameResultDao;
* import util.guice.PersistenceModule;
*/

public class MinesweeperApplication extends Application {
    /*private GuiceContext context = new GuiceContext(this, () -> List.of(
            new AbstractModule() {
                @Override
                protected void configure() {
                    install(new PersistenceModule("rolling-cubes"));
                    bind(GameResultDao.class);
                }
            }
    ));
*/

    @Inject
    private FXMLLoader fxmlLoader;


    @Override
    public void start(Stage stage) throws Exception {
        //Logger.info("Starting application");
        //context.init();
        //fxmlLoader.setLocation(getClass().getResource("/fxml/opening.fxml"));
        //Parent root = fxmlLoader.load();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/opening.fxml"));
        stage.setTitle("Minesweeper");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
