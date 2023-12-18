
package futbolistaprevisivo;

import futbolistaprevisivo.core.Egress;
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

public class ReporteEgresosController implements Initializable {
    
    @FXML
    private Button btnRegresar;
    
    @FXML
    private TextArea reporteEgresos;
    
    @FXML
    private Button btnImprimir;
    
    @FXML
    private void clicButtonImprimir (ActionEvent event) throws IOException{
        imprimirEstadoDeCuenta();
    
    }
    
    
    @FXML
    private void clicButtonRegresar (ActionEvent event) throws IOException{
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EstadosdeCuenta.fxml"));
        Parent root = loader.load();

        Scene pantallaEsCuenta = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaEsCuenta);
        stage.show();
    
    
    }
    
    
    
    private void imprimirEstadoDeCuenta() {
     
        ArrayList<Egress> listaEgress = TransactionManager.getEgresses();
        
        reporteEgresos.clear();
        
        for (Egress egress: listaEgress) {
            reporteEgresos.appendText(egress.toString() + "\n");
           
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
    
    
    
    
    
}
