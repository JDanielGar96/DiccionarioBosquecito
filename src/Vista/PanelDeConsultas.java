package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PanelDeConsultas extends JPanel {

	private JLabel tituloConsulta;
	private JLabel palabra;
	private JLabel traduccion;
	private JLabel idiomaOrigen;
	private JLabel idiomaDestino;

	private JTextField textPalabra;
	private JTextField textTraduccion;

	private JComboBox<?> comboBoxOrigen;
	private JComboBox<?> comboBoxDestino;

	private JButton botonTraducir;
	private JButton botonLimpiar;

	private String[] opcionesTraduccion;

	public PanelDeConsultas() {
		// Inicializacion de variables
		opcionesTraduccion = new String[4];
		opcionesTraduccion[0] = "ESP";
		opcionesTraduccion[1] = "FRA";
		opcionesTraduccion[2] = "ENG";
		opcionesTraduccion[3] = "ITA";

		tituloConsulta = new JLabel("Consulta de traducciones.");
		palabra = new JLabel("Palabra");
		traduccion = new JLabel("Traduccion");
		idiomaOrigen = new JLabel("Idioma Origen");
		idiomaDestino = new JLabel("Idioma Destino");

		textPalabra = new JTextField();
		textTraduccion = new JTextField();
		textTraduccion.setEditable(false);

		comboBoxOrigen = new JComboBox<Object>(opcionesTraduccion);
		comboBoxDestino = new JComboBox<Object>(opcionesTraduccion);

		botonTraducir = new JButton("Traducir");
		botonLimpiar = new JButton("Limpiar");

		// Agregar variables al panel

		add(tituloConsulta);
		add(palabra);
		add(traduccion);
		add(idiomaOrigen);
		add(idiomaDestino);
		add(textPalabra);
		add(textTraduccion);
		add(comboBoxOrigen);
		add(comboBoxDestino);
		add(botonTraducir);
		add(botonLimpiar);

		Initialize();
		setVisible(true);
	}

	private void Initialize() {
		setBounds(10, 210, 525, 250);
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		// Labels o Etiquetas
		tituloConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		tituloConsulta.setForeground(Color.LIGHT_GRAY);
		tituloConsulta.setFont(new Font("Tahoma", Font.BOLD, 15));
		tituloConsulta.setBounds(10, 11, 505, 23);

		palabra.setForeground(Color.WHITE);
		palabra.setHorizontalAlignment(SwingConstants.CENTER);
		palabra.setFont(new Font("Tahoma", Font.BOLD, 15));
		palabra.setBounds(10, 155, 157, 23);

		traduccion.setForeground(Color.WHITE);
		traduccion.setHorizontalAlignment(SwingConstants.CENTER);
		traduccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		traduccion.setBounds(186, 155, 157, 23);

		idiomaOrigen.setForeground(Color.WHITE);
		idiomaOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		idiomaOrigen.setFont(new Font("Tahoma", Font.BOLD, 15));
		idiomaOrigen.setBounds(10, 60, 157, 23);

		// Cuadros de texto
		idiomaDestino.setForeground(Color.WHITE);
		idiomaDestino.setHorizontalAlignment(SwingConstants.CENTER);
		idiomaDestino.setFont(new Font("Tahoma", Font.BOLD, 15));
		idiomaDestino.setBounds(186, 60, 157, 23);

		textPalabra.setColumns(10);
		textPalabra.setBounds(10, 189, 157, 50);

		textTraduccion.setColumns(10);
		textTraduccion.setBounds(186, 189, 157, 50);

		// Cajas de opciones desplegables
		comboBoxOrigen.setBounds(10, 94, 157, 50);
		comboBoxDestino.setBounds(186, 94, 157, 50);

		// Botones
		botonTraducir.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonTraducir.setBounds(363, 94, 152, 50);

		botonLimpiar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonLimpiar.setBounds(363, 189, 152, 50);
	}	

	public JButton getBotonTraducir() {
		return botonTraducir;
	}

	public void setBotonTraducir(JButton botonTraducir) {
		this.botonTraducir = botonTraducir;
	}

	public JButton getBotonLimpiar() {
		return botonLimpiar;
	}

	public void setBotonLimpiar(JButton botonLimpiar) {
		this.botonLimpiar = botonLimpiar;
	}

	public JTextField getTextPalabra() {
		return textPalabra;
	}

	public void setTextPalabra(JTextField textPalabra) {
		this.textPalabra = textPalabra;
	}

	public JTextField getTextTraduccion() {
		return textTraduccion;
	}

	public void setTextTraduccion(JTextField textTraduccion) {
		this.textTraduccion = textTraduccion;
	}

	public JComboBox<?> getComboBoxOrigen() {
		return comboBoxOrigen;
	}

	public void setComboBoxOrigen(JComboBox<?> comboBoxOrigen) {
		this.comboBoxOrigen = comboBoxOrigen;
	}

	public JComboBox<?> getComboBoxDestino() {
		return comboBoxDestino;
	}

	public void setComboBoxDestino(JComboBox<?> comboBoxDestino) {
		this.comboBoxDestino = comboBoxDestino;
	}
	
	
}
