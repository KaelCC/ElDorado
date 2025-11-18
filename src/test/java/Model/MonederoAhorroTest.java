package Model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.poo.eldorado.Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class MonederoAhorroTest {
    MonederoAhorro monederoAhorro = null;
    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario("Juan","Lopez","jLopez@gmail.com","3216427630","51941239",20,"12345");
        Cuenta cuenta = new Cuenta("1234",usuario,20);
        monederoAhorro = new MonederoAhorro("678", 500000, cuenta);
    }
    @Test
    public void depositarTest(){
        monederoAhorro.depositar(500);
        assertEquals(500510,monederoAhorro.getSaldo());
    }
}