package Vista;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class VentanaFrecuentes extends JFrame {
	/**
	 * Esta clase servida para mostrar al usuario en un cuadro de texto las palabras
	 * que se traducen o buscan con mas frecuecia
	 */

	private JLabel titulo;
	private TextArea resultados;

	public VentanaFrecuentes() {
		// Inicializa las variables de la clase
		this.titulo = new JLabel("ESTAS SON LAS PALABRAS MAS TRADUCIDAS POR NUESTROS USUARIOS:");
		this.resultados = new TextArea();

		// Agrega el contenido de los variables de la clase
		getContentPane().add(this.titulo);
		getContentPane().add(resultados);

		initialize();
		setVisible(true);
	}

	private void initialize() {
		setTitle("Traducciones Frecuentes");
		getContentPane().setBackground(Color.BLACK);
		;
		setBounds(100, 100, 500, 350);
		getContentPane().setLayout(null);

		// Etiqueta
		this.titulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.titulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.titulo.setBackground(Color.GRAY);
		this.titulo.setForeground(Color.CYAN);
		this.titulo.setBounds(10, 11, 464, 43);

		// Cuadro de Texto
		this.resultados.setBounds(10, 65, 464, 210);

	}

	public void setResultados(String resultado) {
		this.resultados.setText(resultado);
	}

}