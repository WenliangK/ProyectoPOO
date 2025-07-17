package view;

import dao.ProductoDAO;
import dao.CategoriaDAO;
import BusinessEntity.Categoria;
import BusinessEntity.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelProducto extends JPanel {

    private JTextField txtNombre, txtPrecio, txtStock;
    private JComboBox<Categoria> cbCategoria;
    private JTextArea areaListado;

    private final ProductoDAO productoDAO = new ProductoDAO();
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    public PanelProducto() {
        setLayout(new BorderLayout());

        // Formulario de ingreso
        JPanel formulario = new JPanel(new GridLayout(6, 2));

        formulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        formulario.add(txtNombre);

        formulario.add(new JLabel("Categoría:"));
        cbCategoria = new JComboBox<>();
        cargarCategorias();
        formulario.add(cbCategoria);

        formulario.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        formulario.add(txtPrecio);

        formulario.add(new JLabel("Stock:"));
        txtStock = new JTextField();
        formulario.add(txtStock);

        JButton btnAgregar = new JButton("Agregar producto");
        btnAgregar.addActionListener(e -> agregarProducto());
        formulario.add(btnAgregar);

        JButton btnListar = new JButton("Listar productos");
        btnListar.addActionListener(e -> listarProductos());
        formulario.add(btnListar);

        // Área de listado
        areaListado = new JTextArea();
        areaListado.setEditable(false);

        add(formulario, BorderLayout.NORTH);
        add(new JScrollPane(areaListado), BorderLayout.CENTER);
    }

    private void cargarCategorias() {
        List<Categoria> categorias = categoriaDAO.obtenerTodas();  // método estándar
        for (Categoria c : categorias) {
            cbCategoria.addItem(c);
        }
    }

    private void agregarProducto() {
        try {
            String nombre = txtNombre.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int stock = Integer.parseInt(txtStock.getText().trim());
            Categoria categoria = (Categoria) cbCategoria.getSelectedItem();

            if (categoria == null) throw new Exception("Debe seleccionar una categoría");

            Producto nuevo = new Producto(nombre, precio, stock, categoria.getId());  // constructor compatible con DAO
            productoDAO.insertar(nuevo);  // método estándar del DAO

            JOptionPane.showMessageDialog(this, "✅ Producto agregado correctamente.");
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "⚠️ Precio o stock inválidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
        }
    }

    private void listarProductos() {
        List<Producto> productos = productoDAO.obtenerTodos();  // método estándar del DAO
        StringBuilder sb = new StringBuilder();

        for (Producto p : productos) {
            sb.append(p.getId()).append(" - ")
                    .append(p.getNombre()).append(" - S/. ")
                    .append(p.getPrecio()).append(" - Stock: ")
                    .append(p.getStock()).append("\n");
        }

        areaListado.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        cbCategoria.setSelectedIndex(0);
    }
}
