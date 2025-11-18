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

public class CuentaTest {
    Cuenta cuenta = null;
    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario("Juan","Lopez","jLopez@gmail.com","3216427630","51941239",20,"12345");
        cuenta= new Cuenta("1234",usuario,20);
    }
    @Test
    public void agregarPuntosTest(){
        cuenta.agregarPuntos(30);
        assertEquals(50,cuenta.getPuntos());
    }
    @Test
    public void actualizarRangoTest(){
        cuenta.agregarPuntos(30);
        cuenta.actualizarRango();
        assertEquals(Rango.BRONCE,cuenta.getRango());
    }
    @Test
    public void canjearPuntosTest(){
        cuenta.canjearPuntos(10);
        assertEquals(10,cuenta.getPuntos());
    }
    @Test
    public void agregarMonederoTest(){
        Monedero monedero =  new Monedero("678", 500000, cuenta) {
            @Override
            public String getTipo() {
                return "";
            }
        };
        cuenta.agregarMonedero(monedero);
        assertTrue(cuenta.getListaMonederos().contains(monedero));
    }
    @Test
    public void generarIdMonederoTest(){
        Monedero monedero =  new Monedero("678", 500000, cuenta) {
            @Override
            public String getTipo() {
                return "";
            }
        };
        cuenta.agregarMonedero(monedero);
        assertEquals("MON-2",cuenta.generarIdMonedero());
    }
}
