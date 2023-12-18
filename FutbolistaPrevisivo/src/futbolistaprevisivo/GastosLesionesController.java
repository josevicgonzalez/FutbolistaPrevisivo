
package futbolistaprevisivo;

import futbolistaprevisivo.core.Egress;
import futbolistaprevisivo.core.TransactionManager;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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


public class GastosLesionesController implements Initializable {
    
    @FXML   
    private Button btnVolverEg;
    
    @FXML
    private DatePicker fechaLesion;
    
    @FXML
    private TextField descripcionLesion;
    
    @FXML
    private TextField saldoAcumulado;
    
    @FXML
    private TextField porcentajeLesion;
    
    @FXML
    private TextField totalLesion;
    
    @FXML
    private TextField saldoActual;
    
    @FXML
    private Button btnCalcularLesion;
    
    @FXML
    private Button btnGuardarLesion;
    
     @FXML
    private void clicButtonGuardarLesion(ActionEvent event) {
        
        LocalDate fechaTrans = fechaLesion.getValue();
        Date fecha = Date.from(fechaTrans.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String descripcion = descripcionLesion.getText();
        
        double saldo_Anterior = TransactionManager.getSaldo();
        
        saldoAcumulado.setText(String.valueOf(saldo_Anterior));
        
        Double porcentaje_Lesion = Double.parseDouble(porcentajeLesion.getText());
        Double total_Lesion= (saldo_Anterior * (porcentaje_Lesion / 100));
        
        Double nuevoSaldo = saldo_Anterior - total_Lesion;
        
        
        Egress newEgress = new Egress();
        newEgress.setFecha(fecha);
        newEgress.setDescripcion(descripcion);
        newEgress.setPorcentaje(porcentaje_Lesion);
        newEgress.setSubtotal(nuevoSaldo);
        TransactionManager.addEgress(newEgress);
      
        saldoActual.setText(String.valueOf(nuevoSaldo));
        
   
    
    }
    
      @FXML
    private void clicButtonCalcLesion(ActionEvent event) {
        
        double saldo_Anterior = TransactionManager.getSaldo();
        
        saldoAcumulado.setText(String.valueOf(saldo_Anterior));
        
        Double porcentaje_Lesion = Double.parseDouble(porcentajeLesion.getText());
        double total_Lesion= (saldo_Anterior * (porcentaje_Lesion / 100));
        
        totalLesion.setText(String.valueOf(total_Lesion));
    
    
    }
    
  
    
    
        @FXML
        private void clicButtonVolver(ActionEvent event) throws IOException {
            
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ClasificacionGastos.fxml"));
        Parent root = loader.load();

        Scene pantallaClasificaGastos = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaClasificaGastos);
        stage.show();
        
        }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
