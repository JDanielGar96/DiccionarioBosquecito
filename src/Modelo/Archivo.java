package Modelo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Archivo {

	private File archivo;
	private String palabraEsp;
	private String palabraTraducida;
	private String idioma;

	public Archivo() throws IOException {
		this.archivo = new File("./Archivo/Archivo.txt");
		this.palabraEsp = "";
		this.palabraTraducida = "";
		this.idioma = "";
	}



	// Este metodo escribi de a una linea en el archivo
	public void agregarPalabra(String palabra, String traduccion, String idioma) {
		
		this.palabraEsp = palabra;
		this.palabraTraducida = traduccion;
		this.idioma = idioma;

		String escrito = this.palabraEsp + " " + this.palabraTraducida + " " + this.idioma;

		try {
			FileWriter escritura = new FileWriter(this.archivo, true);

			for (int i = 0; i < escrito.length(); i++) {
				escrito = escrito + escrito.charAt(i);
			}
			escrito += "\r\n";
			System.out.println(escrito);
			escritura.write(escrito);
			escritura.flush();
			escritura.close();

		} catch (IOException e) {
			System.out.print("No se guardaron los cambios.");
		}
	}

	// Este metodo lee todo el archivo y lo imprime
	public String mostrarDatos() {
		char letra = ' ';
		String s = "";
		try {
			FileReader entrada = new FileReader(archivo);
			int n = 0;
			while (n != -1) {
				System.out.print(s);
				letra = (char) n;
				s = String.valueOf(letra);
				n = entrada.read();
			}
			entrada.close();
		} catch (IOException e) {
			System.out.print("No se encontro el diccionario.");
		}

		return s;
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
