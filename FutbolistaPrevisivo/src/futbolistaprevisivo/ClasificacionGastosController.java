
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


public class ClasificacionGastosController implements Initializable {
    
    @FXML 
    private Button btnImpuestos;
    
    @FXML
    private Button btnMultas;
    
    @FXML
    private Button btnLestiones;
    
    @FXML
    private Button btnFilantropia;
    
    @FXML
    private Button btnVolverMenuGastos;
    
    @FXML
    private Button btnVolverGastos;
    
    @FXML
    private void clicButtonImpuestos(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GastosImpuestos.fxml"));
        Parent root = loader.load();
    
        Scene PantallaGastosImpuestos = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(PantallaGastosImpuestos);
         stage.show();
        
        }
    
     @FXML
     private void clicButtonMultas(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GastosMultas.fxml"));
        Parent root = loader.load();
    
        Scene PantallaGastosMultas = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(PantallaGastosMultas);
         stage.show();
        
        }
     
     @FXML
     private void clicButtonLesiones(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GastosLesiones.fxml"));
        Parent root = loader.load();
    
        Scene PantallaGastosLesiones = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(PantallaGastosLesiones);
         stage.show();
        
        }
     
       @FXML
     private void clicButtonFilantropia(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GastosFilantropia.fxml"));
        Parent root = loader.load();
    
        Scene PantallaGastosFilantropia = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(PantallaGastosFilantropia);
         stage.show();
        
        }
     
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
        
    }    
    
}
