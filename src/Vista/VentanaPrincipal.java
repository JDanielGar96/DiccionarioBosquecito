package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Controlador.Control;

public class VentanaPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private PanelDeImagen panelImagen;
	private PanelDeConsultas panelConsulta;
	private PanelDePalabras panelPalabras;
	private PanelCantidad panelCantidad;
	private PanelOpciones panelOps;

	private Control control;
	private String opcion;

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
		panelOps.getBoton().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comandoDeAccion = e.getActionCommand();
		this.opcion = "";

		// Panel Consultas
		String idiomaOrigen = panelConsulta.getComboBoxOrigen().getSelectedItem().toString();
		String palabraBuscada = panelConsulta.getTextPalabra().getText();
		String traduccion = panelConsulta.getTextTraduccion().getText();
		String idiomaDestino = panelConsulta.getComboBoxDestino().getSelectedItem().toString();

		// Panel Palabras
		String palabraNueva = panelPalabras.getPalabraSpa().getText();
		String palabraNuevaTrad = panelPalabras.getPalabraTradu().getText();
		String idioma = panelPalabras.getComboBoxIdioma().getSelectedItem().toString();
		try {
			// Panel De Consultas
			if (comandoDeAccion.equalsIgnoreCase("Limpiar")) {
				panelConsulta.getTextPalabra().setText("");
				panelConsulta.getTextTraduccion().setText("");
			} else {
				String origen = (String) panelConsulta.getComboBoxOrigen().getSelectedItem();
				String destino = (String) panelConsulta.getComboBoxDestino().getSelectedItem();
				if (origen.equalsIgnoreCase(destino)) {
					JOptionPane.showMessageDialog(this, "Verifica las entradas");
				}
			}
			if (comandoDeAccion.equalsIgnoreCase("Traducir")) {
				opcion = "TRADUCIR PALABRA";
				control.buscarTraduccion(opcion, palabraBuscada, idiomaOrigen, idiomaDestino, traduccion);
			}

			// Panel de palabras
			if (comandoDeAccion.equalsIgnoreCase("Agregar")) {
				opcion = "AGREGAR PALABRA";
				control.agregarPalabra(opcion, palabraNueva, palabraNuevaTrad, idioma);
				JOptionPane.showMessageDialog(this, "La palabra fue agregada");
			}

			if (comandoDeAccion.equalsIgnoreCase("Limpiar") && e.getSource().equals(panelPalabras.getBotonLimpiar())) {
				panelPalabras.getPalabraSpa().setText("");
				panelPalabras.getPalabraTradu().setText("");
			}
			// Panel De Operaciones
			if (comandoDeAccion.equalsIgnoreCase("Cargar Diccionario")) {
				opcion = "CARGAR DICCIONARIO";
				control.cargarDiccionario(opcion);
			}

			if (comandoDeAccion.equalsIgnoreCase("Palabras Frecuentes")) {
				opcion = "FRECUENTES";
				control.frecuentes();
			}

			// Panel cantidad
			panelCantidad.setCantidadIngles(control.actualizarNumPalIng());
			panelCantidad.setCantidadFrances(control.actualizarNumFr());
			panelCantidad.setCantidadItaliano(control.actualizarNumIta());

		} catch (NumberFormatException ex) {
			mostrarError();
			ex.printStackTrace();
		}
	}

	public void mostrarError() {
		JOptionPane.showMessageDialog(null, "Lo siento, ha ocurrido un error.");
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

}