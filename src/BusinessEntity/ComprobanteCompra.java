package BusinessEntity;

public class ComprobanteCompra {
    private int id;
    private String fecha;
    private double montoTotal;

    // Constructor sin ID (para insertar)
    public ComprobanteCompra(String fecha, double montoTotal) {
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    // Constructor con ID (para leer desde la BD)
    public ComprobanteCompra(int id, String fecha, double montoTotal) {
        this.id = id;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "ComprobanteCompra{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", montoTotal=" + montoTotal +
                '}';
    }
}
