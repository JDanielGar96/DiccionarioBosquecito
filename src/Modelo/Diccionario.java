package Modelo;

import java.util.ArrayList;

public class Diccionario {
	
	private String nombre;
	private ArrayList<String> palabras;
	private ArrayList<String> traducciones;
	
	public Diccionario() {
		palabras = new ArrayList<String>();
		traducciones = new ArrayList<String>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getPalabras() {
		return palabras;
	}

	public void setPalabras(ArrayList<String> palabras) {
		this.palabras = palabras;
	}

	public ArrayList<String> getTraducciones() {
		return traducciones;
	}

	public void setTraducciones(ArrayList<String> traducciones) {
		this.traducciones = traducciones;
	}
}
