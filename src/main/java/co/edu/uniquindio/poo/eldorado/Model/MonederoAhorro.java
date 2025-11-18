package co.edu.uniquindio.poo.eldorado.Model;

public class MonederoAhorro extends Monedero {

    public MonederoAhorro(String idMonedero, double saldo, Cuenta cuenta) {
        super(idMonedero, saldo, cuenta);
    }

@Override
public String getTipo(){
        return "ahorro";
}
    @Override
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }

        double bonificacion = monto * 0.02; // 2% extra por depósito
        saldo += monto + bonificacion;
    }
}
