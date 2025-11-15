package co.edu.uniquindio.poo.eldorado;
import co.edu.uniquindio.poo.eldorado.RegistroController;
import co.edu.uniquindio.poo.eldorado.Model.ElDorado;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class RegistroApplication extends Application {
    private ElDorado elDorado = new ElDorado("El Dorado Bank");


    @Override
    public void start(Stage stage) throws IOException {
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
