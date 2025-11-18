package co.edu.uniquindio.poo.eldorado.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ElDorado {
    private String nombre;
    private static List<Usuario> listaUsuarios;
    private List<Cuenta> listaCuentas;
    private List<TransaccionProgramada> listaTransaccionProgramadas;

    public ElDorado(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
        this.listaUsuarios = new LinkedList<>();
        this.listaCuentas = new LinkedList<>();
        this.listaTransaccionProgramadas = new LinkedList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        listaUsuarios.add(usuario);
    }

    public void registrarCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula");
        }
        listaCuentas.add(cuenta);
    }

    public static Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }
    public  Usuario buscarUsuarioPorEmail(String email){
        return listaUsuarios.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    public Cuenta buscarCuentaPorId(String id) {
        for (Cuenta c : listaCuentas) {
            if (c.getIdCuenta().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public  static List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public void agregarTransaccionProgramada(TransaccionProgramada transaccionProgramada) {
  listaTransaccionProgramadas.add(transaccionProgramada);
    }

    public List<TransaccionProgramada> getListaTransaccionProgramadas() {
        return listaTransaccionProgramadas;
    }

    public void setListaTransaccionProgramadas(List<TransaccionProgramada> listaTransaccionProgramadas) {
        this.listaTransaccionProgramadas = listaTransaccionProgramadas;
    }
}
