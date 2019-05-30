package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.RandomAccessFile;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

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
		archivo = new File("./Archivo/registroPalabras.dat"); // Inicializa la variable archivo

		try {
			RandomAccessFile accesor = new RandomAccessFile(archivo, "rw");

			if (accesor.length() != 0) {
				accesor.seek(accesor.length());
			}

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
				System.out.println(traduccion);
				accesor.writeInt(clave);
				accesor.writeChars(traduccion);
				clave++;
			}
			System.out.println("Registros escritos");
			accesor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			System.out.println("Error en ejecucion.");
		}
	}

	private void cargarRegistro() {
		this.registroPalabras = new ArrayList<String>();

		int clave = 0;
		archivo = new File("./Archivo/registroPalabras.dat");

		try {
			RandomAccessFile accesor = new RandomAccessFile(archivo, "rw");
			int cantidadRegistros = (int) (this.archivo.length() / 50);

			System.out.println("Cantidad de registros: " + cantidadRegistros);

			for (int numeroPalabra = 0; numeroPalabra < cantidadRegistros; numeroPalabra++) {

				clave = accesor.readInt();

				String palabra = "";

				for (int posicionPalabra = 0; posicionPalabra < 24; posicionPalabra++) {
					char letra = accesor.readChar();
					if (letra != ' ') {
						palabra += letra;
						System.out.println(letra + " " + posicionPalabra);
					}

				}
				System.out.println("Palabra " + palabra);
				this.registroPalabras.add(palabra);
			}

			System.out.println("Palabra con clave: " + clave);

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

	public String obtenerFrecuenciaPalabras() {
		Map<String, Long> frecuenciaPalabras = this.registroPalabras.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<String, Long> sorted = frecuenciaPalabras.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		return sorted.toString();
	}

//	public static void main(String[] args) {
//		ArchivadorFrecuencia frecuencia = new ArchivadorFrecuencia();
//		
////		frecuencia.agregarRegistro("Hola");
////		frecuencia.agregarRegistro("Chao");
////		frecuencia.agregarRegistro("Hola");
////		frecuencia.agregarRegistro("Hola");
////		
////		frecuencia.escribirRegistros();
//		
//		ArrayList<String> traducciones = frecuencia.obtenerTraducciones();
//		
//		System.out.println(frecuencia.obtenerFrecuenciaPalabras());
//	}
}
