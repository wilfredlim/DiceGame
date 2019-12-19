import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//you know what this does mr george(clooney) ;)
public class PigGame extends Application {
    public void start(Stage stage) {
        Scene scene = new Scene(new PigGamePane(), 800, 550);

        stage.setTitle("Pig Dice Game");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[]args) {
        launch(args);
    }
}
