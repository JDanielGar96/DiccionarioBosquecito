package Modelo;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import java.util.Properties;

/**
 * 
 * [Modelo encargado de las estructura del diccionario]
 * @author DANIEL AND OSCAR
 * @version 0.5
 * 
 */
public class Diccionario {
	
	private String nombre;
	private ArrayList<String> palabras;
	private ArrayList<String> traducciones;
	
	/**
	 * [Constructor que recibe el nombre del diccionario]
	 * @param nombre
	 */
	public Diccionario(String nombre) {
		this.nombre = nombre;
		this.palabras = new ArrayList<String>();
		this.traducciones = new ArrayList<String>();
	}
	
	/**
	 * [Recibe una palabra y su traduccion para agregarla al diccionario]
	 * 
	 * @param palabra
	 * @param traduccion
	 * @return boolean 
	 */
	public boolean agregarPalabra(String palabra, String traduccion) {
		// TODO -> ADD WORD VERIFICATION
		this.palabras.add(palabra);
		this.traducciones.add(traduccion);
		return true;
	}
	
	/**
	 * [Recibe una palabra y retorna la traduccion de la misma]
	 * @param palabra
	 * @return String
	 */
	public String traduccionPalabra(String palabra) {
		System.out.println(this.palabras.size());
		for(int i = 0; i < this.palabras.size(); i++) {
			System.out.println(this.palabras.get(i));
			if(this.palabras.get(i).equalsIgnoreCase(palabra)) {
				return this.traducciones.get(i);
			}
		}
		return null;
	}
	
	/**
	 * [Recibe una palabra en el otro idioma y retorna la traduccion en espanol de la misma]
	 * @param palabra
	 * @return String
	 */
	public String traduccionInversaPalabra(String palabra) {
		for(int i = 0; i < this.traducciones.size(); i++) {
			if(this.traducciones.get(i).equalsIgnoreCase(palabra)) {
				return this.palabras.get(i);
			}
		}
		return null;
	}
	
	
	/**
	 * [Retorna la cantidad de traducciones en el diccionario]
	 * @return
	 */
	public int contarTraducciones() {
		return this.traducciones.size();
	}
	
	// Este metodo permite al usuario cargar un diccionario (Un archivo)

	public void cargarDiccionario(String direccion) {
		Properties propiedades = new Properties();
		
		try {
			propiedades.load(new FileInputStream(direccion));
		} catch (Exception e) {
			System.out.println("No se puede abrir el archivo");
		}
		
		this.agregarPalabras(propiedades.getProperty("diccionario.esp").split(","));
		this.agregarTraducciones(propiedades.getProperty("diccionario.traduccion").split(","));
	}
	
	/**
	 * Agrega palabras al diccionario.
	 * @param palabras
	 */
	public void agregarPalabras(String[] palabras) {
		for(int i = 0; i < palabras.length; i++) {
			this.palabras.add(palabras[i]);
		}
	}
	
	/**
	 * Agrega traducciones al diccionario.
	 * @param palabras
	 */
	public void agregarTraducciones(String[] palabras) {
		for(int i = 0; i < palabras.length; i++) {
			this.traducciones.add(palabras[i]);
		}
	}
	
	
	public String obtenerNombre() {
		return nombre;
	}

	public void modificarNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> obtenerPalabras() {
		return palabras;
	}

	public void modificarPalabras(ArrayList<String> palabras) {
		this.palabras = palabras;
	}

	public ArrayList<String> obtenerTraducciones() {
		return traducciones;
	}

	public void modificarTraducciones(ArrayList<String> traducciones) {
		this.traducciones = traducciones;
	}
}
