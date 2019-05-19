package Modelo;

import java.util.ArrayList;

public class Traduccion {
	private ArrayList<Palabra> traducciones;
	
	public Traduccion() {
		traducciones = new ArrayList<Palabra>();
	}
	
	public void agregarPalabra(String palabra, String idioma) {
		Palabra registroPalabra = new Palabra(palabra, idioma);
		this.traducciones.add(registroPalabra);
	}

	public void agregarPalabra(Palabra palabra) {
		this.traducciones.add(palabra);
	}
	
	public ArrayList<Palabra> getTraducciones() {
		return traducciones;
	}

	public void setTraducciones(ArrayList<Palabra> traducciones) {
		this.traducciones = traducciones;
	}
}
