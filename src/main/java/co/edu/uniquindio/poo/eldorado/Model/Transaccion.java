package co.edu.uniquindio.poo.eldorado.Model;

import java.time.LocalDate;

public abstract class Transaccion {
    protected String idTransaccion;
    protected LocalDate fecha;
    protected double monto;
    protected Cuenta cuenta;

    public Transaccion(String idTransaccion, LocalDate fecha, double monto) {
        if (idTransaccion == null || idTransaccion.isBlank() || fecha == null || monto <= 0) {
            throw new IllegalArgumentException("Datos inconclusos o inválidos");
        }
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.monto = monto;
    }


    public abstract void ejecutar();


    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        if (idTransaccion == null || idTransaccion.isBlank()) {
            throw new IllegalArgumentException("ID de transacción inválido");
        }
        this.idTransaccion = idTransaccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        this.monto = monto;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula");
        }
        this.cuenta = cuenta;
    }
}
