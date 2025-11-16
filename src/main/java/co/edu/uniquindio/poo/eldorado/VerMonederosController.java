package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import co.edu.uniquindio.poo.eldorado.Model.Monedero;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class VerMonederosController implements Initializable {
    private ElDorado elDorado;
    private Usuario usuarioActual;

    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
        actualizarTabla();
    }

    @FXML
    private TableColumn<Monedero, String> colId;


    @FXML
    private TableColumn<Monedero, Double> colSaldo;

    @FXML
    private TableColumn<Monedero, String> colTipo;

    @FXML
    private TableView<Monedero> tableMonederos;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colId.setCellValueFactory(new PropertyValueFactory<>("IdMonedero"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("Saldo"));

    }

    public void actualizarTabla() {
        if (usuarioActual != null && usuarioActual.getCuenta() != null) {
            tableMonederos.getItems().setAll(
                    usuarioActual.getCuenta().getListaMonederos()
            );
        } else {
            System.out.println("falta algo");
        }


    }
}