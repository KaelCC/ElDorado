module co.edu.uniquindio.poo.eldorado {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens co.edu.uniquindio.poo.eldorado to javafx.fxml;
    exports co.edu.uniquindio.poo.eldorado;
}