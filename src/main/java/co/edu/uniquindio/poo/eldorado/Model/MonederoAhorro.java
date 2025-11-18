package co.edu.uniquindio.poo.eldorado.Model;

public class MonederoAhorro extends Monedero {

    public MonederoAhorro(String idMonedero, double saldo, Cuenta cuenta) {
        super(idMonedero, saldo, cuenta);
    }

@Override
public String getTipo(){
        return "ahorro";
}

}
