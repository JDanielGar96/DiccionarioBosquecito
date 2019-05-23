package Modelo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoAleatorio {
	
	private File archivo;
	private String palabraEsp;
	private String palabraTraducida;
	private String idioma;

	public ArchivoAleatorio() throws IOException {
		archivo = new File("./archivoSecuencial.txt");
		palabraEsp = "";
		palabraTraducida = "";
		idioma = "";
	}
	
	//Carga el diccionario
	
	public void cargarDiccionario() {
		
	}

	// Este metodo escribi de a una linea en el archivo 
	public void agregarPalabra(String entrada) {
		String escrito = "";
		try {
			FileWriter escritura = new FileWriter(archivo, true);

			for (int i = 0; i < entrada.length(); i++) {
				escrito = escrito + entrada.charAt(i);
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

	// Este metodod lee todo el archivo y lo imprime
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
			System.out.print("No se encontro el archivo.");
		}

		return s;
	}

	public String guardarPalabraEsp(String pEsp) {
		return this.palabraEsp = pEsp;
	}

	public String guardarPalabraTraducida(String pTradu) {
		return this.palabraTraducida = this.palabraTraducida + pTradu;
	}


//	public Double actualizarArchivo() {
//		if (this.palabraEsp == null) {
//			System.out.print("Agregue una palabra en español primero");
//		} else {
//			for (int i = 0; i <  ; i++) {
//				 = ;
//			}
//		}
//		return ;
//	}

//	public void CerrarOperaciones(String cerrar) {
//
//	        }
//		}
//	}
}
