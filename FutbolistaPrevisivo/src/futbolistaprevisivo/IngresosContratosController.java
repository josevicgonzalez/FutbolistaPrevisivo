
package futbolistaprevisivo;

import com.sun.scenario.effect.impl.Renderer;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.util.Date;
import javafx.scene.control.Label;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.ZoneId;
import futbolistaprevisivo.Transaccion;
import java.util.HashSet;
import javafx.application.Platform;

public class IngresosContratosController implements Initializable {
    
        @FXML
        private DatePicker fechaIngreso; 
        
        @FXML
        private ComboBox tipoIngreso;
        
        @FXML 
        private TextField descripIngreso;
        
        @FXML
        private TextField montoIngreso;
        
        private int valorMontoIngreso;
        LocalDate fechaDeIngreso;
        
        private String descripcionDeIngreso;
        
        @FXML
        private ComboBox<String> comboTipoIngreso; 
        
        @FXML
        private ComboBox<String> comboTipoContrato; 
        
        private int ingresoSeleccionado;
        
        @FXML
        private TextField noYearsText;
        
        @FXML
        private TextField valorYearText;
        
        @FXML
        private Button btnIngreso;
        
        @FXML
        private Label prueba;
   
     
        @FXML
        private void comboboxEvent(ActionEvent event){
        
        }
        
        @FXML 
        private Button btnVolverIng;
        
  
        
       // ComboBox<String> tipoIngresoCombo = new ComboBox<>();
                
        
        @FXML
        private void clicButtonGuardarIn(ActionEvent event){
            LocalDate fechaTrans = fechaIngreso.getValue();
            Date fecha = Date.from(fechaTrans.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            String descripcion = descripIngreso.getText();
        //  double monto = Double.parseDouble(montoIngreso.getText());
       
            
            String equipoIngresos = comboTipoIngreso.getValue();
            String tiempoContrato = comboTipoContrato.getValue();
            
            int noYears = Integer.parseInt(noYearsText.getText());
            int valorYear = Integer.parseInt(valorYearText.getText());
            
            double monto = noYears * valorYear; 
           
            Transaccion.setMonto(monto);
            Transaccion.setDescripcion(descripcion);
            Transaccion.setEquipoIngresos(equipoIngresos);
            Transaccion.setTiempoContrato(tiempoContrato);
            Transaccion.setNoYears(noYears);
            Transaccion.setValorYear(valorYear);
            Transaccion.setFechaTrans(fechaTrans);
            
            montoIngreso.setText(String.valueOf(monto));
            
          
            Transaccion nuevoIngreso = new Transaccion(descripcion, monto, fechaTrans, equipoIngresos, tiempoContrato, noYears, valorYear);  
            System.out.println("Nueva Transacción " +  nuevoIngreso.getDescripcion() + "  "+  nuevoIngreso.getMonto() + ", " + nuevoIngreso.getFechaTrans() + " "+ nuevoIngreso.getEquipoIngresos() + " " + nuevoIngreso.getTiempoContrato() + " " + nuevoIngreso.getNoYears() + " " + nuevoIngreso.getValorYear());
           
        }        
        
        
  
        @FXML
        private void clicButtonVolverIn(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicio.fxml"));
        Parent root = loader.load();
    
        Scene pantallaMenuInicio = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(pantallaMenuInicio);
         stage.show();
        
        }
        
        
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* ArrayList<String> listaTipoIngresos = new ArrayList<>();
       Collections.addAll(listaTipoIngresos, "uno", "dos");
       comboTipoIgreso.getItems().addAll(listaTipoIngresos);*/
       
      comboTipoIngreso.getItems().addAll("Equipo Estrella");
      comboTipoIngreso.getItems().addAll("Equipo Galaxia");
      comboTipoIngreso.getItems().addAll("Equipo Cometa");
      comboTipoIngreso.getItems().addAll("Seleccion Nacional");    
      
      comboTipoContrato.getItems().addAll("Contrato Anual");
      comboTipoContrato.getItems().addAll("Contrato MultiAnual");
      
   
    }    
    
 
    
}
