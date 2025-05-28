package tienda;

import java.util.Date;

public class TicketSoporte {
    private int id;
    private Cliente cliente;
    private Producto producto;
    private String descripcion;
    private String estado;
    private Date fechaRegistro;

    public TicketSoporte(int id, Cliente cliente, Producto producto, String descripcion, String estado, Date fechaRegistro) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Producto getProducto() { return producto; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    public Date getFechaRegistro() { return fechaRegistro; }

    public void setId(int id) { this.id = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}