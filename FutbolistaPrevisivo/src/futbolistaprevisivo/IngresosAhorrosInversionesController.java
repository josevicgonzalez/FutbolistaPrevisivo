
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
            
            String descripcionAhorro = descripIngreso.getText();
        //  double monto = Double.parseDouble(montoIngreso.getText());
           
            Transaccion nuevoIngreso = Transaccion.getInstancia();
            double totalAhorro = nuevoIngreso.getMonto();
        //    System.out.println(nuevoIngreso.getMonto());
        //    System.out.println(totalAhorro);
        //     System.out.println(nuevoIngreso.getDescripcion());
            
            double porcentaje = Double.parseDouble(porAhorro.getText());
            
            double montoAhorro = (totalAhorro * (porcentaje /100)); 
            
            montoAhorroT.setText(String.valueOf(montoAhorro));
         
            System.out.println(montoAhorro);
           
            Transaccion.getInstancia().setMonto(totalAhorro - montoAhorro); 
            System.out.println("Su nuevo saldo es " + nuevoIngreso.getMonto());
            
            TransaccionAhorros nuevoAhorro = new TransaccionAhorros(descripcionAhorro,montoAhorro,fechaAhorro,porcentaje);  
            
            System.out.println("Nueva Transacción " +  nuevoAhorro.getDescripcionAhorro() + "  "+  nuevoAhorro.getMontoAhorro() + ", " + nuevoAhorro.getFechaAhorro() +  " " + nuevoAhorro.getPorcentaje());
            
            nuevoSaldo.setText("Su saldo disponible es " + nuevoIngreso.getMonto() );
            
            
        } 
    
    @FXML
        private void clicButtonVolverM(ActionEvent event) throws IOException {
            
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
