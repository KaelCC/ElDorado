package co.edu.uniquindio.poo.eldorado;


import co.edu.uniquindio.poo.eldorado.Model.Cuenta;
import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtEmailIngresado;

    @FXML
    private PasswordField txtPasswordEntered;

    @FXML
    void IniciarSesion(ActionEvent event) {
        String email = txtEmailIngresado.getText();
        String password = txtPasswordEntered.getText();

        Usuario usuario = elDorado.buscarUsuarioPorEmail(email);

        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "usuario no encontrado");
            return;
        }

        if (usuario.getPassword().equals(password)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido " + usuario.getNombre());
        } else {
           JOptionPane.showMessageDialog(null, "contraseña incorrecta");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
            Scene mainScene = new Scene(loader.load());

            MainViewController mainController = loader.getController();

            mainController.setElDorado(elDorado);
            mainController.initUsuario(usuario);

            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(mainScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" Error al cargar la vista de Main");
        }
    }



    private ElDorado elDorado;

    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }





    @FXML
    void IrARegistro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistroViewPrueba.fxml"));
            Scene registroScene = new Scene(loader.load());

            RegistroController registroController = loader.getController();

            registroController.setElDorado(elDorado);

            Stage stage = (Stage) btnRegistrar.getScene().getWindow();
            stage.setScene(registroScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista de Registro");
        }
    }




}
