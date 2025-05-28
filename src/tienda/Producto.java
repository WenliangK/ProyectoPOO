package tienda;


public class Producto {

    private int id;

    private String nombre;

    private Categoria categoria;

    private double precio;

    private int stock;


    public Producto(int id, String nombre, Categoria categoria, double precio, int stock) {

        this.id = id;

        this.nombre = nombre;

        this.categoria = categoria;

        this.precio = precio;

        this.stock = stock;

    }

    public int getId() {
 return id;
 }
    public String getNombre() {
 return nombre;
 }
    public Categoria getCategoria() {
 return categoria;
 }
    public double getPrecio() {
 return precio;
 }
    public int getStock() {
 return stock;
 }

    public void setId(int id) {
 this.id = id;
 }
    public void setNombre(String nombre) {
 this.nombre = nombre;
 }
    public void setCategoria(Categoria categoria) {
 this.categoria = categoria;
 }
    public void setPrecio(double precio) {
 this.precio = precio;
 }
    public void setStock(int stock) {
 this.stock = stock;
 }
}