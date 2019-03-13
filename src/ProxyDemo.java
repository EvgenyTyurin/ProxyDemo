import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Proxy pattern demo
 * Mar 2019 Evgeny Tyurin
 *
 * We have 3rd party image loader but we want cache images and create proxy class
 */

public class ProxyDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ProxyDemo.fxml"));
        primaryStage.setTitle("Image loader");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
