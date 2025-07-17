package BusinessEntity;

public class TicketSoporte {
    private int id;
    private String descripcion;
    private String estado;
    private String fechaRegistro;
    private int clienteId;
    private int empleadoId;

    // Constructor con ID (para listar, obtener)
    public TicketSoporte(int id, String descripcion, String estado, String fechaRegistro, int clienteId, int empleadoId) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.clienteId = clienteId;
        this.empleadoId = empleadoId;
    }

    // Constructor sin ID (para insertar)
    public TicketSoporte(String descripcion, String estado, String fechaRegistro, int clienteId, int empleadoId) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.clienteId = clienteId;
        this.empleadoId = empleadoId;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    // Setters (opcional, pero útiles)
    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Override
    public String toString() {
        return "TicketSoporte{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", clienteId=" + clienteId +
                ", empleadoId=" + empleadoId +
                '}';
    }
}
