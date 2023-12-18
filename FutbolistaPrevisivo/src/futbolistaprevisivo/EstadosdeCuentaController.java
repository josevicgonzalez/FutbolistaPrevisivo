
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

public class EstadosdeCuentaController implements Initializable {
    
    @FXML 
    private Button btnRegresar;
    
    @FXML
    private Button btnEsIngresos;
    
    @FXML
    private Button btnEsEgesos;
    
    @FXML
    private Button btnTotales;
    
    
       @FXML
        private void clicButtonReg(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicio.fxml"));
        Parent root = loader.load();
    
        Scene pantallaMenuInicio = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(pantallaMenuInicio);
         stage.show();
        
        }
        
        @FXML
         private void clicButtonRepIng(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReporteIngresos.fxml"));
        Parent root = loader.load();
    
        Scene pantallaReporteIngresos = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(pantallaReporteIngresos);
         stage.show();
        
        }
         
         @FXML
         private void clicButtonRepEg(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReporteEgresos.fxml"));
        Parent root = loader.load();
    
        Scene pantallaReporteEgresos = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(pantallaReporteEgresos);
         stage.show();
        
        }
         
         @FXML
         private void clicButtonTotales(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Totales.fxml"));
        Parent root = loader.load();
    
        Scene pantallaTotales = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(pantallaTotales);
         stage.show();
        
        }
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
