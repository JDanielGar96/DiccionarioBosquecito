package Vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelCantidad extends JPanel {

	/**
	 * Es el panel que vera el usuario en la ventana principal que muestra la
	 * cantidad de palabras que hay por idioma en los diccionarios.
	 */

	private JLabel tituloCantidad; // Titulo intuitivo para el usuario
	private JLabel tituloDiccionario; // Titulo del diccionario
	private JLabel ingles; // Titulo de ingles
	private JLabel frances; // Titulo de frances
	private JLabel italiano; // Titulo de italiano
	private JLabel cantidadIngles; // Es donde se colocaran las palabras que hay de ingles en el diccioanrio
	private JLabel cantidadFrances; // Es donde se colocaran las palabras que hay de Frances en el diccioanrio
	private JLabel cantidadItaliano; // Es donde se colocaran las palabras que hay de Italiano en el diccioanrio

	public PanelCantidad() {
		// Inicializo variables
		tituloCantidad = new JLabel("Cantidad De Palabras");
		tituloDiccionario = new JLabel("Diccionario.");
		ingles = new JLabel("Ingles:");
		frances = new JLabel("Frances:");
		italiano = new JLabel("Italiano:");

		cantidadIngles = new JLabel("0");
		cantidadFrances = new JLabel("0");
		cantidadItaliano = new JLabel("0");

		// Agrego variables al panel
		add(tituloCantidad);
		add(tituloDiccionario);
		add(ingles);
		add(frances);
		add(italiano);
		add(cantidadIngles);
		add(cantidadFrances);
		add(cantidadItaliano);

		Initialize();
		setVisible(true);
	}

	private void Initialize() {
		setBounds(915, 11, 269, 189);
		setBackground(Color.GRAY);
		setLayout(null);

		// Labels o etiquetas
		tituloCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		tituloCantidad.setForeground(Color.YELLOW);
		tituloCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		tituloCantidad.setBounds(10, 11, 249, 23);

		tituloDiccionario.setHorizontalAlignment(SwingConstants.CENTER);
		tituloDiccionario.setForeground(Color.YELLOW);
		tituloDiccionario.setFont(new Font("Tahoma", Font.BOLD, 15));
		tituloDiccionario.setBounds(10, 36, 249, 23);

		ingles.setHorizontalAlignment(SwingConstants.LEFT);
		ingles.setForeground(Color.WHITE);
		ingles.setFont(new Font("Tahoma", Font.BOLD, 12));
		ingles.setBounds(10, 70, 120, 25);

		frances.setHorizontalAlignment(SwingConstants.LEFT);
		frances.setForeground(Color.WHITE);
		frances.setFont(new Font("Tahoma", Font.BOLD, 12));
		frances.setBounds(10, 104, 120, 25);

		italiano.setHorizontalAlignment(SwingConstants.LEFT);
		italiano.setForeground(Color.WHITE);
		italiano.setFont(new Font("Tahoma", Font.BOLD, 12));
		italiano.setBounds(10, 138, 120, 25);

		cantidadIngles.setBackground(Color.WHITE);
		cantidadIngles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cantidadIngles.setForeground(Color.BLACK);
		cantidadIngles.setBounds(140, 70, 119, 25);

		cantidadFrances.setBackground(Color.WHITE);
		cantidadFrances.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cantidadFrances.setForeground(Color.BLACK);
		cantidadFrances.setBounds(140, 104, 119, 25);

		cantidadItaliano.setBackground(Color.WHITE);
		cantidadItaliano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cantidadItaliano.setForeground(Color.BLACK);
		cantidadItaliano.setBounds(140, 140, 119, 25);

	}

	/*
	 * Este metodo coloca la cantidad de palabras que hay de ingles en la etiqueta
	 * cantidadIngles
	 */
	public void setCantidadIngles(int cantidadIngles) {
		this.cantidadIngles.setText(String.valueOf(cantidadIngles));
	}

	/*
	 * Este metodo coloca la cantidad de palabras que hay de frances en la etiqueta
	 * cantidadIngles
	 */
	public void setCantidadFrances(int cantidadFrances) {
		this.cantidadFrances.setText(String.valueOf(cantidadFrances));
	}

	/*
	 * Este metodo coloca la cantidad de palabras que hay de Italiano en la etiqueta
	 * cantidadIngles
	 */
	public void setCantidadItaliano(int cantidadItaliano) {
		this.cantidadItaliano.setText(String.valueOf(cantidadItaliano));
	}

}
