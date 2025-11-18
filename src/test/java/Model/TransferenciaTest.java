package Model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.poo.eldorado.Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class TransferenciaTest {
    Transferencia transferencia = null;
    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario("Juan","Lopez","jLopez@gmail.com","3216427630","51941239",20,"12345");
        Cuenta cuenta = new Cuenta("1234",usuario,20);
        MonederoDiario monedero = new MonederoDiario("2345",500000,cuenta);
        MonederoDiario monedero2 = new MonederoDiario("5432",500000,cuenta);
        LocalDate fecha = LocalDate.of(2025, 11, 16);
        transferencia = new Transferencia("8901",fecha,2000,monedero,monedero2);
    }
    @Test
    public void ejecutarTest(){
        transferencia.ejecutar();
        assertEquals(498000,transferencia.getMonederoOrigen().getSaldo());
    }
    @Test
    public void ejecutarTest2(){
        transferencia.ejecutar();
        assertEquals(502000,transferencia.getMonederoDestino().getSaldo());
    }
    @Test
    public void ejecutarTest3(){
        transferencia.ejecutar();
        int puntosGanados = (int) (transferencia.getMonto() / 200);
        assertEquals(80,transferencia.getMonederoOrigen().getCuenta().getPuntos());
    }
}
