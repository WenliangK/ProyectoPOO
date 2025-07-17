package view;

import javax.swing.*;
import java.awt.*;

public class PanelGenerarTicket extends JPanel {
    public PanelGenerarTicket() {
        setLayout(new GridLayout(5, 2));
        add(new JLabel("Cliente ID:"));
        add(new JTextField());
        add(new JLabel("Producto ID:"));
        add(new JTextField());
        add(new JLabel("Descripción:"));
        add(new JTextField());
        add(new JLabel("Estado:"));
        add(new JTextField());
        add(new JLabel("Fecha Registro:"));
        add(new JTextField());
    }
}