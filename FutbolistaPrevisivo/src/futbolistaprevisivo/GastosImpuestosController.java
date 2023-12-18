
package futbolistaprevisivo;

import futbolistaprevisivo.core.Egress;
import futbolistaprevisivo.core.TransactionManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GastosImpuestosController implements Initializable {

    @FXML
    private DatePicker fechaImpuesto; 
    
    
    @FXML
    private TextField descripcionImpuesto;
    
    @FXML
    private TextField saldoActual;
    
    @FXML
    private TextField porcentajeImpuesto;
    
    @FXML
    private TextField totalsinImpuesto;
    
    
    @FXML
    private TextField totalPagarImpuesto;
    
    @FXML
    private TextField totalADonar;
    
    @FXML 
    private TextField nuevoSaldo;
    
    @FXML
    private Button btnCalcularImpuesto;
    
    @FXML
    private Button btnGuardarImpuesto;
 
    
        @FXML
        private void clicButtonGuardarImpuesto(ActionEvent event){
  
        LocalDate fechaTrans = fechaImpuesto.getValue();
        Date fecha = Date.from(fechaTrans.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String descripcion = descripcionImpuesto.getText();
        
        double saldo_Anterior = TransactionManager.getSaldo();
        
        saldoActual.setText(String.valueOf(saldo_Anterior));
        
        Double porcentaje_Impuesto = Double.parseDouble(porcentajeImpuesto.getText());
        Double total_Impuesto= (saldo_Anterior * (porcentaje_Impuesto / 100));
        Double nuevo_Saldo = saldo_Anterior - total_Impuesto;
        
        
        
        totalsinImpuesto.setText(String.valueOf(nuevo_Saldo));
        
        
        
        Egress newEgress = new Egress();
        newEgress.setFecha(fecha);
        newEgress.setDescripcion(descripcion);
        newEgress.setPorcentaje(porcentaje_Impuesto);
        newEgress.setSubtotal(nuevo_Saldo);
        TransactionManager.addEgress(newEgress);
      
            
        }   
        
          @FXML
        private void clicButtonCalcularImpuesto(ActionEvent event){
  
        double saldo_Anterior = TransactionManager.getSaldo();
        
        saldoActual.setText(String.valueOf(saldo_Anterior));
        
        Double porcentaje_Impuesto = Double.parseDouble(porcentajeImpuesto.getText());
        Double total_Impuesto = (saldo_Anterior * (porcentaje_Impuesto / 100));
        Double nuevo_Saldo = saldo_Anterior - total_Impuesto;
        totalPagarImpuesto.setText(String.valueOf(total_Impuesto));
            
        }   
        
       
        
        @FXML
        private void clicButtonVolverEg(ActionEvent event) throws IOException {
            
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ClasificacionGastos.fxml"));
        Parent root = loader.load();

        Scene pantallaClasificaGastos = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaClasificaGastos);
        stage.show();
        
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
           
        
    }    
    
}
