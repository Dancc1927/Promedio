package ventanaEmergente;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Ventana extends JFrame {

    private JTextField nota1Field;
    private JTextField nota2Field;
    private JTextField nota3Field;
    private JLabel resultadoLabel;
	private JTextField nombreField;
	private Object scrollpanel;

    public Ventana() {
    
        setTitle("Calculadora de Promedio");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Configurar el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2));
        panel.setBackground(Color.pink);
        
         
        nombreField = new JTextField("ingrese su nombre");
        // Crear y agregar los componentes
        JLabel nota1Label = new JLabel("Nota 1:");
        nota1Field = new JTextField();

        JLabel nota2Label = new JLabel("Nota 2:");
        nota2Field = new JTextField();

        JLabel nota3Label = new JLabel("Nota 3:");
        
        nota3Field = new JTextField();

JButton calcularButton = new JButton("Calcular Promedio");
        calcularButton.addActionListener(new CalcularPromedioListener());
        panel.add(nombreField);
        
        
        resultadoLabel = new JLabel("Promedio: ");
         
        panel.add(nota1Label);
        panel.add(nota1Field);
        panel.add(nota2Label);
        panel.add(nota2Field);
        panel.add(nota3Label);
        panel.add(nota3Field);
        panel.add(new JLabel("")); // Espacio vacío
        panel.add(calcularButton);
        panel.add(new JLabel("")); // Espacio vacío
        panel.add(resultadoLabel);
        
        add(panel);
    }

    private class CalcularPromedioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double nota1 = Double.parseDouble(nota1Field.getText());
                double nota2 = Double.parseDouble(nota2Field.getText());
                double nota3 = Double.parseDouble(nota3Field.getText());

                double promedio = (nota1 + nota2 + nota3) / 3;

                resultadoLabel.setText(String.format("Promedio: %.2f", promedio));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ventana frame = new Ventana();
            frame.setVisible(true);
        });
    }}