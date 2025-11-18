package co.edu.uniquindio.poo.eldorado.Model;

import java.time.LocalDate;

public class TransaccionProgramada {
    private Transaccion transaccion;
    private LocalDate fechaEjecucion;
    private boolean ejecutada;

    public TransaccionProgramada(Transaccion transaccion, LocalDate fechaEjecucion) {
        this.transaccion = transaccion;
        this.fechaEjecucion = fechaEjecucion;
        this.ejecutada = false;
    }

    public void ejecutarSiCorresponde(LocalDate hoy) {
        if (!ejecutada && !hoy.isBefore(fechaEjecucion)) {
            transaccion.ejecutar();
            ejecutada = true;
        }
    }

    public LocalDate getFechaEjecucion() { return fechaEjecucion; }
    public boolean getEjecutada(){return ejecutada;}
}