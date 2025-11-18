module co.edu.uniquindio.poo.eldorado {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires okhttp3;
    opens co.edu.uniquindio.poo.eldorado.Model;

    opens co.edu.uniquindio.poo.eldorado to javafx.fxml;
    opens co.edu.uniquindio.poo.eldorado.Model to javafx.base, javafx.fxml; //
    exports co.edu.uniquindio.poo.eldorado;
}