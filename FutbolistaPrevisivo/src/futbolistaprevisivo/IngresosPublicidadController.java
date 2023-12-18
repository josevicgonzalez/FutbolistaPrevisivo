
package futbolistaprevisivo;

import futbolistaprevisivo.core.Ingress;
import futbolistaprevisivo.core.TransactionManager;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class IngresosPublicidadController implements Initializable {

    @FXML
    private Button btnVolverMenuIng;
    
    @FXML
    private DatePicker fechaIngresoPubli;
    
    @FXML
    private TextField numAniosPubli;
    
    @FXML
    private TextField valorPorAnio;
    
    @FXML
    private TextField descripPublicidad;
    
    @FXML
    private TextField gananciaPublicidad;
    
    @FXML
    private TextField nuevoSaldoconPubli;
    
    @FXML
    private Button calcGananciaPubli;
    
    @FXML
    private Button guardarPubli;
    
    
    
        @FXML
        private void clicButtonVolverIng(ActionEvent event) throws IOException {
   
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ClasificacionIngresos.fxml"));
        Parent root = loader.load();

        Scene pantallaIngreso = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaIngreso);
        stage.show();
        
        }
        
        @FXML
        private void clicButtonGuardarPubli(ActionEvent event) {
            LocalDate fechaTrans = fechaIngresoPubli.getValue();
            Date fecha = Date.from(fechaTrans.atStartOfDay(ZoneId.systemDefault()).toInstant());
            String descripcion = descripPublicidad.getText();
            int numero_anios = Integer.parseInt(numAniosPubli.getText());
            Double valor_Anio = Double.parseDouble(valorPorAnio.getText());
            Double ganancia_de_Publi = numero_anios * valor_Anio;
            System.out.println("Ganancia de publicidad" + ganancia_de_Publi);
            
            double saldoAnterior = TransactionManager.getSaldo();
            
            double nuevoSaldo = ganancia_de_Publi + saldoAnterior;
            
             
            Ingress newIngress = new Ingress();
            newIngress.setFecha(fecha);
            newIngress.setDescripcion(descripcion);
            newIngress.setCantidadAnios(numero_anios);
            newIngress.setValorPorAnio(valor_Anio);
           
            newIngress.setSubtotal(nuevoSaldo);
            TransactionManager.addIngress(newIngress);
      
            nuevoSaldoconPubli.setText(String.valueOf(nuevoSaldo));
        
         
       
        }

        @FXML
        private void calcGananciaPubli(ActionEvent event) throws IOException {
      
            int numero_anios = Integer.parseInt(numAniosPubli.getText());
            Double valor_Anio = Double.parseDouble(valorPorAnio.getText());
            Double ganancia_de_Publi = numero_anios * valor_Anio;
           
            
            gananciaPublicidad.setText(String.valueOf(ganancia_de_Publi));
             
      }
         
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
