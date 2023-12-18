
package futbolistaprevisivo;

import futbolistaprevisivo.core.TransactionManager;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import futbolistaprevisivo.core.Ingress;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;

public class IngresosBonificacionController implements Initializable {
    
    @FXML
    private Button btnCancelBoni;
    
    @FXML
    private DatePicker fechaBonificacion;
    
    @FXML
    private ComboBox<String> eligeContrato;
    
    @FXML
    private TextField montoContrato;
    
    @FXML
    private TextField porcentajeBoni;
    
    @FXML
    private TextField descripBoni;
    
    @FXML
    private TextField subTotalBoni;
    
    @FXML
    private Button calcularBoni;
    
    @FXML
    private TextField totalDeBoni;
    
    
    @FXML
    private void clicButtonCalcBoni(ActionEvent event){
    
         String elegirContrato = eligeContrato.getValue();
        Double porcentajedeBoni = Double.parseDouble(porcentajeBoni.getText());
        double montoContrato = Double.parseDouble(this.montoContrato.getText());
        
        double monto = (montoContrato * (porcentajedeBoni / 100)) + montoContrato;
        double saldoAnterior = TransactionManager.getSaldo();
        double nuevoSaldo = saldoAnterior + monto;
        double total_Bonificacion = (montoContrato * (porcentajedeBoni / 100));
        
        totalDeBoni.setText(String.valueOf(total_Bonificacion));

    
    
    }
   

    
    @FXML
    private void clicButtonCancelBoni(ActionEvent event) throws IOException {
        //System.out.println("Hizo clic en el botón 111");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClasificacionIngresos.fxml"));
        Parent root = loader.load();

        Scene pantallaIngreso = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaIngreso);
        stage.show();
    }
    
    @FXML
    private void clicButtonGuardarBoni(ActionEvent event) throws IOException {
        
        LocalDate fechaTrans = fechaBonificacion.getValue();
        Date fecha = Date.from(fechaTrans.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String descripcion = descripBoni.getText();
        String elegirContrato = eligeContrato.getValue();
        Double porcentajedeBoni = Double.parseDouble(porcentajeBoni.getText());
        double montoContrato = Double.parseDouble(this.montoContrato.getText());
        double total_Bonificacion = (montoContrato * (porcentajedeBoni / 100));
        
        double monto = total_Bonificacion + montoContrato;
        double saldoAnterior = TransactionManager.getSaldo();
        double nuevoSaldo = saldoAnterior + total_Bonificacion;
        
        
        
        Ingress newIngress = new Ingress();
        newIngress.setFecha(fecha);
        newIngress.setDescripcion(descripcion);
        newIngress.setPorcentaje(porcentajedeBoni);
        newIngress.setSubtotal(nuevoSaldo);
        TransactionManager.addIngress(newIngress);
      
        subTotalBoni.setText(String.valueOf(nuevoSaldo));
        
        Double a = TransactionManager.getSaldo();
        System.out.println(a);
    
    }   
    
    
    
   
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb){
        List<Ingress> ingresosConContrato = TransactionManager.getIngressesWithContrato();
        
        List<String> descripciones = ingresosConContrato.stream()
         .map(Ingress::getDescripcion)
         .collect(Collectors.toList());
        eligeContrato.getItems().addAll(descripciones);
        
        eligeContrato.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    
          actualizarSubtotalContrato(newValue);
    
    });
    
    }

    // Método para actualizar el TextField con el subtotal del contrato seleccionado
    private void actualizarSubtotalContrato(String contratoSeleccionado) {
        // Obtiene el Ingress correspondiente al contrato seleccionado
        Ingress ingressSeleccionado = TransactionManager.getIngressByDescripcion(contratoSeleccionado);

        // Verifica que el Ingress no sea nulo antes de acceder al subtotal
        if (ingressSeleccionado != null) {
            double subtotal = ingressSeleccionado.getSubtotal();
            montoContrato.setText(String.valueOf(subtotal));
        } else {
            // Puedes manejar la situación en la que no se encuentra el Ingress
            montoContrato.setText("Contrato no encontrado");
        }
    }
        
        
  
        
    }    
    

