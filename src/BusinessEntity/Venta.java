package BusinessEntity;

import java.time.LocalDate;

public class Venta {
    private int id;
    private int idCliente;
    private LocalDate fecha;
    private double total;

    // Constructor sin ID (para registrar nuevas ventas)
    public Venta(int idCliente, LocalDate fecha, double total) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.total = total;
    }

    // Constructor completo
    public Venta(int id, int idCliente, LocalDate fecha, double total) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
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

    public void setTotal(double total) {
        this.total = total;
    }
}
