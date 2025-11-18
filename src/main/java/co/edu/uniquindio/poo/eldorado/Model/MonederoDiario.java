package co.edu.uniquindio.poo.eldorado.Model;

public class MonederoDiario extends Monedero {

    public MonederoDiario(String idMonedero, double saldo, Cuenta cuenta) {
        super(idMonedero, saldo, cuenta);
    }


    @Override
    public String getTipo() {
        return "Diario";
    }
}
