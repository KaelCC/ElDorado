package co.edu.uniquindio.poo.eldorado.Model;

public class MonederoDiario extends Monedero {

    public MonederoDiario(String idMonedero, double saldo, Cuenta cuenta) {
        super(idMonedero, saldo, cuenta);
    }


    @Override
    public void depositar(double monto) {

        if (monto > 200000) {
            throw new IllegalArgumentException("Límite diario de depósito excedido (máx 200000).");
        }
        super.depositar(monto);
    }

    @Override
    public void retirar(double monto) {

        if (monto < 1000) {
            throw new IllegalArgumentException("El monto mínimo de retiro es 1000.");
        }
        super.retirar(monto);
    }
    @Override
    public String getTipo() {
        return "Diario";
    }
}
