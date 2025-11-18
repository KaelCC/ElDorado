package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.Cuenta;
import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class MainViewController {
    private ElDorado elDorado;
    @FXML
    private Button btnPuntos;
    @FXML
    private Button btnProgramar;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnDepositar;
    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnRetirar;

    @FXML
    private Button btnTransferir;


    @FXML
    private MenuItem btnAgregarMonedero;

    @FXML
    private MenuItem btnVerMonederos;

    @FXML
    private AnchorPane contentMain;

    @FXML
    private Label lblBienvenido;

    private Usuario usuarioActual;

    public void initUsuario(Usuario usuario) {
        this.usuarioActual = usuario;
        lblBienvenido.setText("Bienvenid@ " + usuario.getNombre());
    }
    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }
    @FXML
    void AgregarMonedero(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarMonederoView.fxml"));
            AnchorPane pane = loader.load();

            AgregarMonederoController controller = loader.getController();
            controller.setElDorado(elDorado);
            controller.setUsuarioActual(usuarioActual);

            contentMain.getChildren().setAll(pane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mostrarMonederos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VerMonederosView.fxml"));
            AnchorPane pane = loader.load();

            VerMonederosController controller = loader.getController();
           controller.setElDorado(elDorado);
            controller.setUsuarioActual(usuarioActual);

            contentMain.getChildren().setAll(pane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void MostrarVistaDeposito(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DepositoView.fxml"));
            AnchorPane pane = loader.load();

            DepositoController controller = loader.getController();
            controller.setElDorado(elDorado);
            controller.setUsuarioActual(usuarioActual);

            contentMain.getChildren().setAll(pane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void MostrarVistaRetiro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RetiroView.fxml"));
            AnchorPane pane = loader.load();

           RetiroController controller = loader.getController();
            controller.setElDorado(elDorado);
            controller.setUsuarioActual(usuarioActual);

            contentMain.getChildren().setAll(pane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void MostrarVistaTransferencia(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TransferenciaView.fxml"));
            AnchorPane pane = loader.load();

            TransferenciaController controller = loader.getController();
            controller.setElDorado(elDorado);
            controller.setUsuarioActual(usuarioActual);


            contentMain.getChildren().setAll(pane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void LogOut(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
            Scene loginScene = new Scene(loader.load());

            LoginController loginController = loader.getController();
            loginController.setElDorado(elDorado);

            Stage stage = (Stage) btnLogOut.getScene().getWindow();
            stage.setScene(loginScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" Error al cargar la vista de Login");
        }
    }
    @FXML
    void MostrarProgramar(ActionEvent event) {
try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("TransaccionProgramadaView.fxml"));
    AnchorPane pane = loader.load();
    TransaccionProgramadaController controller = loader.getController();
    controller.setElDorado(elDorado);
    controller.setUsuarioActual(usuarioActual);
    contentMain.getChildren().setAll(pane);
} catch(Exception e) {
    e.printStackTrace();
        }
    }

   @FXML
    void MostrarVistaPerfil(ActionEvent event) {
try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("PerfilView.fxml"));
    AnchorPane pane = loader.load();
    PerfilController controller = loader.getController();
    controller.setElDorado(elDorado);
    controller.setUsuarioActual(usuarioActual);
    contentMain.getChildren().setAll(pane);
} catch(Exception e) {
    e.printStackTrace();
}
   }
    @FXML
    void MostrarPuntos(ActionEvent event) {
try {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("CanjearPuntosView.fxml"));
    AnchorPane pane = loader.load();
    CanjearPuntosController controller = loader.getController();
    controller.setElDorado(elDorado);
    controller.setUsuarioActual(usuarioActual);
    controller.setCuentaActual(usuarioActual.getCuenta());
    contentMain.getChildren().setAll(pane);
} catch (Exception e) {
    e.printStackTrace();
}
    }


}

