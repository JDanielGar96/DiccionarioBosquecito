package Controlador;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Ejecutor {

	public static void main(String[] args) {
		try {
			Control c = new Control();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ups, un error ha ocurrido.");
			e.printStackTrace();
		}
	}
}