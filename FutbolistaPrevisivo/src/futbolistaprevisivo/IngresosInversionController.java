
package futbolistaprevisivo;

import futbolistaprevisivo.core.Ingress;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class IngresosInversionController implements Initializable {

        @FXML 
        private DatePicker fechaIngresoIn;
        
       
        @FXML
        private TextField porcentajeAInvertir;
        
        @FXML 
        private TextField descripcionBoni;
        
        @FXML
        private TextField montoInvertir;
        
        @FXML
        private TextField saldoconInversion;
        
        @FXML
        private Button btnCancelarin;
        
        @FXML
        private Button buttonGuardarIn;
        
        @FXML
        private Button calcAhorro;
        
        @FXML
        private TextField gananciaInversion;
        
        
        
        @FXML
        private void clicButtonCancel(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClasificacionIngresos.fxml"));
        Parent root = loader.load();

        Scene pantallaIngreso = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaIngreso);
        stage.show();
        
        }
        
        @FXML
        private void clicButtonGuardarIn(ActionEvent event) throws IOException {
        
        LocalDate fechaTrans = fechaIngresoIn.getValue();
        Date fecha = Date.from(fechaTrans.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String descripcion = descripcionBoni.getText();
        Double monto_Invertir = Double.parseDouble(montoInvertir.getText());
        Double porcentaje_Inversion = Double.parseDouble(porcentajeAInvertir.getText());
        double saldoAnterior = TransactionManager.getSaldo();
        
        
        
        
        double montoConGanancia = (monto_Invertir * (porcentaje_Inversion / 100)) + monto_Invertir;
        double nuevoSaldo = saldoAnterior + (monto_Invertir * (porcentaje_Inversion / 100));
        
       // gananciaInversion.setText(String.valueOf(nuevoSaldo));
        
        
        Ingress newIngress = new Ingress();
        newIngress.setFecha(fecha);
        newIngress.setDescripcion(descripcion);
        newIngress.setPorcentaje(porcentaje_Inversion);
        newIngress.setMontoAInvertir(monto_Invertir);
        newIngress.setSubtotal(nuevoSaldo);
        TransactionManager.addIngress(newIngress);
      
        saldoconInversion.setText(String.valueOf(TransactionManager.getSaldo()));
        
        Double a = TransactionManager.getSaldo();
        System.out.println(a);
    
    }   
        
      @FXML
      private void clicCalcAhorro(ActionEvent event) throws IOException {
      
        Double monto_Invertir = Double.parseDouble(montoInvertir.getText());
        Double porcentaje_Inversion = Double.parseDouble(porcentajeAInvertir.getText());
        double saldoAnterior = TransactionManager.getSaldo();
       
        double montoConGanancia = (monto_Invertir * (porcentaje_Inversion / 100)) + monto_Invertir;
        double nuevoSaldo = saldoAnterior + (monto_Invertir * (porcentaje_Inversion / 100));
        
        gananciaInversion.setText(String.valueOf(montoConGanancia));
      
      }
        
        
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    
    }    
    
}
