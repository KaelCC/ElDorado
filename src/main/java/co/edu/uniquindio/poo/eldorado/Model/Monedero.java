package co.edu.uniquindio.poo.eldorado.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Monedero {
    protected String idMonedero;
    protected double saldo;
    protected Cuenta cuenta;
    protected List<Transaccion> transacciones;

    public Monedero(String idMonedero, double saldo, Cuenta cuenta) {
        if (idMonedero == null || idMonedero.isBlank() || saldo < 0 || cuenta == null) {
            throw new IllegalArgumentException("Datos inválidos o insuficientes");
        }
        this.idMonedero = idMonedero;
        this.saldo = saldo;
        this.cuenta = cuenta;
        this.transacciones = new ArrayList<>();
    }
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        saldo += monto;
    }
    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        if (monto > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo -= monto;
    }
    public void aumentarSaldo(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a aumentar debe ser mayor a 0");
        }
        saldo += monto;
    }
    public void agregarTransaccion(Transaccion transaccion) {
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula");
        }
        transacciones.add(transaccion);
    }


    public String getIdMonedero() {
        return idMonedero;
    }

    public void setIdMonedero(String idMonedero) {
        if (idMonedero == null || idMonedero.isBlank()) {
            throw new IllegalArgumentException("ID inválido");
        }
        this.idMonedero = idMonedero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        this.saldo = saldo;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
    public abstract String getTipo();

    public void setCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula");
        }
        this.cuenta = cuenta;
    }
    @Override
    public String toString() {
        return getTipo() + " - " + getIdMonedero();
    }

    }

