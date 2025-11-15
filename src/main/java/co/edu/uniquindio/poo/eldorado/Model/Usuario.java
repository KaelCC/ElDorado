package co.edu.uniquindio.poo.eldorado.Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private String telefono;
    private String cedula;
    private String password;
    private List<Cuenta> listaCuentas;

    public Usuario(String nombre, String apellido, String email, String telefono, String cedula, int edad, String password) {
        if (nombre == null || nombre.isBlank() ||
                apellido == null || apellido.isBlank() ||
                email == null || email.isBlank() || !email.contains("@") ||
                telefono == null || telefono.isBlank() ||
                cedula == null || cedula.isBlank() ||
                edad < 18 || password==null || password.isBlank())  {
            throw new IllegalArgumentException("Datos inválidos o insuficientes para la creación del usuario");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.cedula = cedula;
        this.edad = edad;
        this.password = password;
        this.listaCuentas = new ArrayList<>();
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El apellido no puede ser vacío");
        }
        this.apellido = apellido;
    }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("El usuario debe ser mayor de edad");
        }
        this.edad = edad;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede ser vacío");
        }
        this.email = email;
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede ser vacío");
        }
        this.telefono = telefono;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) {
        if (cedula == null || cedula.isBlank()) {
            throw new IllegalArgumentException("La cédula no puede ser vacía");
        }
        this.cedula = cedula;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }


    public void agregarCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula");
        }
        listaCuentas.add(cuenta);
    }

    public Cuenta buscarCuentaPorId(String idCuenta) {
        for (Cuenta c : listaCuentas) {
            if (c.getIdCuenta().equals(idCuenta)) {
                return c;
            }
        }
        return null;
    }
}
