
package futbolistaprevisivo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.time.LocalDate;
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
    private DatePicker fechaEgreso; 
    
    @FXML
    private ComboBox tipoEgreso;
    
    @FXML
    private TextField descripcionEgreso;
    
    @FXML
    private TextField montoEgreso;
    
    private int valorMontoEgreso;
    LocalDate fechaDeEgreso;
    
    private String descripcionDeEgreso;
    
    @FXML
    private ComboBox<String> comboTipoEgreso;
    
    private int egresoSeleccionado;
    
      @FXML
        private void clicButtonGuardarEg(ActionEvent event){
            var valorMontoEgreso = montoEgreso.getText();
           
           
            LocalDate fechaDeEgresoDate = fechaEgreso.getValue();
            
            
            String tipoEgresoSeleccionado = comboTipoEgreso.getValue();
            
            var descripcionDeEgreso = descripcionEgreso.getText();
            
            var ingresoSeleccionado = comboTipoEgreso.getSelectionModel().getSelectedItem();
            System.out.println("El tipo de egreso es " + egresoSeleccionado);
           
            
            
        }   
        
        @FXML
        private void clicButtonVolverEg(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicio.fxml"));
        Parent root = loader.load();
    
        Scene pantallaMenuInicio = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(pantallaMenuInicio);
         stage.show();
        
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboTipoEgreso.getItems().addAll("Pérdidas porcentaje inversión");
        comboTipoEgreso.getItems().addAll("Multas por sanción");
        comboTipoEgreso.getItems().addAll("Inactividad");
        comboTipoEgreso.getItems().addAll("Lesiones");
        comboTipoEgreso.getItems().addAll("Manutención");
        comboTipoEgreso.getItems().addAll("Donaciones");
           
        
    }    
    
}
