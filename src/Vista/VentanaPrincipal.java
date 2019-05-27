package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.Control;

public class VentanaPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	
	private CargarDiccionario diccionario;
	private PanelDeImagen panelImagen;
	private PanelDeConsultas panelConsulta;
	private PanelDePalabras panelPalabras;
	private PanelCantidad panelCantidad;
	private PanelOpciones panelOps;

	private Control control;

	public VentanaPrincipal(Control c) {
		// Inicializo los paneles de la ventana principal
		panelImagen = new PanelDeImagen();
		panelConsulta = new PanelDeConsultas();
		panelPalabras = new PanelDePalabras();
		panelCantidad = new PanelCantidad();
		panelOps = new PanelOpciones();

		control = c;

		// Agrego el contenido de los paneles a la ventana principal
		getContentPane().add(panelImagen);
		getContentPane().add(panelConsulta);
		getContentPane().add(panelPalabras);
		getContentPane().add(panelCantidad);
		getContentPane().add(panelOps);

		Initialize();
		setVisible(true);
	}

	private void Initialize() {

		setTitle("Diccionario - Traductor");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Assets/Logo.png"));
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(1200, 500);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Agrego escuchadores a los botones
		panelConsulta.getBotonTraducir().addActionListener(this);
		panelConsulta.getBotonLimpiar().addActionListener(this);

		panelPalabras.getBotonAgregar().addActionListener(this);
		panelPalabras.getBotonLimpiar().addActionListener(this);

		panelOps.getBotonCargar().addActionListener(this);
		panelOps.getBotonFrecuencia().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comandoDeAccion = e.getActionCommand();

		try {
			// Panel De Consultas
			if (comandoDeAccion.equalsIgnoreCase("Limpiar")) {
				panelConsulta.getTextPalabra().setText("");
				panelConsulta.getTextTraduccion().setText("");
			}

			if (comandoDeAccion.equalsIgnoreCase("Traducir")) {

				String palabra = panelConsulta.getTextPalabra().getText();
				String idiomaOrigen = panelConsulta.getComboBoxOrigen().getSelectedItem().toString();
				
				String idiomaDestino = panelConsulta.getComboBoxDestino().getSelectedItem().toString();

				if (idiomaOrigen.equalsIgnoreCase(idiomaDestino)) {
					JOptionPane.showMessageDialog(this, "No se puede traducir al mismo idioma. :V");
				}
				
				panelConsulta.getTextTraduccion().setText(control.buscarTraduccion(palabra, idiomaOrigen, idiomaDestino));
			}

			// Panel De Palabras
			if (comandoDeAccion.equalsIgnoreCase("Agregar")) {

				String palabraNueva = panelPalabras.getPalabraSpa().getText();
				String palabraNuevaTrad = panelPalabras.getPalabraTradu().getText();
				String idioma = panelPalabras.getComboBoxIdioma().getSelectedItem().toString();

				try {
					control.agregarPalabra(palabraNueva, palabraNuevaTrad, idioma);
					JOptionPane.showMessageDialog(this, "La palabra fue agregada");
				} catch (Exception excepcion) {
					this.mostrarError();
				}
			}

			if (comandoDeAccion.equalsIgnoreCase("Limpiar") && e.getSource().equals(panelPalabras.getBotonLimpiar())) {
				panelPalabras.getPalabraSpa().setText("");
				panelPalabras.getPalabraTradu().setText("");
			}
			// Panel De Opciones
			if (comandoDeAccion.equalsIgnoreCase("Cargar Diccionario")) {
				diccionario = new CargarDiccionario();
				
				diccionario.getBtnEng().addActionListener(this);
				diccionario.getBtnFra().addActionListener(this);
				diccionario.getBtnIta().addActionListener(this);
			}

			if (comandoDeAccion.equalsIgnoreCase("Palabras Frecuentes")) {
				control.frecuentes();
			}
			if (comandoDeAccion.equalsIgnoreCase("ENG")) {
				control.agregarDiccionario("ENG");
				diccionario.dispose();
			}
			if (comandoDeAccion.equalsIgnoreCase("FRA")) {
				control.agregarDiccionario("FRA");
				diccionario.dispose();
			}
			if (comandoDeAccion.equalsIgnoreCase("ITA")) {
				control.agregarDiccionario("ITA");
				diccionario.dispose();	
			}
			// Panel cantidad

		} catch (NumberFormatException ex) {
			mostrarError();
			ex.printStackTrace();
		}
	}

	public void mostrarError() {
		JOptionPane.showMessageDialog(null, "Lo siento, ha ocurrido un error.");
	}
}