package co.edu.uniquindio.poo.eldorado.Model;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    private Usuario propietario;
    private String idCuenta;
    private List<Monedero> listaMonederos;
    private int puntos;
    private Rango rango;


    public Cuenta(String idCuenta, Usuario propietario, int puntosIniciales) {
        if (propietario == null || idCuenta == null || idCuenta.isEmpty() || puntosIniciales < 0) {
            throw new IllegalArgumentException("Datos inválidos para la cuenta");
        }

        this.idCuenta = idCuenta;
        this.propietario = propietario;
        this.listaMonederos = new ArrayList<>();
        this.puntos = puntosIniciales;
        this.rango = Rango.BRONCE; // ✅ Inicializa con un rango por defecto
    }


    public void agregarMonedero(Monedero monedero) {
        if (monedero == null) {
            throw new IllegalArgumentException("El monedero no puede ser nulo");
        }
        listaMonederos.add(monedero);
    }


    public void actualizarRango() {
        if (puntos <= 500) {
            rango = Rango.BRONCE;
        } else if (puntos <= 1000) {
            rango = Rango.PLATA;
        } else if (puntos <= 5000) {
            rango = Rango.ORO;
        } else {
            rango = Rango.PLATINO;
        }
    }


    public void agregarPuntos(int puntosGanados) {
        if (puntosGanados < 0) {
            throw new IllegalArgumentException("Los puntos no pueden ser negativos");
        }
        this.puntos += puntosGanados;
        actualizarRango();
    }


    public void canjearPuntos(int puntosUsados) {
        if (puntosUsados < 0 || puntosUsados > puntos) {
            throw new IllegalArgumentException("Cantidad de puntos no válida");
        }
        this.puntos -= puntosUsados;
        actualizarRango();
    }

    public Rango getRango() {
        return rango;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public List<Monedero> getListaMonederos() {
        return listaMonederos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
        actualizarRango();
    }
    public String generarIdMonedero() {
        int cantidad = listaMonederos.size() + 1;
        return "MON-" + cantidad;
    }
}
