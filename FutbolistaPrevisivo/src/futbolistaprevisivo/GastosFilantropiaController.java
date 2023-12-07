
package futbolistaprevisivo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GastosFilantropiaController implements Initializable {

    @FXML
    private Button btnVolverE;
    
   
        @FXML
        private void clicButtonVolver(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicio.fxml"));
        Parent root = loader.load();
    
        Scene pantallaMenuInicio = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(pantallaMenuInicio);
         stage.show();
        
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
