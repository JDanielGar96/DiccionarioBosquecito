package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Esta clase permite al programa guardar o escribir registros de las palabras agregadas
 * por el usuario por medio de un archivo dat, escribiendo la palabra en espanol
 * la traduccion y el idioma de dicha traduccion
 * @author Oscar Romero y Daniel Garcia
 *
 */
public class Archivo {

	private File archivo;
	private RandomAccessFile accesoRandomArchivo;
	private InputStreamReader isr;
	private BufferedReader linea;
	private String linea_Archivo;

	private int clave; // Va a asignar un numero automaticamente a cada registro - 4 bites
	private String palabraEsp; // 25 caracteres maximo - 50 bites
	private String palabraTraducida; // 25 caracteres maximo - 50 bites
	private String idioma; // 25 caracteres maximo - 50 bites

	private static int tamanoDelRegistro; // va a controlar el numero de bites por registro
	private long numeroDeRegistros; // sera la cantidad de registros hechos en el archivo

	public Archivo() throws IOException {
		this.archivo = new File("./Archivo/Archivo.dat");
		this.accesoRandomArchivo = new RandomAccessFile(this.archivo, "rw");
		this.isr = new InputStreamReader(System.in);
		this.linea = new BufferedReader(isr);
		this.linea_Archivo = "";

		this.clave = 0;
		this.palabraEsp = "";
		this.palabraTraducida = "";
		this.idioma = "";

		this.tamanoDelRegistro = 154;
		this.numeroDeRegistros = 0;

	}

	/*
	 * Este metodo escribe una nueva palabra en el archivo recibiendo tres cadenas
	 * de texto como argumentos la palabra en espanol, la traduccion y el idioma de
	 * traduccion
	 */
	public void agregarPalabra(String palabra, String traduccion, String idioma) {
		try {
			// Calcula el numero de registros
			this.numeroDeRegistros = this.archivo.length() / this.tamanoDelRegistro;
			for (int i = 0; i < this.numeroDeRegistros; i++) {
				this.clave = i;
			}

			this.palabraEsp = palabra;
			this.palabraTraducida = traduccion;
			this.idioma = idioma;

			// Deja las cadenas de texto de las variables en la longitud adecuada
			// es decir en la longitud definida al inicio de esta clase
			if (this.palabraEsp.length() < 25) {
				for (int i = this.palabraEsp.length(); i < 25; i++)
					this.palabraEsp = this.palabraEsp + " ";
			}
			if (this.palabraTraducida.length() < 25) {
				for (int i = this.palabraTraducida.length(); i < 25; i++)
					this.palabraTraducida = this.palabraTraducida + " ";
			}
			if (this.idioma.length() < 25) {
				for (int i = this.idioma.length(); i < 25; i++)
					this.idioma = this.idioma + " ";

			} else {
				this.palabraEsp = this.palabraEsp.substring(0, 25);
				this.palabraTraducida = this.palabraTraducida.substring(0, 25);
				this.idioma = this.idioma.substring(0, 25);
			}

			// Guarda o escribe en el archivo lo recibido
			if (this.accesoRandomArchivo.length() != 0) {
				// Se posiciona al final del ultimo registro
				this.accesoRandomArchivo.seek(this.accesoRandomArchivo.length());
			}
			this.accesoRandomArchivo.writeInt(this.clave);
			// Recordatorio: cada caracter se guarda en 2 bits
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

//	/*
//	 * Este metodo permite buscar una palabra en el archivo
//	 * Recibiendo una variable que sera palabra buscada
//	 * retornando la clave, la palabra en espanol, la palabra traducida y el idioma de traduccion
//	 */
//	public String buscarPalabra(String palabra) throws IOException {
//
//		try {
//			// Se posiciona al inicio del registro deseado
//			this.accesoRandomArchivo.seek(this.clave * this.tamanoDelRegistro); // El argumento es de tipo long
//			this.clave = this.linea.read();
//
//			// Se lee la cadena de texto
//			for (int i = 0; i < 25; ++i) {
//				this.palabraEsp += this.linea.readLine();
//			}
//			for (int i = 0; i < 25; ++i) {
//				this.palabraTraducida += linea.readLine();
//			}
//			for (int i = 0; i < 25; ++i) {
//				this.idioma += linea.read();
//			}
//
//			linea_Archivo = this.clave + " " + this.palabraEsp + " " + this.palabraTraducida + " " + this.idioma;
//
//			// Se limpian las cadenas de texto o java encadena con lo siguiente
//			this.palabraEsp = "";
//			this.palabraTraducida = "";
//			this.idioma = "";
//			this.linea.close();
//
//		} catch (FileNotFoundException fnfe) {
//			JOptionPane.showMessageDialog(null, "La palabra busca no pudo ser encontrada.");
//		} catch (IOException ioe) {
//			JOptionPane.showMessageDialog(null, "Ups no se pudo mostrar la palabra traducida.");
//		}
//		return linea_Archivo;
//	}
//	
//	public String guardarPalabraEsp(String pEsp) {
//	return this.palabraEsp = pEsp;
//  }
//
//  public String guardarPalabraTraducida(String pTradu) {
//	return this.palabraTraducida = this.palabraTraducida + pTradu;
//  }
//
//  public void actualizarNumeroDePalabras() {
//  }

}
