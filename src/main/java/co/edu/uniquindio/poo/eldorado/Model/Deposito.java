package co.edu.uniquindio.poo.eldorado.Model;

import java.time.LocalDate;

import static co.edu.uniquindio.poo.eldorado.RegistroController.enviarNotificacion;

public class Deposito extends Transaccion {

    private Monedero monederoDestino;

    public Deposito(String idTransaccion, LocalDate fecha, double monto, Monedero monederoDestino) {
        super(idTransaccion, fecha, monto);
        if (monederoDestino == null) {
            throw new IllegalArgumentException("El monedero destino no puede ser nulo");
        }
        this.monederoDestino = monederoDestino;
    }

    @Override
    public void ejecutar() {
        if (getMonto() <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor que 0");
        }

        monederoDestino.aumentarSaldo(getMonto());


        monederoDestino.agregarTransaccion(this);



        int puntosGanados = (int) (getMonto() / 100) * 1; // 1 punto por cada 100 unidades
        monederoDestino.getCuenta().agregarPuntos(puntosGanados);

        Usuario usuario = monederoDestino.getCuenta().getPropietario();
        enviarNotificacion(usuario,"Su deposito ah sido exitoso");
    }

    public Monedero getMonederoDestino() {
        return monederoDestino;
    }
}
