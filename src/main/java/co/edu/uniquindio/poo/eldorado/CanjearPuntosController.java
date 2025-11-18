package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.Cuenta;
import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CanjearPuntosController {

    private Cuenta cuentaActual;
    private Usuario usuarioActual;
    private VerMonederosController verMonederosController;
    private ElDorado elDorado;

    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }
    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }
    public void setCuentaActual (Cuenta cuentaActual) {
        this.cuentaActual = cuentaActual;
        cargarDatos();
    }
    @FXML private Label labelPuntos;
    @FXML private Label labelRango;

    @FXML private TableView<Cuenta.Recompensa> tableRecompensas;
    @FXML private TableColumn<Cuenta.Recompensa, String> colNombre;
    @FXML private TableColumn<Cuenta.Recompensa, Integer> colCosto;
    @FXML private TableColumn<Cuenta.Recompensa, Void> colAccion;

    @FXML private Button btnRegresar;


    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCosto.setCellValueFactory(new PropertyValueFactory<>("costoPuntos"));

        configurarBotonCanjeo();
    }

    private void cargarDatos() {
        if (cuentaActual == null) return;

        labelPuntos.setText(String.valueOf(cuentaActual.getPuntos()));
        labelRango.setText(cuentaActual.getRango().name());

        tableRecompensas.getItems().setAll(cuentaActual.getRecompensas());
    }

    private void configurarBotonCanjeo() {
        colAccion.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("CANJEAR");

            {
                btn.setStyle("-fx-background-color: #d4af37; -fx-text-fill: white; -fx-background-radius: 8;");
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    return;
                }

                Cuenta.Recompensa recompensa = getTableView().getItems().get(getIndex());

                btn.setOnAction(e -> {
                    if (cuentaActual.getPuntos() < recompensa.costoPuntos) {
                        mostrarAlerta("No tienes suficientes puntos");
                        return;
                    }

                    cuentaActual.canjearPuntos(recompensa.costoPuntos);
                    recompensa.accion.run();
                    cargarDatos();
                });

                setGraphic(btn);
            }
        });
    }

    private void mostrarAlerta(String mensaje) {
        Alert a = new Alert(Alert.AlertType.WARNING, mensaje, ButtonType.OK);
        a.show();
    }
}
