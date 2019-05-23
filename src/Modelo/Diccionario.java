package Modelo;

import java.util.ArrayList;

import javax.swing.JFileChooser;

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
		for(int i = 0; i < this.palabras.size(); i++) {
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
	
	public void cargarDiccionario() {
    	JFileChooser fc =new JFileChooser();  
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
