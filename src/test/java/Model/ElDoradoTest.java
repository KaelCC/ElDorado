package Model;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.poo.eldorado.Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ElDoradoTest {
    ElDorado elDorado=null;
    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario("Juan","Lopez","jLopez@gmail.com","3216427630","51941239",20,"12345");
        Cuenta cuenta = new Cuenta("1234",usuario,20);
        elDorado = new ElDorado("El dorado");
        elDorado.registrarCuenta( cuenta );
        elDorado.registrarUsuario( usuario );
    }
    @Test
    public void buscarUsuarioPorNombreTest(){
        elDorado.buscarUsuarioPorNombre("Juan");
        assertEquals("Juan",elDorado.getListaUsuarios().get(0).getNombre());
    }
    @Test
    public void buscarUsuarioPorEmailTest(){
        elDorado.buscarUsuarioPorEmail("jLopez@gmail.com");
        assertEquals("jLopez@gmail.com",elDorado.getListaUsuarios().get(0).getEmail());
    }
    @Test
    public void buscarCuentaPorIdTest(){
        elDorado.buscarCuentaPorId("1234");
        assertEquals("1234",elDorado.getListaCuentas().get(0).getIdCuenta());
    }
    @Test
    public void registrarCuentaTest(){
        Usuario usuario2 = new Usuario("Juan","Lopez","jLopez@gmail.com","3216427630","51941239",20,"12345");
        Cuenta cuenta2 = new Cuenta("1234",usuario2,20);
        elDorado.registrarCuenta(cuenta2);
        assertTrue(elDorado.getListaCuentas().contains(cuenta2));
    }
    @Test
    public void registrarUsuarioTest(){
        Usuario usuario2 = new Usuario("Juan","Lopez","jLopez@gmail.com","3216427630","51941239",20,"12345");
        elDorado.registrarUsuario(usuario2);
        assertTrue(elDorado.getListaUsuarios().contains(usuario2));
    }
    @Test
    public void agregarTransaccionProgramadaTest(){
        LocalDate fecha = LocalDate.of(2025, 11, 16);
        Transaccion transaccion = new Transaccion("678",fecha,2000) {
            @Override
            public void ejecutar() {

            }
        };
        TransaccionProgramada transaccionProgramada = new TransaccionProgramada(transaccion,fecha);
        elDorado.agregarTransaccionProgramada(transaccionProgramada);
        assertTrue(elDorado.getListaTransaccionProgramadas().contains(transaccionProgramada));
    }
}

