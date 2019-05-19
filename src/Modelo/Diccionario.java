package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Diccionario {
	
	private ArrayList<Traduccion> traducciones;
	private ArrayList<Palabra> palabras;

	public Diccionario() {
		this.traducciones = new ArrayList<Traduccion>();
		this.palabras = new ArrayList<Palabra>();
	}
	
	public void agregarTraduccion ( String palabraOrigen, 
									String idiomaOrigen, 
									String palabraTraduccion,
									String idiomaTraduccion ) {
		// Se agregan las dos palabras
		Palabra palabraUno = this.agregarPalabra(palabraOrigen, idiomaOrigen);
		Palabra palabraDos = this.agregarPalabra(palabraTraduccion, idiomaTraduccion);
		
		// Se relaciona en una traduccion
		Traduccion traduccionPalabras = new Traduccion();
		traduccionPalabras.agregarPalabra(palabraUno);
		traduccionPalabras.agregarPalabra(palabraDos);
		
		// Se agrega la traduccion
		this.traducciones.add(traduccionPalabras);
	}
	
	private Palabra agregarPalabra ( String palabra, String idioma ) {
		for( Palabra registroPalabra: this.palabras ) {
			if( 
				registroPalabra.getPalabra().equalsIgnoreCase(palabra) && 
				registroPalabra.getIdioma().equalsIgnoreCase(idioma)
			) { 
				registroPalabra.setPalabra(palabra);
				registroPalabra.setIdioma(idioma);
				return registroPalabra;
			}
		}
		return new Palabra(palabra, idioma);
	}
	
	public String traducir ( String palabra,
							 String idiomaOrigen, 
							 String idiomaTraduccion ) {
		for(Traduccion traduccion: this.traducciones) {
			ArrayList<Palabra> palabras = traduccion.getTraducciones();
			for(Palabra registroPalabra: palabras) {
				if (
					registroPalabra.getPalabra().equalsIgnoreCase(palabra) &&
					registroPalabra.getIdioma().equalsIgnoreCase(idiomaOrigen)
				) {
					return buscarTraduccion(palabras, idiomaTraduccion);
				}
			}
		}
		return null;
	}
	
	private String buscarTraduccion (ArrayList<Palabra> palabras, String idiomaTraduccion) {
		for(Palabra registroPalabra: palabras) {
			if(registroPalabra.getIdioma().equalsIgnoreCase(idiomaTraduccion)) {
				return registroPalabra.getPalabra();
			}
		}
		return null;
	}
	
	public void agregarDiccionario( ArrayList<Traduccion> traducciones ) {
		this.traducciones = traducciones;
	}
	
	
	public ArrayList<String> obtenerIdiomas() {
		ArrayList<String> idiomas = new ArrayList<String>();
		
		for(int i = 0; i < this.palabras.size(); i++) {
			idiomas.add(this.palabras.get(i).getIdioma());
		}
		
		return idiomas;
	}
	
	public static void main(String[] args) {
		Diccionario diccionario = new Diccionario();
		diccionario.palabras.add(new Palabra("Hola", "Espanol"));
		diccionario.palabras.add(new Palabra("Desden", "Espanol"));
		diccionario.palabras.add(new Palabra("Hello", "Ingles"));
		diccionario.palabras.add(new Palabra("Bom", "Portuges"));
		
		int[] frecuencias = diccionario.frecuenciaPalabras();
		
		System.out.println("Ingles " + frecuencias[0]);
		System.out.println("Frances " + frecuencias[1]);
		System.out.println("Italiano " + frecuencias[2]);

		
	}	
	
	public int[] frecuenciaPalabras() { 
		ArrayList<String> idiomas = this.obtenerIdiomas();

		int[] palabras = new int[3];
		
		for(String idioma: idiomas) {
			switch(idioma) {
			case "Ingles":
				palabras[0] += 1;
				break;
			case "Frances":
				palabras[1] += 1;
				break;
			case "Italiano":
				palabras[2] += 1;
				break;
			default:
				break;
			}
		}
		
		return palabras;
    } 
}
