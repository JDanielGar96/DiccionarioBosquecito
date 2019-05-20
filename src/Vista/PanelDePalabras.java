package Vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PanelDePalabras extends JPanel {

	private JLabel tituloAgregarPalabras;
	private JLabel palabraEspanol;
	private JLabel palabraTraducida;
	private JLabel idiomaTraduccion;

	private JTextField palabraSpa;
	private JTextField palabraTradu;

	private JComboBox<String> comboBoxIdioma;

	private JButton botonLimpiar;
	private JButton botonAgregar;

	public PanelDePalabras() {
		// Inicializo variables
		tituloAgregarPalabras = new JLabel("Agregar palabras.");
		palabraEspanol = new JLabel("Palabra (ESP)");
		palabraTraducida = new JLabel("Palabra traducida");
		idiomaTraduccion = new JLabel("Idioma Traduccion");

		palabraSpa = new JTextField();
		palabraTradu = new JTextField();

		comboBoxIdioma = new JComboBox<String>();
		comboBoxIdioma.addItem("FR");
		comboBoxIdioma.addItem("ING");
		comboBoxIdioma.addItem("ITA");

		botonAgregar = new JButton("Agregar");
		botonLimpiar = new JButton("Limpiar");

		// Agrego variables al panel
		add(tituloAgregarPalabras);
		add(palabraEspanol);
		add(palabraTraducida);
		add(idiomaTraduccion);
		add(palabraSpa);
		add(palabraTradu);
		add(comboBoxIdioma);
		add(botonAgregar);
		add(botonLimpiar);

		Initialize();
		setVisible(true);

	}

	private void Initialize() {
		setBounds(545, 210, 360, 250);
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		// Labels o Etiquetas
		tituloAgregarPalabras.setHorizontalAlignment(SwingConstants.LEFT);
		tituloAgregarPalabras.setForeground(Color.LIGHT_GRAY);
		tituloAgregarPalabras.setFont(new Font("Tahoma", Font.BOLD, 15));
		tituloAgregarPalabras.setBounds(10, 11, 333, 23);

		palabraEspanol.setHorizontalAlignment(SwingConstants.CENTER);
		palabraEspanol.setForeground(Color.WHITE);
		palabraEspanol.setFont(new Font("Tahoma", Font.BOLD, 15));
		palabraEspanol.setBounds(10, 64, 157, 23);

		palabraTraducida.setHorizontalAlignment(SwingConstants.CENTER);
		palabraTraducida.setForeground(Color.WHITE);
		palabraTraducida.setFont(new Font("Tahoma", Font.BOLD, 15));
		palabraTraducida.setBounds(186, 64, 157, 23);

		idiomaTraduccion.setHorizontalAlignment(SwingConstants.CENTER);
		idiomaTraduccion.setForeground(Color.WHITE);
		idiomaTraduccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		idiomaTraduccion.setBounds(10, 159, 157, 23);

		// Cuadros de texto
		palabraSpa.setColumns(10);
		palabraSpa.setBounds(10, 98, 157, 50);

		palabraTradu.setColumns(10);
		palabraTradu.setBounds(186, 98, 164, 50);

		// Caja de opciones desplegables
		comboBoxIdioma.setBounds(10, 189, 157, 50);

		// Botones
		botonAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonAgregar.setBounds(186, 189, 164, 22);

		botonLimpiar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonLimpiar.setBounds(186, 217, 164, 22);

	}

	public JTextField getPalabraSpa() {
		return palabraSpa;
	}

	public void setPalabraSpa(JTextField palabraSpa) {
		this.palabraSpa = palabraSpa;
	}

	public JTextField getPalabraTradu() {
		return palabraTradu;
	}

	public void setPalabraTradu(JTextField palabraTradu) {
		this.palabraTradu = palabraTradu;
	}

	public JComboBox<String> getComboBoxIdioma() {
		return comboBoxIdioma;
	}

	public void setComboBoxIdioma(JComboBox<String> comboBoxIdioma) {
		this.comboBoxIdioma = comboBoxIdioma;
	}

	public JButton getBotonLimpiar() {
		return botonLimpiar;
	}

	public void setBotonLimpiar(JButton botonLimpiar) {
		this.botonLimpiar = botonLimpiar;
	}

	public JButton getBotonAgregar() {
		return botonAgregar;
	}

	public void setBotonAgregar(JButton botonAgregar) {
		this.botonAgregar = botonAgregar;
	}

}
