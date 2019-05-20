package Modelo;

import java.util.ArrayList;

public class Diccionario {
	
	private String nombre;
	private ArrayList<String> palabras;
	private ArrayList<String> traducciones;
	
	public Diccionario(String nombre) {
		this.nombre = nombre;
		this.palabras = new ArrayList<String>();
		this.traducciones = new ArrayList<String>();
	}
	
	public boolean agregarPalabra(String palabra, String traduccion) {
		// TODO -> ADD WORD VERIFICATION
		this.palabras.add(palabra);
		this.traducciones.add(traduccion);
		return true;
	}
	
	public int contarTraducciones() {
		return this.traducciones.size();
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
