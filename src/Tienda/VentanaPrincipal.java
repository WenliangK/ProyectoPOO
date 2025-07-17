package Tienda;

import view.PanelProducto;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("🛍️ Sistema Tienda Hiraoka");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Crear pestañas
        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("🛒 Productos", new PanelProducto());

        // Puedes agregar más paneles si ya los tienes listos:
        // tabs.addTab("Clientes", new PanelCliente());
        // tabs.addTab("Ventas", new PanelVenta());

        add(tabs);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
