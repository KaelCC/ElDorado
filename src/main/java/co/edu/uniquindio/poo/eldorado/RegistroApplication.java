package co.edu.uniquindio.poo.eldorado;
import co.edu.uniquindio.poo.eldorado.Model.Notificar;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import co.edu.uniquindio.poo.eldorado.RegistroController;
import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class RegistroApplication extends Application {
    private ElDorado elDorado = new ElDorado("El Dorado Bank");
    public static Notificar notificar;

    @Override
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




    public static void main(String[] args) {
        launch(args);
    }

}
