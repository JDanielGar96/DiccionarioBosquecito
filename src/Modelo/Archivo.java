package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Archivo {

	private File archivo;
	private RandomAccessFile accesoRandomArchivo;
	private InputStreamReader isr;
	private BufferedReader linea;
	private String linea_Archivo;
//	private FileWriter linea_Dat;

	private int clave; // Va a asigar un numero automaticamente a cada registro - 4 bites
	private String palabraEsp; // 100 caracteres maximo - 200 bites
	private String palabraTraducida; // 100 caracteres maximo - 200 bites
	private String idioma; // 25 caracteres maximo - 50 bites

	private static int tamanoDelRegistro;
	private long numeroDeRegistros;

	public Archivo() throws IOException {
		this.archivo = new File("./Archivo/Archivo.txt");
		this.accesoRandomArchivo = new RandomAccessFile(this.archivo, "rw");
		this.isr = new InputStreamReader(System.in);
		this.linea = new BufferedReader(isr);
		this.linea_Archivo = "";
//		this.linea_Dat = new FileWriter(this.linea_Archivo);

		this.clave = 0;
		this.palabraEsp = "";
		this.palabraTraducida = "";
		this.idioma = "";

		this.tamanoDelRegistro = 454;
		this.numeroDeRegistros = 0;

	}

	// Este metodo permite al usuario cargar un diccionario (Un archivo)

	public void cargarDiccionario() {
		JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
		fc.showOpenDialog(fc);
		this.archivo = fc.getSelectedFile(); // Devuelve el diccionario para ser leido

		if (this.archivo.exists()) {
			JOptionPane.showMessageDialog(null,
					"El diccionario " + this.archivo.getName() + " fue cargado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Lo siento el diccionario no pudo ser cargado");
		}
	}

	// Method that writes over the contacts file saving new contacts in the agenda
	public void agregarPalabra(String palabra, String traduccion, String idioma) {
		try {
			// Calculating number of records
			this.numeroDeRegistros = this.archivo.length() / this.tamanoDelRegistro;
			for (int i = 0; i < this.numeroDeRegistros; i++) {
				this.clave = i;
			}

			this.palabraEsp = palabra;
			this.palabraTraducida = traduccion;
			this.idioma = idioma;

			// Dejando los strings en la longitud adecuada
			if (this.palabraEsp.length() < 100) {
				for (int i = this.palabraEsp.length(); i < 100; i++)
					this.palabraEsp = this.palabraEsp + " ";
			}
			if (this.palabraTraducida.length() < 100) {
				for (int i = this.palabraTraducida.length(); i < 100; i++)
					this.palabraTraducida = this.palabraTraducida + " ";
			}
			if (this.idioma.length() < 40) {
				for (int i = this.idioma.length(); i < 40; i++)
					this.idioma = this.idioma + " ";

			} else {
				this.palabraEsp = this.palabraEsp.substring(0, 25);
				this.palabraTraducida = this.palabraTraducida.substring(0, 35);
				this.idioma = this.idioma.substring(0, 40);
			}

			// Se guarda o escribe en el archivo lo recibido
			if (this.accesoRandomArchivo.length() != 0) {
				// Se posiciona al final del ultimo registro
				this.accesoRandomArchivo.seek(this.accesoRandomArchivo.length());
			}
			this.accesoRandomArchivo.writeInt(this.clave);
			// Recordatorio cada caracter se guarda en 2 bits
			this.accesoRandomArchivo.writeChars(this.palabraEsp);
			this.accesoRandomArchivo.writeChars(this.palabraTraducida);
			this.accesoRandomArchivo.writeChars(this.idioma);
			this.accesoRandomArchivo.close();

		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "Ups! El diccionario no pudo ser encontrado.");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Ouch! No se pudo agregar la palabra.");
		}
	}

	// Metodo que busca la palabra traducida segun el idioma
	public String searchContactsInfo() throws IOException {

		try {
			// is positioned at the beginning of the desired record
			this.accesoRandomArchivo.seek(this.clave * this.tamanoDelRegistro); // El argumento es de tipo long
			this.clave = this.linea.read();

			// String reading
			for (int i = 0; i < 100; ++i) {
				this.palabraEsp += this.linea.readLine();
			}
			for (int i = 0; i < 100; ++i) {
				this.palabraTraducida += linea.readLine();
			}
			for (int i = 0; i < 50; ++i) {
				this.idioma += linea.read();
			}

//			linea_Archivo = this.clave + " " + this.palabraEsp + " " + this.palabraTraducida + " " + this.idioma;
			linea_Archivo = this.palabraEsp;
			// Se limpian los strings o java encadena con lo siguiente
			this.palabraEsp = "";
			this.palabraTraducida = "";
			this.idioma = "";
			this.linea.close();

		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "La palabra busca no pudo ser encontrada.");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Ups no se pudo mostrar la palabra traducida.");
		}
		return linea_Archivo;
	}

	public String guardarPalabraEsp(String pEsp) {
		return this.palabraEsp = pEsp;
	}

	public String guardarPalabraTraducida(String pTradu) {
		return this.palabraTraducida = this.palabraTraducida + pTradu;
	}

	public void actualizarNumeroDePalabras() {
	}
}
