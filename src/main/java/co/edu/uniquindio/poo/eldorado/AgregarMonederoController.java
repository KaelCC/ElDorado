package co.edu.uniquindio.poo.eldorado;

import co.edu.uniquindio.poo.eldorado.Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import javafx.event.ActionEvent;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.sql.SQLOutput;


public class AgregarMonederoController {
    private ElDorado elDorado;
    private Usuario usuarioActual;

    public void setElDorado(ElDorado elDorado) {
        this.elDorado = elDorado;
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    @FXML
    private Button btnCrearMonedero;

    @FXML
    private ChoiceBox<String> choiceTipoMonedero;
    @FXML
    public void initialize() {
        choiceTipoMonedero.getItems().addAll("Ahorro", "Diario");
    }
    @FXML
    void AgregarMonedero(ActionEvent event) {

        if (choiceTipoMonedero == null) {
           JOptionPane.showMessageDialog(null, "ingrese un tipo de monedero");
            return;
        }



        Monedero nuevo = null;
        String id = usuarioActual.getCuenta().generarIdMonedero();

       if(choiceTipoMonedero.getValue().equals("Ahorro")){
         nuevo = new MonederoAhorro(id, 0, usuarioActual.getCuenta() );

        JOptionPane.showMessageDialog(null, "se creo un monedero de ahorro");

       } else if (choiceTipoMonedero.getValue().equals("Diario")){
         nuevo = new MonederoDiario(id, 0, usuarioActual.getCuenta() );
          JOptionPane.showMessageDialog(null, "se creo un monedero gasto diario");
       }
        usuarioActual.getCuenta().agregarMonedero(nuevo);


    }
}
