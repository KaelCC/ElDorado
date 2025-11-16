package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.UUID;

public class TransferenciaController {

    private Usuario usuarioActual;
    private VerMonederosController verMonederosController;
    private ElDorado elDorado;

    @FXML
    private ChoiceBox<Monedero> choiceBoxMonedero;

    @FXML
    private Button btnTransferir;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtDestino;


    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
        cargarMonederos();
    }

    public void setVerMonederosController(VerMonederosController verMonederosController) {
        this.verMonederosController = verMonederosController;
    }

    @FXML
    private void initialize() {

        cargarMonederos();
    }

    private void cargarMonederos() {
        if (usuarioActual != null && usuarioActual.getCuenta() != null && choiceBoxMonedero != null) {
            choiceBoxMonedero.getItems().setAll(usuarioActual.getCuenta().getListaMonederos());
        }
    }

    @FXML
    void Transferir(ActionEvent event) {
        Monedero origen = choiceBoxMonedero.getValue();
        if (origen == null) {
            System.out.println("Debe seleccionar un monedero de origen");
            return;
        }

        try {
            double monto = Double.parseDouble(txtCantidad.getText());
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto debe ser mayor que 0");
            }

            String idCuentaDestino = txtDestino.getText();
            Cuenta cuentaDestino = elDorado.buscarCuentaPorId(idCuentaDestino);
            if (cuentaDestino == null) {
                System.out.println("No existe una cuenta con esa cédula");
                return;
            }

            Monedero destino = cuentaDestino.getListaMonederos().get(0);

            String idTransaccion = UUID.randomUUID().toString();
            Transferencia transferencia = new Transferencia(idTransaccion, LocalDate.now(), monto, origen, destino);
            transferencia.ejecutar();

            System.out.println("Transferencia realizada. Nuevo saldo: " + origen.getSaldo());

            if (verMonederosController != null) {
                verMonederosController.actualizarTabla();
            }

        } catch (NumberFormatException e) {
            System.out.println("Ingrese un monto válido");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
