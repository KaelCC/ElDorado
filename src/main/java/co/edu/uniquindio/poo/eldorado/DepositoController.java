package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.Deposito;
import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import co.edu.uniquindio.poo.eldorado.Model.Monedero;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.UUID;

public class DepositoController {
    private Usuario usuarioActual;
    private VerMonederosController verMonederosController;
private ElDorado elDorado;
    @FXML
    private Button BtnDepositar;

    @FXML
    private ChoiceBox<Monedero> choiceboxElegirMonedero;

    @FXML
    private TextField txtCantidadDeposito;
    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }
    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
        if (usuarioActual.getCuenta() != null) {
            choiceboxElegirMonedero.getItems().setAll(usuarioActual.getCuenta().getListaMonederos());
        }
    }


    public void setVerMonederosController(VerMonederosController verMonederosController) {
        this.verMonederosController = verMonederosController;
    }

    @FXML
    void Depositar(ActionEvent event) {
        Monedero seleccionado = choiceboxElegirMonedero.getValue();
        if (seleccionado == null) {
            System.out.println("Debe seleccionar un monedero");
            return;
        }

        try {
            double monto = Double.parseDouble(txtCantidadDeposito.getText());
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto debe ser mayor que 0");
            }


            String idTransaccion = UUID.randomUUID().toString(); // id único
            Deposito deposito = new Deposito(idTransaccion, LocalDate.now(), monto, seleccionado);
            deposito.ejecutar();

            System.out.println("Depósito realizado. Nuevo saldo: " + seleccionado.getSaldo());


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
