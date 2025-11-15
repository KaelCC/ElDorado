package co.edu.uniquindio.poo.eldorado.Model;

import java.util.ArrayList;
import java.util.List;

public class ElDorado {
    private String nombre;
    private List<Usuario> listaUsuarios;
    private List<Cuenta> listaCuentas;

    public ElDorado(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
        this.listaUsuarios = new ArrayList<>();
        this.listaCuentas = new ArrayList<>();
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

    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }
    public Usuario buscarUsuarioPorEmail(String email){
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

    public List<Usuario> getListaUsuarios() {
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
}
