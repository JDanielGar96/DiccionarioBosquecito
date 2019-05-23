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
				
				String idiomaOrigen = panelConsulta.getComboBoxOrigen().getSelectedItem().toString();
				String palabraBuscada = panelConsulta.getTextPalabra().getText();
				String traduccion = panelConsulta.getTextTraduccion().getText();
				String idiomaDestino = panelConsulta.getComboBoxDestino().getSelectedItem().toString();
				
				String origen = (String) panelConsulta.getComboBoxOrigen().getSelectedItem();
				String destino = (String) panelConsulta.getComboBoxDestino().getSelectedItem();
				if (origen.equalsIgnoreCase(destino)) {
					JOptionPane.showMessageDialog(this, "No se puede traducir al mismo idioma. :V");
				}
				
				control.buscarTraduccion(palabraBuscada, idiomaOrigen, idiomaDestino, traduccion);
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
				control.cargarDiccionario();
				
				panelCantidad.setCantidadIngles(3);
				panelCantidad.setCantidadFrances(4);
				panelCantidad.setCantidadItaliano(4);
			}

			if (comandoDeAccion.equalsIgnoreCase("Palabras Frecuentes")) {
				control.frecuentes();
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