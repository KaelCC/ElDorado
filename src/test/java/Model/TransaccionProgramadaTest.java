package Model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.poo.eldorado.Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class TransaccionProgramadaTest {
    TransaccionProgramada transaccionProgramada = null;
    @BeforeEach
    public void setUp(){
        Usuario usuario = new Usuario("Juan","Lopez","jLopez@gmail.com","3216427630","51941239",20,"12345");
        Cuenta cuenta = new Cuenta("1234",usuario,20);
        MonederoDiario monedero = new MonederoDiario("2345",500000,cuenta);
        LocalDate fecha = LocalDate.of(2025, 11, 16);
        Transaccion transaccion = new Transaccion("678",fecha,2000) {
            @Override
            public void ejecutar() {

            }
        };
        transaccionProgramada = new TransaccionProgramada(transaccion,fecha);
    }
    @Test
    public void ejecutarSiCorrespondeTest(){
        transaccionProgramada.ejecutarSiCorresponde(LocalDate.of(2025, 11, 16));
        assertTrue(transaccionProgramada.getEjecutada());
    }
}
