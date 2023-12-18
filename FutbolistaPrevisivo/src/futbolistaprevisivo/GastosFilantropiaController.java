
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

public class GastosFilantropiaController implements Initializable {

    @FXML
    private Button btnVolverE;
    
    @FXML
    private DatePicker fechaFilantropia;
    
    @FXML
    private TextField descripcionFilantropia;
    
    @FXML
    private TextField saldoActual;
    
    @FXML
    private TextField porcentajeFilantropia;
    
    @FXML
    private TextField totalADonar;
    
    @FXML
    private TextField nuevoSaldo;
    
    @FXML
    private Button btnGuardarFilantropia;
    
    @FXML
    private Button btnCalcularFilantropia;
    
   
        @FXML
        private void clicButtonGuardarF(ActionEvent event){
  
        LocalDate fechaTrans = fechaFilantropia.getValue();
        Date fecha = Date.from(fechaTrans.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String descripcion = descripcionFilantropia.getText();
        
        double saldo_Anterior = TransactionManager.getSaldo();
        
        saldoActual.setText(String.valueOf(saldo_Anterior));
        
        Double porcentaje_Filantropia = Double.parseDouble(porcentajeFilantropia.getText());
        Double total_Filantropia = (saldo_Anterior * (porcentaje_Filantropia / 100));
        Double nuevo_Saldo = saldo_Anterior - total_Filantropia;
        
        nuevoSaldo.setText(String.valueOf(nuevo_Saldo));
        
        
        
        Egress newEgress = new Egress();
        newEgress.setFecha(fecha);
        newEgress.setDescripcion(descripcion);
        newEgress.setPorcentaje(porcentaje_Filantropia);
        newEgress.setSubtotal(nuevo_Saldo);
        TransactionManager.addEgress(newEgress);
      
            
        }   
        
        @FXML
        private void clicButtonCalcularF(ActionEvent event){
  
  
        Double porcentaje_Filantropia = Double.parseDouble(porcentajeFilantropia.getText());
        double saldo_Anterior = TransactionManager.getSaldo();
        
        saldoActual.setText(String.valueOf(saldo_Anterior));
        
        
        Double total_Filantropia = (saldo_Anterior * (porcentaje_Filantropia / 100));
        Double nuevo_Saldo = saldo_Anterior - total_Filantropia;
        totalADonar.setText(String.valueOf(saldo_Anterior));
            
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
        // TODO
    }    
    
}
