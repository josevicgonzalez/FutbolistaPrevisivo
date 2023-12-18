
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
import futbolistaprevisivo.TransaccionAhorros;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId; 
import futbolistaprevisivo.Transaccion;
import futbolistaprevisivo.core.Ingress;
import futbolistaprevisivo.core.TransactionManager;
import javafx.application.Platform;
import javafx.scene.control.Label;


public class IngresosAhorrosInversionesController implements Initializable {
    
    @FXML
    private Button btnVolverMenuIng;
    
    @FXML
    private DatePicker fechaIngreso;
    
    @FXML 
    private TextField descripIngreso;
    
    @FXML 
    private TextField saldo_Actual;
    
    @FXML
    private TextField porAhorro;
    
    @FXML
    private TextField montoAhorroT;
    
    @FXML
    private Button btnGuardarAh;
    
    @FXML
    private Label nuevoSaldo;
    
     @FXML
        private void clicButtonGuarAh(ActionEvent event){
            LocalDate fechaAhorro = fechaIngreso.getValue();
            Date fecha = Date.from(fechaAhorro.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            Double porcentajeAhorro = Double.parseDouble(porAhorro.getText());
            
            double saldoActual = TransactionManager.getSaldo();
            
            String descripcion = descripIngreso.getText();
            double ingresosGanados = (saldoActual * (porcentajeAhorro / 100)) + saldoActual;
            double saldoActualizado = ingresosGanados;
            
            saldo_Actual.setText(String.valueOf(TransactionManager.getSaldo()));
            
            montoAhorroT.setText(String.valueOf(ingresosGanados));
            
            Ingress newIngress = new Ingress();
            newIngress.setFecha(fecha);
            newIngress.setDescripcion(descripcion);
            newIngress.setSubtotal(saldoActualizado); 
            TransactionManager.addIngress(newIngress);
            
            
            
        } 
    
    @FXML
        private void clicButtonVolverM(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClasificacionIngresos.fxml"));
        Parent root = loader.load();

        Scene pantallaIngreso = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaIngreso);
        stage.show();
        }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
