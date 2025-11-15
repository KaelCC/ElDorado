package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.Cuenta;
import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;

public class MainViewController {
    private ElDorado elDorado;
    @FXML
    private MenuItem btnAgregarCuenta;

    @FXML
    private MenuItem btnVerCuentas;
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
    void AgregarCuenta(ActionEvent event) {

    }

    @FXML
    void mostrarCuentas(ActionEvent event) {

    }
}
