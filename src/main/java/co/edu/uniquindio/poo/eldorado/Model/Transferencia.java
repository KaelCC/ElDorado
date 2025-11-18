package co.edu.uniquindio.poo.eldorado.Model;

import java.time.LocalDate;

public class Transferencia extends Transaccion {
    private Monedero monederoOrigen;
    private Monedero monederoDestino;

    public Transferencia(String idTransaccion, LocalDate fecha, double monto,
                         Monedero monederoOrigen, Monedero monederoDestino) {
        super(idTransaccion, fecha, monto);

        if (monederoOrigen == null || monederoDestino == null) {
            throw new IllegalArgumentException("Los monederos no pueden ser nulos");
        }
        if (monederoOrigen == monederoDestino) {
            throw new IllegalArgumentException("El monedero origen y destino no pueden ser el mismo");
        }

        this.monederoOrigen = monederoOrigen;
        this.monederoDestino = monederoDestino;
    }

    @Override
    public void ejecutar() {
        if (getMonto() <= 0) {
            throw new IllegalArgumentException("El monto de la transferencia debe ser mayor que 0");
        }

        // 💸 Retirar del origen
        monederoOrigen.retirar(getMonto());

        // 💰 Depositar en el destino
        monederoDestino.depositar(getMonto());

        // 🔁 Registrar en ambos historiales
        monederoOrigen.agregarTransaccion(this);
        monederoDestino.agregarTransaccion(this);

        // 🏅 Agregar puntos al propietario (ejemplo: 1 punto por cada 200 transferidos)


        int puntosGanados = (int) (getMonto() / 100) * 3; // 1 punto por cada 100 unidades
        monederoOrigen.getCuenta().agregarPuntos(puntosGanados);
    }

    public Monedero getMonederoOrigen() {
        return monederoOrigen;
    }

    public Monedero getMonederoDestino() {
        return monederoDestino;
    }
}