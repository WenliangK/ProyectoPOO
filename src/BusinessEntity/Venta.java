package BusinessEntity;

import java.time.LocalDate;

public class Venta {
    private int id;
    private int idCliente;
    private LocalDate fecha;
    private double montoTotal;

    public Venta(int idCliente, LocalDate fecha, double montoTotal) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    public Venta(int id, int idCliente, LocalDate fecha, double montoTotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "Venta ID: " + id + ", Cliente ID: " + idCliente + ", Fecha: " + fecha + ", Total: S/. " + montoTotal;
    }
}
