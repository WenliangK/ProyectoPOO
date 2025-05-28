package tienda;

import javax.swing.*;
import java.awt.*;

public class PanelHistorial extends JPanel {
    public PanelHistorial() {
        setLayout(new BorderLayout());
        JTextArea historial = new JTextArea("Aquí se mostraría el historial de tickets del cliente.");
        add(new JScrollPane(historial), BorderLayout.CENTER);
    }
}