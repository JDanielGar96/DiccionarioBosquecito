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

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comandoDeAccion = e.getActionCommand();
		this.opcion = "";
		try {
			// Panel De Consultas
			String origen = "";
			String destino = "";
			if (comandoDeAccion.equalsIgnoreCase("Limpiar")) {
				panelConsulta.getTextPalabra().setText("");
				panelConsulta.getTextTraduccion().setText("");
			} else {
				origen = (String) panelConsulta.getComboBoxOrigen().getSelectedItem();
				destino = (String) panelConsulta.getComboBoxDestino().getSelectedItem();
				if (origen.equalsIgnoreCase(destino)) {
					JOptionPane.showMessageDialog(this, "Verifica las entradas");
				}
			}
			if (comandoDeAccion.equalsIgnoreCase("Traducir")) {
				opcion = "TRADUCIR";
			}
			// Panel De Palabras
			if (comandoDeAccion.equalsIgnoreCase("Limpiar")) {
				panelPalabras.getPalabraSpa().setText("");
				panelPalabras.getPalabraTradu().setText("");
			}
			if (comandoDeAccion.equalsIgnoreCase("Agregar")) {
				opcion = "AGREGAR PALABRA";
				String palabra = panelPalabras.getPalabraSpa().getText();
				String traduccion = panelPalabras.getPalabraTradu().getText();
				String idioma = panelPalabras.getComboBoxIdioma().getSelectedItem().toString();
				control.agregarPalabra(opcion, palabra, traduccion, idioma);
			}

		} catch (NumberFormatException ex) {
			mostrarError();
			ex.printStackTrace();
		}
	}

	public void mostrarError() {
		JOptionPane.showMessageDialog(null, "Lo siento, ha ocurrido un error.");
	}

}