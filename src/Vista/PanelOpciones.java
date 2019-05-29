package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PanelOpciones extends JPanel {

	/**
	 * Esta clase se encarga de generar un panel que sera agregado a la ventana
	 * principal, donde el usuario podra cargar diccionarios y ademas ver las
	 * traducciones frecuentes
	 */
	private static final long serialVersionUID = 1L;
	private JLabel tituloOpciones; // Titulo intuitivo para el usuario
	private JButton botonCargar; // Sera el boton que permita cargar los diccionarios
	private JButton botonFrecuencia; // Sera el boton que cargara las traducciones mas comunes

	public PanelOpciones() {
		// Se inicializan las variables de la clase
		tituloOpciones = new JLabel("Opciones");
		botonCargar = new JButton("Cargar Diccionario");
		botonFrecuencia = new JButton("Traducciones Frecuentes");

		// Se agregan las variables a la clase
		add(tituloOpciones);
		add(botonCargar);
		add(botonFrecuencia);

		Initialize();
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

		botonFrecuencia.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonFrecuencia.setBounds(10, 155, 249, 50);

		setVisible(true);
	}

	public JButton getBotonCargar() {
		return botonCargar;
	}

	public void setBotonCargar(JButton botonCargar) {
		this.botonCargar = botonCargar;
	}

	public JButton getBotonFrecuencia() {
		return botonFrecuencia;
	}

	public void setBotonFrecuencia(JButton botonFrecuencia) {
		this.botonFrecuencia = botonFrecuencia;
	}

}
