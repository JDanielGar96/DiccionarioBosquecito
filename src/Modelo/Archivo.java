package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Archivo {

	private String ruta;
	private File Archivo;
	private RandomAccessFile accesoRandom;
	private InputStreamReader isr;
	private BufferedReader linea;
	private String linea_Archivo;
	private FileWriter linea_dat;

	private int registro; // Se guarda automaticamente para identificar la palabra - 4 bites
	private String palabra; // 50 caracteres maximo - 100 bites
	private String idioma; // 50 caracteres maximo - 100 bites

	private static int tamanoRegistro;
	private long numeroDeRegistros;

	public Archivo() throws IOException {
		ruta = "./Diccionario.dat";
		Archivo = new File(ruta);
		accesoRandom = new RandomAccessFile(Archivo, "rw");
		isr = new InputStreamReader(System.in);
		linea = new BufferedReader(isr);
		linea_Archivo = "";
		linea_dat = new FileWriter(linea_Archivo);

		registro = 0;
		palabra = "";
		idioma = "";

		tamanoRegistro = 204;
		numeroDeRegistros = 0;
	}

	// Metodo que permite a un usuario encontrar un diccionario
	public void cargarDiccionario() {
		JFileChooser elegirArchivo = new JFileChooser(System.getProperty("user.dir"));
		elegirArchivo.showOpenDialog(elegirArchivo);
		Archivo = elegirArchivo.getSelectedFile(); // returns the contacts file to be read

		if (Archivo.exists()) {
			JOptionPane.showMessageDialog(null, "El diccionario: " + Archivo.getName() + " fue abierto exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Lo lamentamos el diccionaro no pudo ser abierto");
		}
	}

	// Metodo que lee archivo diccionario
	public String buscarPalabra(String palabra, String idioma) throws IOException {
		try {
			// se posiciona al principio del registro deseado
			accesoRandom.seek(registro * tamanoRegistro); // Argument is long type
			registro = linea.read();

			// Leyendo String
			for (int i = 0; i < 50; ++i) {
				this.palabra += linea.readLine();
			}
			for (int i = 0; i < 50; ++i) {
				this.idioma += linea.readLine();
			}

			linea_Archivo = palabra + " " + idioma;
			// clean strings or java chains with the next expression
			this.palabra = "";
			this.idioma = "";

		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "The contacts information could not be opened.");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Sorry, could not read the contacts information.");
		}
		return linea_Archivo;
	}

	// Metodo que escribe sobre el archivo del diccionario guardando nuevas palabras
	public void agregarPalabra(String palabra, String idioma) {
		try {
			// Calcula el numero de registros
			numeroDeRegistros = Archivo.length() / tamanoRegistro;
			for (int i = 0; i < numeroDeRegistros; i++) {
				registro = i;
			}

			this.palabra = palabra;
			this.idioma = idioma;

			// Deja el String en 50 caracteres
			if (palabra.length() < 50) {
				for (int i = palabra.length(); i < 25; i++)
					this.palabra = palabra + " ";
			}
			if (idioma.length() < 50) {
				for (int i = idioma.length(); i < 35; i++)
					this.idioma = idioma + " ";
			}

			// Guardando la palabra
			if (accesoRandom.length() != 0) {
				// is positioned at the end of the last record
				accesoRandom.seek(accesoRandom.length());
			}
			accesoRandom.writeInt(this.registro);
			// reminder each character is saved in two bytes
			accesoRandom.writeChars(palabra);
			accesoRandom.writeChars(idioma);
			accesoRandom.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "Ups, el diccionario no pudo ser encontrado.");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Ups, no fue posible agregar la palabra.");
		}
	}
}
