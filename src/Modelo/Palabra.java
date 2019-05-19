package Modelo;

import java.util.ArrayList;

public class Palabra {
	private ArrayList<String[]> palabras;
	
	public Palabra() {
		palabras = new ArrayList<String[]>();
	}
	
	public void agregarPalabra(String palabra, String idioma) {
		String[] tupla = { palabra, idioma };
		this.palabras.add(tupla);
	}

	public ArrayList<String[]> getPalabras() {
		return palabras;
	}

	public void setPalabras(ArrayList<String[]> palabras) {
		this.palabras = palabras;
	}
}
