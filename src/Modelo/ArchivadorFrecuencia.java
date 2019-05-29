package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.io.RandomAccessFile;

/**
 * Esta clase se encargara de guardar en un archivo dat los registros de las
 * palabras que busca el usuario a traves de la vista, con la finalidad de poder
 * determinar las palabras mas traducidas o mas frecuentes
 * 
 * @author Oscar Romero y Daniel Garcia
 *
 */
public class ArchivadorFrecuencia {

	private File archivo; // Sera donde se guarden las palabras que se traducen
	private ArrayList<String> registroPalabras; // Sera la lista de palabras traducidas por el usuario

	/*
	 * Es el constructor de la clase que inicializa las variables y el metodo
	 * cargarRegistro
	 */
	public ArchivadorFrecuencia() {
		this.registroPalabras = new ArrayList<String>();
		this.cargarRegistro();
	}

	/*
	 * Este metodo se encaga de agregar un registro de una traduccion realizada por
	 * el usuario
	 */
	public void agregarRegistro(String traduccion) {
		this.registroPalabras.add(traduccion);
	}

	/*
	 * Este metodo escribe o guarda los regristros de los registros agregados
	 */
	public void escribirRegistros() {
		int clave = 0;
		archivo = new File("./datos/registroPalabras.dat"); // Inicializa la variable archivo

		try {
			RandomAccessFile accesor = new RandomAccessFile(archivo, "rw");
			for (String traduccion : this.registroPalabras) {
				int longitudTraduccion = traduccion.length();
				// Se encarga de dejar en una longitud definida la traduccion
				if (longitudTraduccion < 25) {
					for (int caracter = 1; caracter < 25 - longitudTraduccion; caracter++) {
						traduccion += " ";
					}
				} else {
					traduccion.substring(0, 25);
				}
				accesor.writeInt(clave);
				accesor.writeChars(traduccion);
				clave++;
			}
			accesor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			System.out.println("Error en ejecucion.");
		}
	}

	private void cargarRegistro() {
		int clave = 0;
		archivo = new File("./datos/registroPalabras.dat");

		try {
			RandomAccessFile accesor = new RandomAccessFile(archivo, "rw");
			int cantidadRegistros = (int) (this.archivo.length() / 50);
			System.out.println(cantidadRegistros);
			for (int numeroPalabra = 0; numeroPalabra < cantidadRegistros; numeroPalabra++) {
				String palabra = "";
				for (int posicionPalabra = 0; posicionPalabra < 25; posicionPalabra++) {
					char caracter = accesor.readChar();
					if (caracter != ' ') {
						palabra += caracter;
					}
				}
				this.registroPalabras.add(palabra);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			System.out.println("Error en ejecucion.");
			System.out.println(e);
		}
	}

	public ArrayList<String> obtenerTraducciones() {
		return this.registroPalabras;
	}
}
