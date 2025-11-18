package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import co.edu.uniquindio.poo.eldorado.Model.Monedero;
import co.edu.uniquindio.poo.eldorado.Model.Transaccion;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class PerfilController {

    private ElDorado elDorado;
    private Usuario usuarioActual;

    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
        cargarDatos();
    }

    @FXML private Label labelNombre;
    @FXML private Label labelCedula;
    @FXML private Label labelCorreo;
    @FXML private Label labelPuntos;
    @FXML private Label labelCuentaId;

    @FXML private Label labelRango;

    @FXML private TableView<Transaccion> tableTransacciones;
    @FXML private TableColumn<Transaccion, String> colFecha;
    @FXML private TableColumn<Transaccion, String> colDescripcion;
    @FXML private TableColumn<Transaccion, Double> colMonto;

    @FXML
    public void initialize() {
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
    }


    private void cargarDatos() {
        if (usuarioActual == null)
            return;

        labelNombre.setText("Nombre: " + usuarioActual.getNombre());
        labelCedula.setText("Cédula: " + usuarioActual.getCedula());
        labelCorreo.setText("Correo: " + usuarioActual.getEmail());

        if (usuarioActual.getCuenta() != null) {
            labelPuntos.setText("Puntos: " + usuarioActual.getCuenta().getPuntos());
        } else {
            labelPuntos.setText("Puntos: 0");
        }
        if (usuarioActual.getCuenta() != null) {
            labelCuentaId.setText("ID de la Cuenta: " + usuarioActual.getCuenta().getIdCuenta());
        }
        if (usuarioActual.getCuenta() != null) {
            labelRango.setText("Rango: " + usuarioActual.getCuenta().getRango());
        }

        List<Transaccion> trans = obtenerTransaccionesDeMonederos();
        tableTransacciones.getItems().setAll(trans);
    }


    private List<Monedero> obtenerMonederosUsuario() {
        if (usuarioActual != null &&
                usuarioActual.getCuenta() != null &&
                usuarioActual.getCuenta().getListaMonederos() != null) {

            return usuarioActual.getCuenta().getListaMonederos();
        }

        return new ArrayList<>();
    }

    private List<Transaccion> obtenerTransaccionesDeMonederos() {
        List<Transaccion> lista = new ArrayList<>();

        for (Monedero m : obtenerMonederosUsuario()) {
            if (m.getTransacciones() != null) {
                lista.addAll(m.getTransacciones());
            }
        }

        return lista;
    }
}
