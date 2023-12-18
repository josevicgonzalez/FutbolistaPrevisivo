
package futbolistaprevisivo;

import futbolistaprevisivo.core.Ingress;
import futbolistaprevisivo.core.TransactionManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class ReporteIngresosController implements Initializable {
    
    @FXML
    private Button btnRegresar;
    
    @FXML
    private TextArea reporteIngresos;
    
    @FXML
    private Button btnImprimir;
     
    @FXML
    private void clicButtonRegresar (ActionEvent event) throws IOException{
    
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EstadosdeCuenta.fxml"));
    Parent root = loader.load();

    Scene pantallaEsCuenta = new Scene(root);

    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

    stage.setScene(pantallaEsCuenta);
    stage.show();
    
    
    }
    
    

    
    @FXML
    private void clicButtonImprimir (ActionEvent event) throws IOException{
        imprimirEstadoDeCuenta();
    
    }
    
    
    private void imprimirEstadoDeCuenta() {
        // Obtén la lista de Ingresses desde TransactionManager
        ArrayList<Ingress> listaIngress = TransactionManager.getIngresses();

        // Limpia el contenido actual del TextArea
        reporteIngresos.clear();

        // Itera sobre la lista e imprime cada elemento en el TextArea
        for (Ingress ingress : listaIngress) {
            reporteIngresos.appendText(ingress.toString() + "\n");
            // Supongo que tu clase Ingress tiene un método toString() personalizado
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
            
   
    
}
