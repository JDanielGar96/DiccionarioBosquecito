package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PanelOpciones extends JPanel {

	private JLabel tituloOpciones;
	private JButton botonCargar;
	private JButton boton;

	public PanelOpciones() {
		// Inicializo variables
		tituloOpciones = new JLabel("Opciones");
		botonCargar = new JButton("Cargar Diccionarios");
		boton = new JButton("Palabras Frecuentes");

		// Agrego variables al panel
		add(tituloOpciones);
		add(botonCargar);
		add(boton);

		Initialize();
		setVisible(true);
	}

	private void Initialize() {
		setBackground(Color.GRAY);
		setBounds(915, 210, 269, 250);
		setLayout(null);

		// Labels o etiquetas
		tituloOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		tituloOpciones.setForeground(Color.YELLOW);
		tituloOpciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		tituloOpciones.setBounds(10, 11, 249, 30);

		// Botones
		botonCargar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonCargar.setBounds(10, 80, 249, 50);

		boton.setFont(new Font("Tahoma", Font.BOLD, 15));
		boton.setBounds(10, 155, 249, 50);
	}

	public JButton getBotonCargar() {
		return botonCargar;
	}

	public void setBotonCargar(JButton botonCargar) {
		this.botonCargar = botonCargar;
	}

	public JButton getBoton() {
		return boton;
	}

	public void setBoton(JButton boton) {
		this.boton = boton;
	}

}
