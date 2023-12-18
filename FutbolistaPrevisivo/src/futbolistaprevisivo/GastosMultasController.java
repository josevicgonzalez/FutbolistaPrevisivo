package futbolistaprevisivo;

import futbolistaprevisivo.core.Egress;
import futbolistaprevisivo.core.Ingress;
import futbolistaprevisivo.core.TransactionManager;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
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

public class GastosMultasController implements Initializable {
    
    @FXML 
    private Button btnVolver;
    
    @FXML
    private Button btnGuardarM;
    
    @FXML
    private DatePicker fechaMulta;
    
    @FXML
    private ComboBox<String> eligeContrato;
    
    @FXML
    private TextField montoContrato;
    
    @FXML
    private TextField porcentajeMulta;
    
    @FXML
    private TextField descripMulta;
    
    @FXML
    private TextField saldoSinMulta;
    
    @FXML
    private TextField totalMultaAPagar;
    
    
     @FXML
     private void clicButtonVolver(ActionEvent event) throws IOException {
            
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ClasificacionGastos.fxml"));
        Parent root = loader.load();

        Scene pantallaClasificaGastos = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaClasificaGastos);
        stage.show();
        
     }
     
      @FXML
    private void clicButtonGuardarMulta(ActionEvent event) {
        
        LocalDate fechaTrans = fechaMulta.getValue();
        Date fecha = Date.from(fechaTrans.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String descripcion = descripMulta.getText();
        String elegirContrato = eligeContrato.getValue();
        Double porcentaje_Multa = Double.parseDouble(porcentajeMulta.getText());
        double monto_Contrato = Double.parseDouble(this.montoContrato.getText());
        
        double monto = monto_Contrato - (monto_Contrato * (porcentaje_Multa / 100));
        double saldoAnterior = TransactionManager.getSaldo();
        double nuevoSaldo = saldoAnterior - (monto_Contrato * (porcentaje_Multa / 100));
        
        
        
        Egress newEgress= new Egress();
        newEgress.setFecha(fecha);
        newEgress.setDescripcion(descripcion);
        newEgress.setPorcentaje(porcentaje_Multa);
        newEgress.setSubtotal(nuevoSaldo);
        TransactionManager.addEgress(newEgress);
      
        saldoSinMulta.setText(String.valueOf(nuevoSaldo));
        
        Double a = TransactionManager.getSaldo();
        System.out.println(a);
    
    
    }

        @FXML
        private void clicButtonCalcMulta(ActionEvent event){
    
        Double porcentaje_Multa = Double.parseDouble(porcentajeMulta.getText());
        double monto_Contrato = Double.parseDouble(this.montoContrato.getText());
        
        double monto = monto_Contrato - (monto_Contrato * (porcentaje_Multa / 100));
        double saldoAnterior = TransactionManager.getSaldo();
        double nuevoSaldo = saldoAnterior - monto;
        totalMultaAPagar.setText(String.valueOf((monto_Contrato * (porcentaje_Multa / 100))));

    
    }
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
