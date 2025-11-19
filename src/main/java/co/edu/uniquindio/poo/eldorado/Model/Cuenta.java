package co.edu.uniquindio.poo.eldorado.Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.edu.uniquindio.poo.eldorado.Model.Rango.*;

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
        this.rango = BRONCE; // ✅ Inicializa con un rango por defecto
    }


    public void agregarMonedero(Monedero monedero) {
        if (monedero == null) {
            throw new IllegalArgumentException("El monedero no puede ser nulo");
        }
        listaMonederos.add(monedero);
    }


    public void actualizarRango() {
        if (puntos <= 500 && puntos >0) {
            rango = BRONCE;
        } else if (puntos <= 1000 && puntos > 500) {
            rango = PLATA;
        } else if (puntos <= 5000 && puntos >1000) {
            rango = ORO;
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
    public class Recompensa {
        String nombre;
        public int costoPuntos;
        public Runnable accion; // lo que hace la recompensa

        Recompensa(String nombre, int costoPuntos, Runnable accion) {
            this.nombre = nombre;
            this.costoPuntos = costoPuntos;
            this.accion = accion;
        }
    }


    public List<Recompensa> getRecompensas() {
        List<Recompensa> lista = new ArrayList<>();

        switch (rango) {

            case BRONCE:
                lista.add(new Recompensa(
                        "Bono +$50",
                        100,
                        () -> agregarDineroAlMonedero(5000000)
                ));
                break;

            case PLATA:
                lista.add(new Recompensa(
                        "Bono +$100",
                        2000,
                        () -> agregarDineroAlMonedero(100000000)
                ));
                break;

            case ORO:
                lista.add(new Recompensa(
                        "Bono +$500",
                        4500,
                        () -> agregarDineroAlMonedero(500000000)
                ));
                break;

            case PLATINO:
                lista.add(new Recompensa(
                        "Bono +$1000",
                        10000,
                        () -> agregarDineroAlMonedero(900000000)
                ));
                break;
        }

        return lista;
    }

    private void agregarDinero(double cantidad) {
        System.out.println("Se agregaron $" + cantidad + " al usuario.");
    }
    public void agregarDineroAlMonedero(double cantidad) {
        if (listaMonederos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El usuario no tiene monederos .");
            return;
        }

        Monedero monedero = listaMonederos.get(0); // ← El primer monedero
        monedero.agregarDinero(cantidad);

        System.out.println("Se agregaron $" + cantidad + " al monedero " + monedero.getIdMonedero());
    }



}
