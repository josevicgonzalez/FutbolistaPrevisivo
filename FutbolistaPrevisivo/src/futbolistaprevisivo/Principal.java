package futbolistaprevisivo;

import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Principal extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MenuInicio.fxml"));
        Scene menu = new Scene(root);

        stage.setScene(menu);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



