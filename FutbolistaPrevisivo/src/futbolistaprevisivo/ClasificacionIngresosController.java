/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javax.swing.Action;

/**
 * FXML Controller class
 *
 * @author josevictorgonzalez
 */
public class ClasificacionIngresosController implements Initializable {
    
      @FXML
      private Button volverMenuI;
      
      @FXML
      private Button btnContratos;
      
      @FXML
      private Button btnAhorros;
      
      @FXML
      private Button btnPremios;
      
      @FXML
      private Button btnIngresosPubli;
      
       @FXML
        private void clicButtonIngContrato(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IngresosContratos.fxml"));
        Parent root = loader.load();
    
        Scene PantallaIngresosContratos = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(PantallaIngresosContratos);
         stage.show();
        
        }
        
          @FXML
        private void clicButtonIngAhorro(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IngresosAhorrosInversiones.FXML"));
        Parent root = loader.load();
    
        Scene PantallaIngresosAhorros = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(PantallaIngresosAhorros);
         stage.show();
        
        }
              

      @FXML
        private void clicButtonVolverMenu(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicio.fxml"));
        Parent root = loader.load();
    
        Scene pantallaMenuInicio = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(pantallaMenuInicio);
         stage.show();
        
        }
        
        @FXML
        private void clicButtonPremios(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IngresosPremiosBonos.fxml"));
        Parent root = loader.load();
    
        Scene PantallaIngresosPremios = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(PantallaIngresosPremios);
         stage.show();
        
        }
        
        
        @FXML
        private void clicButtonIngPubli(ActionEvent event) throws IOException {
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IngresosPublicidad.fxml"));
        Parent root = loader.load();
    
        Scene PantallaIngresosPublicidad = new Scene(root);
    
         Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    
         stage.setScene(PantallaIngresosPublicidad);
         stage.show();
        
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
