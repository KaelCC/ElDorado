package Model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.poo.eldorado.Model.Cuenta;
import co.edu.uniquindio.poo.eldorado.Model.Monedero;
import co.edu.uniquindio.poo.eldorado.Model.Rango;
import co.edu.uniquindio.poo.eldorado.Model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class UsuarioTest {
    Usuario usuario = null;
    @BeforeEach
    public void setUp(){
        usuario = new Usuario("Juan","Lopez","jLopez@gmail.com","3216427630","51941239",20,"12345");
    }
    @Test
    public void agregarCuentaTest(){
        Cuenta cuenta= new Cuenta("1234",usuario,20);
        usuario.agregarCuenta( cuenta );
        assertTrue(usuario.getCuenta().equals(cuenta));
    }
}
