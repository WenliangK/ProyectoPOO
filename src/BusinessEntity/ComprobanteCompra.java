package BusinessEntity;

import java.util.Date;

public class ComprobanteCompra {
    private int id;
    private Cliente cliente;
    private Producto producto;
    private Date fechaCompra;

    public ComprobanteCompra(int id, Cliente cliente, Producto producto, Date fechaCompra) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.fechaCompra = fechaCompra;
    }

    // Getters y Setters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Producto getProducto() { return producto; }
    public Date getFechaCompra() { return fechaCompra; }

    public void setId(int id) { this.id = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public void setFechaCompra(Date fechaCompra) { this.fechaCompra = fechaCompra; }
}