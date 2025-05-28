package tienda;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("Sistema Tienda Hiraoka");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Productos", new PanelProducto());
        tabs.addTab("Generar Ticket", new PanelGenerarTicket());
        tabs.addTab("Historial", new PanelHistorial());
        tabs.addTab("Agendar Visita", new PanelAgendarVisita());
        tabs.addTab("Administración", new PanelAdministrador());

        add(tabs);
    }
}