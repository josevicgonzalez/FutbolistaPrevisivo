package futbolistaprevisivo;

import com.sun.scenario.effect.impl.Renderer;
import futbolistaprevisivo.core.Ingress;
import futbolistaprevisivo.core.TransactionManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuInicioController implements Initializable {

    @FXML
    private Button btnIngreso;

    @FXML
    private Button btnEgreso;
    
    @FXML
    private Button btnEsCuenta;
    
    @FXML
    private Button btnSalir;
    

    @FXML
    private void clicButtonIngreso(ActionEvent event) throws IOException {
        //System.out.println("Hizo clic en el botón 111");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClasificacionIngresos.fxml"));
        Parent root = loader.load();

        Scene pantallaIngreso = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaIngreso);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void clicButtonEgreso(ActionEvent event) throws IOException {
        System.out.println("Hizo clic en el botón");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ClasificacionGastos.fxml"));
        Parent root = loader.load();

        Scene pantallaClasificaGastos = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaClasificaGastos);
        stage.show();
    }
    
    @FXML
    private void clicButtonEsCuenta (ActionEvent event) throws IOException{
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EstadosdeCuenta.fxml"));
        Parent root = loader.load();

        Scene pantallaEsCuenta = new Scene(root);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(pantallaEsCuenta);
        stage.show();
    
    
    }
    
      @FXML
      private void clicButtonSalir (ActionEvent event) {
          
          Stage stage = (Stage) btnSalir.getScene().getWindow();
          stage.close();
  
    
  
    }
    
    

}
