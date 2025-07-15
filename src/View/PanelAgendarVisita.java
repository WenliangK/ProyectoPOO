package View;

import javax.swing.*;
import java.awt.*;

public class PanelAgendarVisita extends JPanel {
    public PanelAgendarVisita() {
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Cliente ID:"));
        add(new JTextField());
        add(new JLabel("Fecha de visita:"));
        add(new JTextField());
        add(new JLabel("Hora:"));
        add(new JTextField());
        add(new JLabel("Técnico asignado:"));
        add(new JTextField());
    }
}