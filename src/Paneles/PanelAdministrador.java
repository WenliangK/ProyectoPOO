package Paneles;

import javax.swing.*;
import java.awt.*;

public class PanelAdministrador extends JPanel {
    public PanelAdministrador() {
        setLayout(new BorderLayout());
        JTabbedPane adminTabs = new JTabbedPane();
        adminTabs.addTab("Tickets Pendientes", new JTextArea("Lista de tickets pendientes..."));
        adminTabs.addTab("Visitas Programadas", new JTextArea("Lista de visitas programadas..."));
        adminTabs.addTab("Historial de Tickets", new JTextArea("Historial completo de tickets..."));
        add(adminTabs, BorderLayout.CENTER);
    }
}