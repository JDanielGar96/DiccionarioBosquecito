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

/**
 * Es el panel que se mostrara en la ventana princial para que el usuario pueda
 * agregar palabras a los diferentes diccionarios.
 * 
 * @author Oscar Romero y Daniel Garcia
 *
 */
public class PanelDePalabras extends JPanel {

	private JLabel tituloAgregarPalabras; // Titulo intuitivo del panel para el usuario
	private JLabel palabraEspanol; // Titulo de la palabra en espanol
	private JLabel palabraTraducida; // Titulo de la palabra traducida
	private JLabel idiomaTraduccion; // Titulo del idioma de la palabra traducida

	private JTextField palabraSpa; // Campo de texto donde el usuario colocara la palabra en espanol
	private JTextField palabraTradu; // Campo de texto donde el usuario colocara la palabra traducida

	private JComboBox<String> comboBoxIdioma; // Caja de texto que permite al usuario elegir el idioma de la palabra
												// traducida
	private JButton botonLimpiar; // Boton que limpia el panel
	private JButton botonAgregar; // Boton que agrega la palabra traducida

	public PanelDePalabras() {
		// Inicializa las variables de la clase
		tituloAgregarPalabras = new JLabel("Agregar palabras.");
		palabraEspanol = new JLabel("Palabra (ESP)");
		palabraTraducida = new JLabel("Palabra traducida");
		idiomaTraduccion = new JLabel("Idioma Traduccion");

		palabraSpa = new JTextField();
		palabraTradu = new JTextField();

		comboBoxIdioma = new JComboBox<String>();
		comboBoxIdioma.addItem("FRA");
		comboBoxIdioma.addItem("ENG");
		comboBoxIdioma.addItem("ITA");

		botonAgregar = new JButton("Agregar");
		botonLimpiar = new JButton("Limpiar");

		// Agrega las variables a la clase
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

	public JTextField getPalabraTradu() {
		return palabraTradu;
	}

	public JComboBox<String> getComboBoxIdioma() {
		return comboBoxIdioma;
	}

	public JButton getBotonLimpiar() {
		return botonLimpiar;
	}

	public JButton getBotonAgregar() {
		return botonAgregar;
	}

}
