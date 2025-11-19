package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.time.LocalDate;
import java.util.UUID;

public class TransaccionProgramadaController {

    private ElDorado elDorado;
    private Usuario usuarioActual;
    private VerMonederosController verMonederosController;

    @FXML
    private Button btnProgramar;

    @FXML
    private ChoiceBox<Monedero> choiceBoxMonedero;

    @FXML
    private ChoiceBox<String> choiceBoxTipoTransaccion;

    @FXML
    private DatePicker datePickerFecha;

    @FXML
    private TextField txtCuentaDestino;

    @FXML
    private TextField txtTransaccion;  // monto

    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
        cargarMonederos();
    }

    @FXML
    private void initialize() {
        choiceBoxTipoTransaccion.getItems().addAll("Depósito", "Retiro", "Transferencia");
        ejecutarTransaccionesPendientes();
    }
    private void ejecutarTransaccionesPendientes() {
        if (elDorado == null) return;

        LocalDate hoy = LocalDate.now();

        for (TransaccionProgramada tp : elDorado.getListaTransaccionProgramadas()) {
            tp.ejecutarSiCorresponde(hoy);
        }
    }

    public void setVerMonederosController(VerMonederosController verMonederosController) {
        this.verMonederosController = verMonederosController;
    }

    private void cargarMonederos() {
        if (usuarioActual != null &&
                usuarioActual.getCuenta() != null &&
                choiceBoxMonedero != null) {

            choiceBoxMonedero.getItems().setAll(usuarioActual.getCuenta().getListaMonederos());
        }
    }


    @FXML
    void programar(ActionEvent event) {

        Monedero origen = choiceBoxMonedero.getValue();
        if (origen == null) {
            System.out.println("Debe seleccionar un monedero de origen");
            return;
        }

        try {
            double monto = Double.parseDouble(txtTransaccion.getText());
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto debe ser mayor que 0");
            }

            String tipo = choiceBoxTipoTransaccion.getValue();
            if (tipo == null) {
                throw new IllegalArgumentException("Debe elegir un tipo de transacción");
            }

            LocalDate fecha = datePickerFecha.getValue();
            if (fecha == null) {
                throw new IllegalArgumentException("Debe seleccionar una fecha");
            }

            Transaccion transaccion = null;

            if (tipo.equals("Depósito")) {
                transaccion = new Deposito(UUID.randomUUID().toString(), fecha, monto, origen);
            }
            else if (tipo.equals("Retiro")) {
                transaccion = new Retiro(UUID.randomUUID().toString(), fecha, monto, origen);
            }
            else if (tipo.equals("Transferencia")) {
                String idDestino = txtCuentaDestino.getText();
                if (idDestino == null || idDestino.isEmpty()) {
                    throw new IllegalArgumentException("Debe ingresar una cuenta destino para transferir");
                }

                Cuenta cuentaDestino = elDorado.buscarCuentaPorId(idDestino);
                if (cuentaDestino == null) {
                    throw new IllegalArgumentException("No existe una cuenta con esa cédula o ID");
                }

                Monedero destino = cuentaDestino.getListaMonederos().get(0);
                transaccion = new Transferencia(UUID.randomUUID().toString(), fecha, monto, origen, destino);
            }

            if (transaccion == null) {
                System.out.println("Error creando la transacción");
                return;
            }

            TransaccionProgramada tp = new TransaccionProgramada(transaccion, fecha);
            elDorado.agregarTransaccionProgramada(tp);

            if (!fecha.isAfter(LocalDate.now())) {
                tp.ejecutarSiCorresponde(LocalDate.now());
            }

            JOptionPane.showMessageDialog(null, "se programo una transaccion para" + fecha);

            if (verMonederosController != null) {
                verMonederosController.actualizarTabla();
            }

        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "seleccione una cantidad valida");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}

