package Model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.poo.eldorado.Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class MonederoTest {
    Monedero monedero = null;
    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario("Juan","Lopez","jLopez@gmail.com","3216427630","51941239",20,"12345");
        Cuenta cuenta = new Cuenta("1234",usuario,20);
        monedero = new Monedero("678", 500000, cuenta) {
            @Override
            public String getTipo() {
                return "";
            }
        };
    }
    @Test
    public void depositarTest() {
        monedero.depositar(500);
        assertEquals(500500,monedero.getSaldo());
    }
    @Test
    public void retirarTest() {
        monedero.retirar(500);
        assertEquals(499500,monedero.getSaldo());
    }
    @Test
    public void aumentarSaldoTest() {
        monedero.aumentarSaldo(500);
        assertEquals(500500,monedero.getSaldo());
    }
    @Test
    public void agregarTransaccionTest() {
        LocalDate fecha = LocalDate.of(2025, 11, 16);
        Transaccion transaccion = new Transaccion("678",fecha,2000) {
            @Override
            public void ejecutar() {

            }
        };
        monedero.agregarTransaccion(transaccion);
        assertTrue(monedero.getTransacciones().contains(transaccion));
    }
}