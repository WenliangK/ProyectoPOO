package tienda;

import javax.swing.*;

import java.awt.*;

import java.util.ArrayList;


public class PanelProducto extends JPanel {

    private JTextField txtNombre, txtPrecio, txtStock;

    private JComboBox<Categoria> cbCategoria;

    private JTextArea areaListado;

    private ProductoDAO dao = new ProductoDAO();

    private CategoriaDAO categoriaDAO = new CategoriaDAO();


    public PanelProducto() {

        setLayout(new BorderLayout());


        JPanel formulario = new JPanel(new GridLayout(5, 2));

        formulario.add(new JLabel("Nombre:"));

        txtNombre = new JTextField();

        formulario.add(txtNombre);


        formulario.add(new JLabel("Categoría:"));

        cbCategoria = new JComboBox<>();

        for (Categoria c : categoriaDAO.obtenerCategorias()) {

            cbCategoria.addItem(c);

        }
        formulario.add(cbCategoria);


        formulario.add(new JLabel("Precio:"));

        txtPrecio = new JTextField();

        formulario.add(txtPrecio);


        formulario.add(new JLabel("Stock:"));

        txtStock = new JTextField();

        formulario.add(txtStock);


        JButton btnAgregar = new JButton("Agregar");

        btnAgregar.addActionListener(e -> agregarProducto());

        formulario.add(btnAgregar);


        JButton btnListar = new JButton("Listar");

        btnListar.addActionListener(e -> listarProductos());

        formulario.add(btnListar);


        areaListado = new JTextArea();

        areaListado.setEditable(false);


        add(formulario, BorderLayout.NORTH);

        add(new JScrollPane(areaListado), BorderLayout.CENTER);

    }

    private void agregarProducto() {

        try {

            String nombre = txtNombre.getText();

            Categoria cat = (Categoria) cbCategoria.getSelectedItem();

            double precio = Double.parseDouble(txtPrecio.getText());

            int stock = Integer.parseInt(txtStock.getText());


            Producto p = new Producto(0, nombre, cat, precio, stock);

            dao.insertarProducto(p);

            JOptionPane.showMessageDialog(this, "Producto agregado.");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());

        }
    }

    private void listarProductos() {

        ArrayList<Producto> productos = dao.listarProductos();

        StringBuilder sb = new StringBuilder();

        for (Producto p : productos) {

            sb.append(p.getId()).append(" - ").append(p.getNombre())
              .append(" (").append(p.getCategoria().getNombre()).append(") - S/.")
              .append(p.getPrecio()).append(" - Stock: ").append(p.getStock()).append("\n");

        }
        areaListado.setText(sb.toString());

    }
}