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
	 * Esta clase es la ventana principal de la vista la cual ser� vista todo el
	 * tiempo por el usuario. Creando objetos de los paneles que estan contenidos
	 * dentro de la misma y un objeto de la clase controlador. Implementando un
	 * escuchador y un metodo de acciones realizadas por el usuario.
	 * 
	 * @author Oscar Romero y Daniel Garcia
	 */

	private static final long serialVersionUID = 1L;

	private VentanaDeCarga diccionario; // Panel que se mostrara cuando el usuario desee cargar un diccionario
	private PanelDeImagen panelImagen; // Sera la imagen que muestra la ventana principal
	private PanelDeConsultas panelConsulta; // Sera donde el usuario seleccione operaciones de traduccion
	private PanelDePalabras panelPalabras; // Sera donde el usuario agregue palabras a los diccionarios
	private PanelCantidad panelCantidad; // Mostrara la cantidad de palabras por idioma que hay en los diccionarios
	private PanelOpciones panelOps; // Mostrara los botones cargar diccionario y traducciones frecuentes
	private VentanaFrecuentes frecuentes; // Mostrara las traducciones mas buscadas por los usuarios

	private Control control; // Es el objeto que servira para comunicarse con el la clase Control

	public VentanaPrincipal(Control c) {
		// Inicializa las variables de la ventana principal
		panelImagen = new PanelDeImagen();
		panelConsulta = new PanelDeConsultas();
		panelPalabras = new PanelDePalabras();
		panelCantidad = new PanelCantidad();
		panelOps = new PanelOpciones();

		control = c;

		// Agrega el contenido de los variables de la clase a la ventana principal
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

		// Agrega escuchadores a los botones
		panelConsulta.getBotonTraducir().addActionListener(this);
		panelConsulta.getBotonLimpiar().addActionListener(this);

		panelPalabras.getBotonAgregar().addActionListener(this);
		panelPalabras.getBotonLimpiar().addActionListener(this);

		panelOps.getBotonCargar().addActionListener(this);
		panelOps.getBotonFrecuencia().addActionListener(this);

	}

	/*
	 * (Es el metodo que se encargara de comunicarse con la clase Control, por medio
	 * de las acciones que realiza el usuario y segun estas realizar una tarea.
	 * Mientras que envia las acciones a la clase Control para que puedan as�
	 * comunicarle a esta las mismas-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String comandoDeAccion = e.getActionCommand();

		try {
			// Panel De Consultas
			// Se determinan las comunicaciones y pasos a seguir por la clase segun lo que
			// haga el usuario en este panel
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
				
				String traduccion = control.buscarTraduccion(palabra, idiomaOrigen, idiomaDestino);
				if(traduccion != null) {					
					panelConsulta.getTextTraduccion().setText(traduccion);
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro traduccion");
				}
			}

			// Panel De Palabras
			// Se determinan las comunicaciones y pasos a seguir por la clase segun lo que
			// haga el usuario en este panel
			if (comandoDeAccion.equalsIgnoreCase("Agregar")) {

				String palabraNueva = panelPalabras.getPalabraSpa().getText();
				String palabraNuevaTrad = panelPalabras.getPalabraTradu().getText();
				String idioma = panelPalabras.getComboBoxIdioma().getSelectedItem().toString();

				try {
					control.agregarPalabra(palabraNueva, palabraNuevaTrad, idioma);
					this.actualizarCantidadPalabras();
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
			// Se determinan las comunicaciones y pasos a seguir por la clase segun lo que
			// haga el usuario en este panel
			if (comandoDeAccion.equalsIgnoreCase("Cargar Diccionario")) {
				diccionario = new VentanaDeCarga();

				diccionario.getBtnEng().addActionListener(this);
				diccionario.getBtnFra().addActionListener(this);
				diccionario.getBtnIta().addActionListener(this);
			}
			if (comandoDeAccion.equalsIgnoreCase("ENG")) {
				control.agregarDiccionario("ENG");
				this.actualizarCantidadPalabras();
				diccionario.dispose();
			}
			if (comandoDeAccion.equalsIgnoreCase("FRA")) {
				control.agregarDiccionario("FRA");
				this.actualizarCantidadPalabras();
				diccionario.dispose();
			}
			if (comandoDeAccion.equalsIgnoreCase("ITA")) {
				control.agregarDiccionario("ITA");
				this.actualizarCantidadPalabras();
				diccionario.dispose();
			}

			if (comandoDeAccion.equalsIgnoreCase("Traducciones Frecuentes")) {
				frecuentes = new VentanaFrecuentes();
				frecuentes.setResultados(this.control.obtenerPalabrasFrecuentes());
			}

			// Panel cantidad
			// Muestra la cantidad de palabras que hay por idioma en cada diccionario
			// respectivo

		} catch (NumberFormatException ex) {
			mostrarError();
			ex.printStackTrace();
		}
	}
	
	public void actualizarCantidadPalabras() {
		int[] numeroPalabras = this.control.actualizarNumeroPalabras();
		panelCantidad.setCantidadIngles(numeroPalabras[0]);
		panelCantidad.setCantidadFrances(numeroPalabras[1]);
		panelCantidad.setCantidadItaliano(numeroPalabras[2]);
	}

	/*
	 * Este metodo se utilizara para las excepciones de esta clase mostrando un
	 * mensaje al usuario de que ha sucedido un error
	 */
	public void mostrarError() {
		JOptionPane.showMessageDialog(null, "Lo siento, ha ocurrido un error.");
	}
}