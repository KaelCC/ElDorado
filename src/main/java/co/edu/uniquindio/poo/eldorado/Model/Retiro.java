package co.edu.uniquindio.poo.eldorado.Model;

import java.time.LocalDate;

public class Retiro extends Transaccion {

    private Monedero monederoOrigen;

    public Retiro(String idTransaccion, LocalDate fecha, double monto, Monedero monederoOrigen) {
        super(idTransaccion, fecha, monto);
        if (monederoOrigen == null) {
            throw new IllegalArgumentException("El monedero origen no puede ser nulo");
        }
        this.monederoOrigen = monederoOrigen;
    }

    @Override
    public void ejecutar() {

        if (getMonto() <= 0) {
            throw new IllegalArgumentException("El monto del retiro debe ser mayor que 0");
        }


        monederoOrigen.retirar(getMonto());
        monederoOrigen.agregarTransaccion(this);

    }

    public Monedero getMonederoOrigen() {
        return monederoOrigen;
    }
}
