package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.Cuenta;
import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import co.edu.uniquindio.poo.eldorado.Model.Notificar;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static co.edu.uniquindio.poo.eldorado.RegistroApplication.notificar;

public class RegistroController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txttelefono;

    @FXML
    void RegistrarUsuario(ActionEvent event) {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String email = txtEmail.getText();
        String telefono = txttelefono.getText();
        String password = txtPassword.getText();
        int edad = Integer.parseInt(txtEdad.getText());

        Usuario usuario = new Usuario(nombre, apellido, email, telefono, cedula, edad, password);
        elDorado.registrarUsuario(usuario);
        System.out.println("Usuario registrado");
        Cuenta cuentaBasica = new Cuenta(cedula, usuario, 0);
        usuario.agregarCuenta( cuentaBasica );
        System.out.println("Cuenta agregada al usuario");
        elDorado.registrarCuenta( cuentaBasica );
        System.out.println("Cuenta agregada al dorado");
        String mensaje = "";
        enviarNotificacion(usuario,mensaje);
    }


    @FXML
    void IrALogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
            Scene loginScene = new Scene(loader.load());

            // 🔹 Obtener el controlador del Login
            LoginController loginController = loader.getController();

            // 🔹 Pasarle la MISMA instancia del modelo
            loginController.setElDorado(elDorado);

            // 🔹 Cambiar la escena
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(loginScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("❌ Error al cargar la vista de Login");
        }
    }

private ElDorado  elDorado;
    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }


    public void start(Stage stage) throws IOException {


        notificar = new Notificar("https://m3rxp6.api.infobip.com",
                "994ac6e62cc70d529a0bc68c0ed573ec-1fc46e8b-204b-4380-ab0a-9640be69fee4");
        FXMLLoader fxmlLoader = new FXMLLoader(RegistroApplication.class.getResource("RegistroViewPrueba.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        RegistroController controller = fxmlLoader.getController();
        controller.setElDorado(elDorado);

        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.show();
    }

    public static void enviarNotificacion(Usuario usuario, String mensaje) {
        try {
            String numero=usuario.getTelefono();
            String respuesta = notificar.enviarSms(numero,mensaje);

            System.out.println("Respuesta Infobip: " + respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
