package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import co.edu.uniquindio.poo.eldorado.Model.Monedero;
import co.edu.uniquindio.poo.eldorado.Model.Retiro;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.UUID;

public class RetiroController {
    private ElDorado elDorado;
    private Usuario usuarioActual;
    private VerMonederosController verMonederosController;

    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
        if (usuarioActual.getCuenta() != null) {
            choiceBoxMonedero.getItems().setAll(usuarioActual.getCuenta().getListaMonederos());
        }
    }

    public void setVerMonederosController(VerMonederosController verMonederosController) {
        this.verMonederosController = verMonederosController;
    }

    @FXML
    private Button btnRetirar;

    @FXML
    private ChoiceBox<Monedero> choiceBoxMonedero;

    @FXML
    private TextField txtCantidadRetiro;

    @FXML
    void Retirar(ActionEvent event) {
        Monedero seleccionado = choiceBoxMonedero.getValue();
        if (seleccionado == null) {
            System.out.println("Debe seleccionar un monedero");
            return;
        }

        try {
            double monto = Double.parseDouble(txtCantidadRetiro.getText());

            Retiro retiro = new Retiro(UUID.randomUUID().toString(), LocalDate.now(), monto, seleccionado);
            retiro.ejecutar();

            System.out.println("Retiro realizado. Nuevo saldo: " + seleccionado.getSaldo());

        } catch (NumberFormatException e) {
            System.out.println("Ingrese un monto válido");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (verMonederosController != null) {
            verMonederosController.actualizarTabla();
        }
    }
}
