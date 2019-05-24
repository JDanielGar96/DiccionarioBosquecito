package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class CargarDiccionario extends JFrame {

	private JButton btnFra;
	private JButton btnEng;
	private JButton btnIta;

	/**
	 * Create the application.
	 */
	public CargarDiccionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 420, 184);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnEng = new JButton("ENG");
		btnEng.setBounds(16, 82, 117, 42);
		getContentPane().add(btnEng);
		
		btnFra = new JButton("FRA");
		btnFra.setBounds(145, 82, 117, 42);
		getContentPane().add(btnFra);
		
		btnIta = new JButton("ITA");
		btnIta.setBounds(274, 82, 117, 42);
		getContentPane().add(btnIta);
		
		JLabel lblElijaElIdioma = new JLabel("Elija el idioma:");
		lblElijaElIdioma.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblElijaElIdioma.setBounds(128, 24, 160, 29);
		getContentPane().add(lblElijaElIdioma);
		
		setVisible(true);
	}
	
	public JButton getBtnFra() {
		return btnFra;
	}
	
	public JButton getBtnEng() {
		return btnEng;
	}

	public JButton getBtnIta() {
		return btnIta;
	}
}
